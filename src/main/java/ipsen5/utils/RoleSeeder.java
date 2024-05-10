package ipsen5.utils;

import ipsen5.dao.RoleRepository;
import ipsen5.models.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    private RoleRepository roleRepository;

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

        Role role4 = new Role();
        role4.setName("Registered User");
        roleRepository.save(role4);
    }
}
