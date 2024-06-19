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
        assertEquals(3, foundSubmissions.size());
        assertEquals("test1", foundSubmissions.get(0).getName());
        assertEquals("test2", foundSubmissions.get(1).getName());
    }

    @Test
    public void testGetAllSubmissionsEmpty() {
        when(submissionRepository.findAll()).thenReturn(Collections.emptyList());

        List<Submission> foundSubmissions = submissionService.getAllSubmissions();

        assertNotNull(foundSubmissions);
        assertTrue(foundSubmissions.isEmpty());
    }

    @Test
    public void testGetSubmissionById() {

        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));


        Optional<Submission> foundSubmission = submissionService.getSubmissionById(submission.getId());


        assertTrue(foundSubmission.isPresent());
        assertEquals(submission.getId(), foundSubmission.get().getId());
        assertEquals("test1", foundSubmission.get().getName());

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetSubmissionByIdNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        Optional<Submission> foundSubmission = submissionService.getSubmissionById(submission.getId());

        assertFalse(foundSubmission.isPresent());

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetSubmissionByUserId() {
        when(submissionRepository.findAll()).thenReturn(submissions);

        List<Submission> foundSubmissions = submissionService.getSubmissionByUserId(user1.getId());

        assertNotNull(foundSubmissions);
        assertEquals(1, foundSubmissions.size());
        assertEquals(submission.getId(), foundSubmissions.get(0).getId());

        verify(submissionRepository, times(1)).findAll();
    }

    @Test
    public void testGetSubmissionByUserIdNoMatches() {
        when(submissionRepository.findAll()).thenReturn(submissions);

        List<Submission> foundSubmissions = submissionService.getSubmissionByUserId(UUID.randomUUID());

        assertNotNull(foundSubmissions);
        assertTrue(foundSubmissions.isEmpty());

        verify(submissionRepository, times(1)).findAll();
    }

    @Test
    public void testCreateSubmissionText() {
        submissionDTO.type = "Text";
        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        Submission createdSubmission = submissionService.createSubmission(submissionDTO);

        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(0), createdSubmission.getRubric());

        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testCreateSubmissionAudio() {
        submissionDTO.type = "Audio";

        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission2);

        Submission createdSubmission = submissionService.createSubmission(submissionDTO);

        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(1), createdSubmission.getRubric());

        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testCreateSubmissionVideo() {
        submissionDTO.type = "Video";

        when(rubricRepository.findAll()).thenReturn(rubrics);
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission3);

        Submission createdSubmission = submissionService.createSubmission(submissionDTO);

        assertNotNull(createdSubmission);
        assertEquals(rubrics.get(2), createdSubmission.getRubric());

        verify(rubricRepository, times(1)).findAll();
        verify(submissionRepository, times(1)).save(any(Submission.class));
    }

    @Test
    public void testSaveSubmissionPdf() throws IOException {
        byte[] fileContent = "Test PDF content".getBytes();

        when(file.getBytes()).thenReturn(fileContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        submissionService.saveSubmissionPdf(file, submission.getId());

        assertArrayEquals(fileContent, submission.getPdf());

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).save(submission);
    }

    @Test
    public void testSaveSubmissionPdfSubmissionNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            submissionService.saveSubmissionPdf(file, submission.getId());
        });

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).save(any(Submission.class));
    }

    @Test
    public void testSaveSubmissionPicture() throws IOException {
        byte[] fileContent = "Test Picture content".getBytes();

        when(file.getBytes()).thenReturn(fileContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));
        when(submissionRepository.save(any(Submission.class))).thenReturn(submission);

        submissionService.saveSubmissionPicture(file, submission.getId());

        assertArrayEquals(fileContent, submission.getPicture());

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).save(submission);
    }

    @Test
    public void testSaveSubmissionPictureSubmissionNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            submissionService.saveSubmissionPicture(file, submission.getId());
        });

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).save(any(Submission.class));
    }

    @Test
    public void testGetUserPdf() {
        byte[] pdfContent = "Test PDF content".getBytes();
        submission.setPdf(pdfContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        byte[] result = submissionService.getUserPdf(submission.getId());

        assertNotNull(result);
        assertArrayEquals(submission.getPdf(), result);

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetUserPdfSubmissionNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        byte[] result = submissionService.getUserPdf(submission.getId());

        assertNull(result);

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetUserPicture() {
        byte[] pictureContent = "Test Picture content".getBytes();
        submission.setPicture(pictureContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        byte[] result = submissionService.getUserPicture(submission.getId());

        assertNotNull(result);
        assertArrayEquals(submission.getPicture(), result);

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testGetUserPictureSubmissionNotFound() {
        byte[] pictureContent = "Test Picture content".getBytes();
        submission.setPicture(pictureContent);
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        byte[] result = submissionService.getUserPicture(submission.getId());

        assertNull(result);

        verify(submissionRepository, times(1)).findById(submission.getId());
    }

    @Test
    public void testEditSubmission() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        SubmissionDTO updatedDTO = new SubmissionDTO();
        updatedDTO.setType("Audio");
        updatedDTO.setStory_title("Updated title");

        submissionService.editSubmission(submission.getId(), updatedDTO);

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).save(submission);

        assertEquals(updatedDTO.getType(), submission.getType());
        assertEquals(updatedDTO.getStory_title(), submission.getStory_title());
    }

    @Test
    public void testEditSubmissionNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        SubmissionDTO updatedDTO = new SubmissionDTO();
        updatedDTO.setType("Audio");
        updatedDTO.setStory_title("Updated Title");

        assertThrows(RuntimeException.class, () -> {
            submissionService.editSubmission(submission.getId(), updatedDTO);
        });

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).save(any());
    }

    @Test
    public void testDeleteSubmission() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.of(submission));

        submissionService.deleteSubmission(submission.getId());

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, times(1)).deleteById(submission.getId());
    }

    @Test
    public void testDeleteSubmissionNotFound() {
        when(submissionRepository.findById(submission.getId())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            submissionService.deleteSubmission(submission.getId());
        });

        verify(submissionRepository, times(1)).findById(submission.getId());
        verify(submissionRepository, never()).deleteById(any());
    }
}
