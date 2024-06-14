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

        Rights[] rightsArrayForAdmin = {
                Rights.ALL, Rights.GUARD_USER_ROLES, Rights.GUARD_SUBMISSIONS, Rights.GUARD_ROLES
        };


        Rights[] rightsArrayForModerator = {
                Rights.SUBMISSION, Rights.USER, Rights.STATUS,
                Rights.SOCIALMEDIA, Rights.RUBRIC, Rights.ROLEPRIVILIGES, Rights.ROLE,
                Rights.REACTION, Rights.RATING, Rights.POSTCATEGORY, Rights.POST,
                Rights.FEEDBACKPERELEMENT, Rights.CRITERIA, Rights.CATEGORY,
                Rights.GUARD_SUBMISSIONS
        };

        Rights[] rightsArrayForRole2 = {
                Rights.SUBMISSION, Rights.USER, Rights.STATUS,
                Rights.SOCIALMEDIA, Rights.RUBRIC,
                Rights.REACTION, Rights.RATING, Rights.POSTCATEGORY, Rights.POST_GET,
                Rights.FEEDBACKPERELEMENT_GET
        };

        for (Rights rights : rightsArrayForAdmin) {
            RolePriviliges rolePriviliges = new RolePriviliges();
            RolePriviligesId rolePriviligesId = new RolePriviligesId(allRoles.get(0), rights);
            rolePriviliges.setId(rolePriviligesId);
            rolePriviligesRepository.save(rolePriviliges);
        }


        for (Rights rights : rightsArrayForModerator) {
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
