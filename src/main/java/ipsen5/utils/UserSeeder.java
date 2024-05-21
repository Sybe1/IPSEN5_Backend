package ipsen5.utils;

import ipsen5.dao.RoleRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Role;
import ipsen5.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSeeder {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserSeeder(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void seedUser(){
        List<Role> allRoles = roleRepository.findAll();

        User user = new User();
        user.setFirst_name("Mick");
        user.setLast_name("van Amstel");
        user.setEmail("mvamstel@mail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user.setDonation_link("https://www.paypal.com/nl/home");
        user.setUser_icon("https://randomuser.me/api/portraits/men/91.jpg");
        user.setRole(allRoles.get(0));
        userRepository.save(user);

        User user2 = new User();
        user2.setFirst_name("Pim");
        user2.setLast_name("van Dijk");
        user2.setEmail("pvdijk@mail.com");
        user2.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user2.setDonation_link("https://www.paypal.com/nl/home");
        user2.setUser_icon("https://randomuser.me/api/portraits/men/97.jpg");
        user2.setRole(allRoles.get(1));
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirst_name("Johan");
        user3.setLast_name("Kopers");
        user3.setEmail("j.kopers@mail.com");
        user3.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user3.setDonation_link("https://www.paypal.com/nl/home");
        user3.setUser_icon("https://randomuser.me/api/portraits/men/94.jpg");
        user3.setRole(allRoles.get(2));
        userRepository.save(user3);
    }

}
