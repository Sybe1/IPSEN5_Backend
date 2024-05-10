package ipsen5.services;

import ipsen5.dto.FeedbackDTO;
import ipsen5.dto.FeedbackPerElementDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FeedbackPerElementValidator {
    private InputValidator inputValidator;

    public FeedbackPerElementValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void feedbackPerElementValidations(FeedbackPerElementDTO feedbackPerElementDTO) {
        if (!inputValidator.isValidDescription(feedbackPerElementDTO.feedback)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid feedback provided"
            );
        }
        if (!inputValidator.isNotNull(feedbackPerElementDTO.grade) || feedbackPerElementDTO.grade < 0 || feedbackPerElementDTO.grade > 10) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid grade provided. It has to be between 0 and 10."
            );
        }
    }
}
