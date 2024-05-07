package ipsen5.controller;

import ipsen5.dao.SubmissionDAO;
import ipsen5.dto.SubmissionDTO;
import ipsen5.models.Submission;
import ipsen5.services.UserInputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/submission")
public class SubmissionController {
    private final SubmissionDAO submissionDAO;
    private UserInputValidator validator;

    public SubmissionController(SubmissionDAO submissionDAO) {
        this.submissionDAO = submissionDAO;
        this.validator = validator;
    }
    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions(){
        return ResponseEntity.ok(this.submissionDAO.getAllSubmissions());
    }

    @PostMapping
    public ResponseEntity<String> createSubmission(@RequestBody SubmissionDTO submissionDTO){
        if (!validator.isValidDescription(submissionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Submission provided"
            );
        }
        if (!validator.isNotNull(submissionDTO.post_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid submission provided"
            );
        }
        this.submissionDAO.createSubmission(submissionDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editSubmission(@PathVariable UUID id, @RequestBody SubmissionDTO submissionDTO){
        if (!validator.isNotNull(submissionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid grade provided"
            );
        }
        if (!validator.isNotNull(submissionDTO.post_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid post provided"
            );
        }
        this.submissionDAO.editSubmission(id, submissionDTO);
        return ResponseEntity.ok("Edited Submission with id: " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable("id") UUID id){
        this.submissionDAO.deleteSubmission(id);
        return ResponseEntity.ok("deleted Submission with id: " + id);
    }
}

