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

        Rights[] rightsArrayForRole1 = {
                Rights.SUBMISSION, Rights.USER, Rights.STATUS,
                Rights.SOCIALMEDIA, Rights.RUBRIC, Rights.ROLEPRIVILIGES, Rights.ROLE,
                Rights.REACTION, Rights.RATING, Rights.POSTCATEGORY, Rights.POST,
                Rights.FEEDBACKPERELEMENT, Rights.CRITERIA, Rights.CATEGORY
        };

        Rights[] rightsArrayForRole2 = {
                Rights.SUBMISSION, Rights.USER, Rights.STATUS,
                Rights.SOCIALMEDIA, Rights.RUBRIC,
                Rights.REACTION, Rights.RATING, Rights.POSTCATEGORY, Rights.POST_GET,
                Rights.FEEDBACKPERELEMENT_GET
        };

        RolePriviliges rolePriviliges2 = new RolePriviliges();
        RolePriviligesId rolePriviligesId2 = new RolePriviligesId(allRoles.get(0), Rights.ALL);
        rolePriviliges2.setId(rolePriviligesId2);
        rolePriviligesRepository.save(rolePriviliges2);

        for (Rights rights : rightsArrayForRole1) {
            RolePriviliges rolePriviliges = new RolePriviliges();
            RolePriviligesId rolePriviligesId = new RolePriviligesId(allRoles.get(1), rights);
            rolePriviliges.setId(rolePriviligesId);
            rolePriviligesRepository.save(rolePriviliges);
        }

        for (Rights rights : rightsArrayForRole2) {
            RolePriviliges rolePriviliges = new RolePriviliges();
            RolePriviligesId rolePriviligesId = new RolePriviligesId(allRoles.get(2), rights);
            rolePriviliges.setId(rolePriviligesId);
            rolePriviligesRepository.save(rolePriviliges);
        }
    }

}
