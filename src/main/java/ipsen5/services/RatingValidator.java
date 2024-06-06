package ipsen5.services;

import ipsen5.dto.RatingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RatingValidator {
    private InputValidator inputValidator;

    public RatingValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void ratingValidations(RatingDTO ratingDTO) {
        if (!inputValidator.isNotNull(ratingDTO.grade)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid grade provided"
            );
        }
        if (!inputValidator.isNotNull(ratingDTO.post_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid post provided"
            );
        }
    }
}
