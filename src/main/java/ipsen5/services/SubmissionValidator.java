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


    private Boolean express_experience;


    public void submissionValidations(SubmissionDTO submissionDTO) {
        if (!inputValidator.isValidDescription(submissionDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
//        if (!inputValidator.isValidDescription(submissionDTO.email)) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "No valid email provided"
//            );
//        }

        if (!inputValidator.isValidDescription(submissionDTO.story_title)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid story title provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.type)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid type provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.wordCount)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Submission provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.additional_notes)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Submission provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.genre)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid genre provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.prefferd_destination)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid prefferd destination provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.platform_presence)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid awnser provided"
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
        if (!inputValidator.isNotNull(submissionDTO.express_experience)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid anwser provided"
            );
        }
        if (!inputValidator.isNotNull(submissionDTO.extra_feedback)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid feedback provided"
            );
        }
        if (!inputValidator.isValidDescription(submissionDTO.story_title)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid Story title provided"
            );
        }
    }
}
