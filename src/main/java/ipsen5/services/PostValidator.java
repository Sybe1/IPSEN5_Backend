package ipsen5.services;

import ipsen5.dto.FeedbackDTO;
import ipsen5.dto.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PostValidator {
    private InputValidator inputValidator;

    public PostValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void postValidations(PostDTO postDTO) {
        if (!inputValidator.isValidDescription(postDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid text provided"
            );
        }
        if (!inputValidator.isNotNull(postDTO.user)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
    }
}
