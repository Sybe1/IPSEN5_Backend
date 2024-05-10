package ipsen5.services;

import ipsen5.dto.RatingDTO;
import ipsen5.dto.ReactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReactionValidator {
    private InputValidator inputValidator;

    public ReactionValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void reactionValidations(ReactionDTO reactionDTO) {
        if (!inputValidator.isValidDescription(reactionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid text provided"
            );
        }
        if (!inputValidator.isNotNull(reactionDTO.post_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No post provided"
            );
        }
        if (!inputValidator.isNotNull(reactionDTO.user_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No user provided"
            );
        }
    }
}
