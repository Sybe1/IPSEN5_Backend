package ipsen5.services;

import ipsen5.dto.FeedbackDTO;
import ipsen5.dto.SubmissionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubmissionValidator {
    private InputValidator inputValidator;

    public SubmissionValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void submissionValidations(SubmissionDTO submissionDTO) {
        if (!inputValidator.isValidDescription(submissionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Submission provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.feedbackID)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid feedback provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.user_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.statusID)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid status provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.extra_feedback)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid feedback provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.story_Details)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Story details provided"
            );
        }
    }
}
