package ipsen5.controller;

import ipsen5.dao.RolePriviligesDAO;
import ipsen5.dto.RolePriviligesDTO;
import ipsen5.models.RolePriviliges;
import ipsen5.models.RolePriviligesId;
import ipsen5.models.enums.Rights;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rolepriviliges")
public class RolePriviligesController {

    private final RolePriviligesDAO rolePriviligesDAO;

    public RolePriviligesController(RolePriviligesDAO rolePriviligesDAO) {
        this.rolePriviligesDAO = rolePriviligesDAO;
    }

    @GetMapping
    public ResponseEntity<List<RolePriviliges>> getAllRolePriviliges() {
        return ResponseEntity.ok(this.rolePriviligesDAO.getAllRolePriviliges());
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<RolePriviliges>> getRolePriviligesByRoleId(@PathVariable UUID roleId) {
        List<RolePriviliges> rolePriviliges = this.rolePriviligesDAO.getRolePriviligesByRoleId(roleId);
        return ResponseEntity.ok(rolePriviliges);
    }

    @PostMapping
    public ResponseEntity<String> createRolePriviliges(@RequestBody RolePriviligesDTO rolePriviligesDTO) {
        this.rolePriviligesDAO.saveRolePriviliges(rolePriviligesDTO);
        return ResponseEntity.ok("Created a new RolePriviliges with roleId " + rolePriviligesDTO.role + " and rightsId " + rolePriviligesDTO.rights);
    }

    @DeleteMapping("/{roleId}/{rights}")
    public ResponseEntity<String> deleteRolePriviliges(@PathVariable UUID roleId, @PathVariable Rights rights) {
        this.rolePriviligesDAO.deleteRolePriviliges(roleId, rights);
        return ResponseEntity.ok("Deleted RolePriviliges with roleId " + roleId + " and privilegeId " + rights);
    }
}
