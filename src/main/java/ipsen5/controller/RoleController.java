package ipsen5.controller;

import ipsen5.dao.RoleDAO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {

    private final RoleDAO roleDAO;

    public RoleController(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(this.roleDAO.getAllRoles());
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody RoleDTO roleDTO){
        this.roleDAO.createRole(roleDTO);
        return ResponseEntity.ok("Created a new Role named " + roleDTO.name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        this.roleDAO.editRole(id, roleDTO);
        return ResponseEntity.ok("Edited role with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Long id){
        this.roleDAO.deleteRole(id);
        return ResponseEntity.ok("deleted role with id: " + id);
    }
}
