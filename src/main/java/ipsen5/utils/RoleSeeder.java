package ipsen5.utils;

import ipsen5.repository.RoleRepository;
import ipsen5.models.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void seedRole(){
        Role role = new Role();
        role.setName("Admin");
        roleRepository.save(role);

        Role role2 = new Role();
        role2.setName("Moderator");
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName("Creator");
        roleRepository.save(role3);
    }
}
