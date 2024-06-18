package ipsen5.services;

import ipsen5.models.RolePriviliges;
import ipsen5.models.User;
import ipsen5.repository.RolePriviligesRepository;
import ipsen5.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userDAO;
    private final RolePriviligesRepository rolePriviligesRepository;

    public UserService(UserRepository userDAO, RolePriviligesRepository rolePriviligesRepository) {
        this.userDAO = userDAO;
        this.rolePriviligesRepository = rolePriviligesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        List<RolePriviliges> rolePriviliges = rolePriviligesRepository.findByIdRoleId(user.getRole());

        List<SimpleGrantedAuthority> authorities = rolePriviliges.stream()
                .map(rolePrivilige -> new SimpleGrantedAuthority(rolePrivilige.getId().getRightsId().name()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}
