package ipsen5.controller;

import ipsen5.dao.RoleDAO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Role;
import ipsen5.services.RoleValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(this.roleDAO.getAllRoles());
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getRoleByName(@PathVariable String name) {
        return roleDAO.findRoleByName(name)
                .map(role -> ResponseEntity.ok("Role name: " + role.getName()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found"));
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody RoleDTO roleDTO){
        roleValidator.roleValidations(roleDTO);
        this.roleDAO.createRole(roleDTO);
        String message = "deleted role with id: " + roleDTO.name;
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editRole(@PathVariable UUID id, @RequestBody RoleDTO roleDTO){
        roleValidator.roleValidations(roleDTO);
        this.roleDAO.editRole(id, roleDTO);
        return ResponseEntity.ok("Edited role with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") UUID id){
        this.roleDAO.deleteRole(id);
        String message = "deleted role with id: " + id;
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");
    }
}
