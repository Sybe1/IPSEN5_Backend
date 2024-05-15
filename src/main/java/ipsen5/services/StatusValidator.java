package ipsen5.services;

import ipsen5.dto.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StatusValidator {
    private InputValidator inputValidator;

    public StatusValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void statusValidations(StatusDTO statusDTO) {
        if (!inputValidator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid status provided"
            );
        }
        if (!inputValidator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No status post provided"
            );
        }
    }
}
