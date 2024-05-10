package ipsen5.services;

import ipsen5.dto.FeedbackDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FeedbackValidator {
    private InputValidator inputValidator;

    public FeedbackValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void feedbackValidations(FeedbackDTO feedbackDTO) {
        if (!inputValidator.isValidDescription(feedbackDTO.general_text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid text provided"
            );
        }
        if (!inputValidator.isNotNull(feedbackDTO.user)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
        if (!inputValidator.isNotNull(feedbackDTO.rubric)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid rubric provided"
            );
        }
    }
}
