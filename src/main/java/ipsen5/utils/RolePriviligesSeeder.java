package ipsen5.utils;

import ipsen5.dao.RolePriviligesRepository;
import ipsen5.dao.RoleRepository;
import ipsen5.models.Role;
import ipsen5.models.RolePriviliges;
import ipsen5.models.RolePriviligesId;
import ipsen5.models.enums.Rights;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePriviligesSeeder {
    private RoleRepository roleRepository;
    private RolePriviligesRepository rolePriviligesRepository;

    public RolePriviligesSeeder(RoleRepository roleRepository, RolePriviligesRepository rolePriviligesRepository) {
        this.roleRepository = roleRepository;
        this.rolePriviligesRepository = rolePriviligesRepository;
    }

    public void seedRolePriviliges(){
        List<Role> allRoles = roleRepository.findAll();

        RolePriviliges rolePriviliges = new RolePriviliges();
        RolePriviligesId rolePriviligesId = new RolePriviligesId(allRoles.get(0), Rights.POSTEN);
        rolePriviliges.setId(rolePriviligesId);
        rolePriviligesRepository.save(rolePriviliges);

        RolePriviliges rolePriviliges2 = new RolePriviliges();
        RolePriviligesId rolePriviligesId2 = new RolePriviligesId(allRoles.get(0), Rights.GETTEN);
        rolePriviliges2.setId(rolePriviligesId2);
        rolePriviligesRepository.save(rolePriviliges2);

        RolePriviliges rolePriviliges3 = new RolePriviliges();
        RolePriviligesId rolePriviligesId3 = new RolePriviligesId(allRoles.get(0), Rights.UPDATEN);
        rolePriviliges3.setId(rolePriviligesId3);
        rolePriviligesRepository.save(rolePriviliges3);

        RolePriviliges rolePriviliges4 = new RolePriviliges();
        RolePriviligesId rolePriviligesId4 = new RolePriviligesId(allRoles.get(0), Rights.DELETEN);
        rolePriviliges4.setId(rolePriviligesId4);
        rolePriviligesRepository.save(rolePriviliges4);
    }
}
