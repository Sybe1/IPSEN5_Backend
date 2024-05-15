package ipsen5.controller;

import ipsen5.dao.RolePriviligesDAO;
import ipsen5.dto.RolePriviligesDTO;
import ipsen5.models.*;
import ipsen5.models.enums.Rights;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolepriviliges")
public class RolePriviligesController {

    private final RolePriviligesDAO rolePriviligesDAO;

    public RolePriviligesController(RolePriviligesDAO rolePriviligesDAO) {
        this.rolePriviligesDAO = rolePriviligesDAO;
    }

    @GetMapping
    public ResponseEntity<List<RolePriviliges>> getPostCategories() {
        return ResponseEntity.ok(this.rolePriviligesDAO.getPostCategories());
    }

    @PostMapping
    public  ResponseEntity<String> createRolePriviliges(@RequestBody RolePriviligesDTO rolePriviligesDTO) {
        this.rolePriviligesDAO.createRolePriviliges(rolePriviligesDTO);
        return ResponseEntity.ok("Created a new RolePriviliges with RoleID " + rolePriviligesDTO.role + "and RightsID " + rolePriviligesDTO.rights);
    }

    @DeleteMapping("/{roleId}/{rightsId}")
    public ResponseEntity<?> deleteRolePriviliges(@PathVariable Role roleId, @PathVariable Rights rightsId) {
        this.rolePriviligesDAO.deleteRolePriviliges(roleId, rightsId);
        return ResponseEntity.ok("Deleted RolePriviliges with RoleID " + roleId + "and RightsID " + rightsId);
    }
}


