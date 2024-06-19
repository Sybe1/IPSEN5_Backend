package ipsen5.controller;

import ipsen5.services.RolePriviligesService;
import ipsen5.dto.RolePriviligesDTO;
import ipsen5.models.RolePriviliges;
import ipsen5.models.enums.Rights;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://clownfish-app-5x89u.ondigitalocean.app"})
@RequestMapping("/rolepriviliges")
public class RolePriviligesController {

    private final RolePriviligesService rolePriviligesService;

    public RolePriviligesController(RolePriviligesService rolePriviligesService) {
        this.rolePriviligesService = rolePriviligesService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLEPRIVILIGES_GET') || hasAuthority('ROLEPRIVILIGES') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<RolePriviliges>> getAllRolePriviliges() {
        return ResponseEntity.ok(this.rolePriviligesService.getAllRolePriviliges());
    }

    @GetMapping("/{roleId}")
    @PreAuthorize("hasAuthority('ROLEPRIVILIGES_GET') || hasAuthority('ROLEPRIVILIGES') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<RolePriviliges>> getRolePriviligesByRoleId(@PathVariable UUID roleId) {
        List<RolePriviliges> rolePriviliges = this.rolePriviligesService.getRolePriviligesByRoleId(roleId);
        return ResponseEntity.ok(rolePriviliges);
    }

    @GetMapping("/{roleId}/{rights}")
    public ResponseEntity<?> getRolePriviligesByRoleId(@PathVariable UUID roleId, @PathVariable Rights rights) {
        Optional<RolePriviliges> optionalRolePrivilige = this.rolePriviligesService.getRolePriviligesByRoleIdAndRights(roleId, rights);

        if (optionalRolePrivilige.isPresent()) {
            return ResponseEntity.ok(optionalRolePrivilige.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("RolePriviliges with roleId " + roleId + " and rights " + rights + " not found");
        }
    }


    @PostMapping
    @PreAuthorize("hasAuthority('ROLEPRIVILIGES_POST') || hasAuthority('ROLEPRIVILIGES') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createRolePriviliges(@RequestBody RolePriviligesDTO rolePriviligesDTO) {
        this.rolePriviligesService.saveRolePriviliges(rolePriviligesDTO);
        return ResponseEntity.ok("Created a new RolePriviliges with roleId " + rolePriviligesDTO.role + " and rightsId " + rolePriviligesDTO.rights);
    }

    @DeleteMapping("/{roleId}/{rights}")
    @PreAuthorize("hasAuthority('ROLEPRIVILIGES_DELETE') || hasAuthority('ROLEPRIVILIGES') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<String> deleteRolePriviliges(@PathVariable UUID roleId, @PathVariable Rights rights) {
        this.rolePriviligesService.deleteRolePriviliges(roleId, rights);
        return ResponseEntity.ok("Deleted RolePriviliges with roleId " + roleId + " and privilegeId " + rights);
    }
}
