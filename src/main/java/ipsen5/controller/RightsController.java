package ipsen5.controller;

import ipsen5.dao.RightsDAO;
import ipsen5.dto.RightsDTO;
import ipsen5.models.Rights;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rights")
public class RightsController {

    private final RightsDAO rightsDAO;

    public RightsController(RightsDAO rightsDAO) {
        this.rightsDAO = rightsDAO;
    }

    @GetMapping
    public ResponseEntity<List<Rights>> getAllRights(){
        return ResponseEntity.ok(this.rightsDAO.getAllRights());
    }

    @PostMapping
    public ResponseEntity<String> createRights(@RequestBody RightsDTO rightsDTO){
        this.rightsDAO.createRights(rightsDTO);
        return ResponseEntity.ok("Created a new Rights named " + rightsDTO.name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editRights(@PathVariable Long id, @RequestBody RightsDTO rightsDTO){
        this.rightsDAO.editRights(id, rightsDTO);
        return ResponseEntity.ok("Edited rights with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRights(@PathVariable("id") Long id){
        this.rightsDAO.deleteRights(id);
        return ResponseEntity.ok("deleted rights with id: " + id);
    }
}

