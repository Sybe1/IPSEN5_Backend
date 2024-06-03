package ipsen5.services;

import ipsen5.dto.RubricDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RubricValidator {
    private InputValidator inputValidator;

    public RubricValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void rubricValidations(RubricDTO rubricDTO) {
        if (!inputValidator.isValidDescription(rubricDTO.title)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid title provided"
            );
        }
    }
}
