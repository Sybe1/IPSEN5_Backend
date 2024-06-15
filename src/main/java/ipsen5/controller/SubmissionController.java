package ipsen5.controller;

import ipsen5.dao.SubmissionDAO;
import ipsen5.dto.SubmissionDTO;
import ipsen5.models.Submission;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/submission")
public class SubmissionController {
    private final SubmissionDAO submissionDAO;

    public SubmissionController(SubmissionDAO submissionDAO) {
        this.submissionDAO = submissionDAO;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUBMISSION_GET') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<Optional<Submission>> getSubmissionById(@PathVariable UUID id){
        return ResponseEntity.ok(this.submissionDAO.getSubmissionById(id));
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('SUBMISSION_GET') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Submission>> getSubmissionByUserId(@PathVariable UUID id){
        return ResponseEntity.ok(this.submissionDAO.getSubmissionByUserId(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SUBMISSION_GET') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Submission>> getAllSubmissions(){
        return ResponseEntity.ok(this.submissionDAO.getAllSubmissions());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SUBMISSION_POST') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<Submission> createSubmission(@RequestBody SubmissionDTO submissionDTO){
        Submission submission = this.submissionDAO.createSubmission(submissionDTO);
        return ResponseEntity.ok(submission);
    }
    @GetMapping("/{id}/pdf")
    @PreAuthorize("hasAuthority('SUBMISSION_GET') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<byte[]> getUserPdf(@PathVariable UUID id) {
        byte[] pdf = submissionDAO.getUserPdf(id);
        if (pdf != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SUBMISSION_PUT') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editSubmission(@PathVariable UUID id, @RequestBody SubmissionDTO submissionDTO){
        this.submissionDAO.editSubmission(id, submissionDTO);
        return ResponseEntity.ok("Edited Submission with id: " + id);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SUBMISSION_DELETE') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteSubmission(@PathVariable("id") UUID id){
        this.submissionDAO.deleteSubmission(id);
        return ResponseEntity.ok("deleted Submission with id: " + id);
    }


    @PostMapping("/{submissionId}/pdf" )
    @PreAuthorize("hasAuthority('SUBMISSION_POST') || hasAuthority('SUBMISSION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<Void> uploadUserPdf(@RequestParam("file") MultipartFile file, @PathVariable("submissionId") UUID id) {
        try {
            System.out.println("hup");
            submissionDAO.saveSubmissionPdf(file, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

