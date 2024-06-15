package ipsen5.controller;

import ipsen5.dao.RoleDAO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Role;
import ipsen5.services.RoleValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {

    private final RoleDAO roleDAO;
    private RoleValidator roleValidator;

    public RoleController(RoleDAO roleDAO, RoleValidator roleValidator) {
        this.roleDAO = roleDAO;
        this.roleValidator = roleValidator;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_GET') || hasAuthority('ROLE') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(this.roleDAO.getAllRoles());
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('ROLE_GET') || hasAuthority('ROLE') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<Optional<Role>> getRoleByName(@PathVariable String name) {
        return ResponseEntity.ok(roleDAO.findRoleByName(name));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_POST') || hasAuthority('ROLE') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<?> createRole(@RequestBody RoleDTO roleDTO){
        roleValidator.roleValidations(roleDTO);
        this.roleDAO.createRole(roleDTO);
        String message = "deleted role with id: " + roleDTO.name;
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_PUT') || hasAuthority('ROLE') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editRole(@PathVariable UUID id, @RequestBody RoleDTO roleDTO){
        roleValidator.roleValidations(roleDTO);
        this.roleDAO.editRole(id, roleDTO);
        return ResponseEntity.ok("Edited role with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE') || hasAuthority('ROLE') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteRole(@PathVariable("id") UUID id){
        this.roleDAO.deleteRole(id);
        String message = "deleted role with id: " + id;
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");
    }
}
