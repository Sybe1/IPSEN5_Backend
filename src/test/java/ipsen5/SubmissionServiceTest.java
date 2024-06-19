package ipsen5;

import ipsen5.models.Submission;
import ipsen5.repository.RubricRepository;
import ipsen5.repository.SubmissionRespository;
import ipsen5.services.SubmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SubmissionServiceTest {

    @Mock
    private SubmissionRespository submissionRepository;
    private RubricRepository rubricRepository;

    @InjectMocks
    private SubmissionService submissionService;

    private Submission submission;
    private Submission submission2;
    private List submissions;

    @BeforeEach
    public void setup(){
        submissionRepository = Mockito.mock(SubmissionRespository.class);
        submissionService = new SubmissionService(submissionRepository, rubricRepository);
        submission = new Submission();
        submission.setId(UUID.randomUUID());
        submission.setName("test1");
        submission2 = new Submission();
        submission2.setId(UUID.randomUUID());
        submission2.setName("test2");
        submissions = Arrays.asList(submission, submission2);

    }

    @Test
    public void testGetAllSubmissions() {

        when(submissionRepository.findAll()).thenReturn(submissions);

        List<Submission> foundSubmissions = submissionService.getAllSubmissions();

        assertNotNull(foundSubmissions);
        assertEquals(2, foundSubmissions.size());
        assertEquals("test1", foundSubmissions.get(0).getName());
        assertEquals("test2", foundSubmissions.get(1).getName());
    }

    @Test
    public void testGetAllRolesEmpty() {
        when(submissionRepository.findAll()).thenReturn(Collections.emptyList());

        List<Submission> foundSubmissions = submissionService.getAllSubmissions();

        assertNotNull(foundSubmissions);
        assertTrue(foundSubmissions.isEmpty());
    }

    @Test
    public void testGetSubmissionById() {
        // Mock the repository call
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        // Call the service method
        Optional<Submission> foundSubmission = submissionService.getSubmissionById(submission.getId());

        // Verify the result
        assertTrue(foundSubmission.isPresent());
        assertEquals(submission.getId(), foundSubmission.get().getId());
        assertEquals("test1", foundSubmission.get().getName()); // Adjust according to your Submission fields

        // Verify the repository method was called once
        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetSubmissionByIdNotFound() {
        // Mock the repository call
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        // Call the service method
        Optional<Submission> foundSubmission = submissionService.getSubmissionById(submission.getId());

        // Verify the result
        assertFalse(foundSubmission.isPresent());

        // Verify the repository method was called once
        verify(submissionRepository, times(1)).findById(submission.getId());
    }


}
