package ipsen5.repository;

import ipsen5.models.Role;
import ipsen5.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    User findByUsername(String username);

    List<User> findByRole(Role role);
}
