package ipsen5;

import ipsen5.dto.SubmissionDTO;
import ipsen5.models.Rubric;
import ipsen5.models.Submission;
import ipsen5.models.User;
import ipsen5.repository.RubricRepository;
import ipsen5.repository.SubmissionRespository;
import ipsen5.services.SubmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    private Submission submission3;
    private List submissions;

    private User user1;
    private User user2;
    private User user3;

    private List<Rubric> rubrics;
    private SubmissionDTO submissionDTO;

    @Mock
    private MultipartFile file;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

        submissionRepository = Mockito.mock(SubmissionRespository.class);
        rubricRepository = Mockito.mock(RubricRepository.class);
        submissionService = new SubmissionService(submissionRepository, rubricRepository);

        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setId(UUID.randomUUID());
        user1.setFirst_name("testUser1");
        user2.setId(UUID.randomUUID());
        user2.setFirst_name("testUser2");
        user3.setId(UUID.randomUUID());
        user3.setFirst_name("testUser3");

        Rubric rubric1 = new Rubric("Text Rubric");
        rubric1.setId(UUID.randomUUID());
        Rubric rubric2 = new Rubric("Audio Rubric");
        rubric2.setId(UUID.randomUUID());
        Rubric rubric3 = new Rubric("Video Rubric");
        rubric3.setId(UUID.randomUUID());
        rubrics = Arrays.asList(rubric1, rubric2, rubric3);

        submission = new Submission();
        submission.setId(UUID.randomUUID());
        submission.setRubric(rubric1);
        submission.setName("test1");
        submission.setUser_id(user1);

        submission2 = new Submission();
        submission2.setId(UUID.randomUUID());
        submission2.setRubric(rubric2);
        submission2.setName("test2");
        submission2.setUser_id(user2);

        submission3 = new Submission();
        submission3.setId(UUID.randomUUID());
        submission3.setRubric(rubric3);
        submission3.setName("test3");
        submission3.setUser_id(user3);

        submissions = Arrays.asList(submission, submission2, submission3);

        submissionDTO = new SubmissionDTO();




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

    @Test
    public void testGetSubmissionByUserId() {
        // Mock the repository call
        when(submissionRepository.findAll()).thenReturn(submissions);

        // Call the service method
        List<Submission> foundSubmissions = submissionService.getSubmissionByUserId(user1.getId());

        // Verify the result
        assertNotNull(foundSubmissions);
        assertEquals(1, foundSubmissions.size());
        assertEquals(submission.getId(), foundSubmissions.get(0).getId());

        // Verify the repository method was called once
        verify(submissionRepository, times(1)).findAll();
    }

    @Test
    public void testGetSubmissionByUserIdNoMatches() {
        // Mock the repository call
        when(submissionRepository.findAll()).thenReturn(submissions);

        // Call the service method
        List<Submission> foundSubmissions = submissionService.getSubmissionByUserId(UUID.randomUUID());

        // Verify the result
        assertNotNull(foundSubmissions);
        assertTrue(foundSubmissions.isEmpty());

        // Verify the repository method was called once
        verify(submissionRepository, times(1)).findAll();
    }

    @Test
    public void testCreateSubmissionText() {
        submissionDTO.type = "Text";
        // Mock the repository call
        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        // Call the service method
        Submission createdSubmission = submissionService.createSubmission(submissionDTO);

        // Verify the result
        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(0), createdSubmission.getRubric());

        // Verify the repository methods were called once
        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testCreateSubmissionAudio() {
        // Adjust the DTO type for this test
        submissionDTO.type = "Audio";

        // Mock the repository call
        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission2);

        // Call the service method
        Submission createdSubmission = submissionService.createSubmission(submissionDTO);
        // Verify the result
        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(1), createdSubmission.getRubric());


        // Verify the repository methods were called once
        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testCreateSubmissionVideo() {
        // Adjust the DTO type for this test
        submissionDTO.type = "Video";

        // Mock the repository call
        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission3);

        // Call the service method
        Submission createdSubmission = submissionService.createSubmission(submissionDTO);

        // Verify the result
        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(2), createdSubmission.getRubric());

        // Verify the repository methods were called once
        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testSaveSubmissionPdf() throws IOException {
        byte[] fileContent = "Test PDF content".getBytes();

        // Mock the behavior of file and repository methods
        when(file.getBytes()).thenReturn(fileContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        // Call the service method
        submissionService.saveSubmissionPdf(file, submission.getId());

        // Verify that the PDF content was set correctly
        assertArrayEquals(fileContent, submission.getPdf());

        // Verify repository methods were called
        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).save(submission);
    }

    @Test
    public void testSaveSubmissionPdfSubmissionNotFound() {
        // Mock the behavior of repository methods
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        // Expect a RuntimeException when the submission is not found
        assertThrows(RuntimeException.class, () -> {
            submissionService.saveSubmissionPdf(file, submission.getId());
        });

        // Verify repository methods were called
        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).save(any(Submission.class));
    }

    @Test
    public void testSaveSubmissionPicture() throws IOException {
        byte[] fileContent = "Test Picture content".getBytes();

        // Mock the behavior of file and repository methods
        when(file.getBytes()).thenReturn(fileContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        // Call the service method
        submissionService.saveSubmissionPicture(file, submission.getId());

        // Verify that the picture content was set correctly
        assertArrayEquals(fileContent, submission.getPicture());

        // Verify repository methods were called
        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).save(submission);
    }

    @Test
    public void testSaveSubmissionPictureSubmissionNotFound() {
        // Mock the behavior of repository methods
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        // Expect a RuntimeException when the submission is not found
        assertThrows(RuntimeException.class, () -> {
            submissionService.saveSubmissionPicture(file, submission.getId());
        });

        // Verify repository methods were called
        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).save(any(Submission.class));
    }

    @Test
    public void testGetUserPdf() {
        byte[] pdfContent = "Test PDF content".getBytes();
        submission.setPdf(pdfContent);
        // Mock the behavior of repository methods
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        // Call the service method
        byte[] result = submissionService.getUserPdf(submission.getId());

        // Verify the PDF content was returned correctly
        assertNotNull(result);
        assertArrayEquals(submission.getPdf(), result);

        // Verify repository method was called
        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetUserPdfSubmissionNotFound() {
        // Mock the behavior of repository methods
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        // Call the service method
        byte[] result = submissionService.getUserPdf(submission.getId());

        // Verify that the result is null
        assertNull(result);

        // Verify repository method was called
        verify(submissionRepository, times(1)).findById(submission.getId());
    }





}
