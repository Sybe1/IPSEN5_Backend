package ipsen5.services;

import ipsen5.dto.FeedbackDTO;
import ipsen5.dto.RoleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleValidator {
    private InputValidator inputValidator;

    public RoleValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void roleValidations(RoleDTO roleDTO) {
        if (!inputValidator.isValidName(roleDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
    }
}
