package ipsen5.services;

import ipsen5.dto.CriteriaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CriteriaValidator {
    private InputValidator inputValidator;

    public CriteriaValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void criteriaValidations(CriteriaDTO criteriaDTO) {
        if (!inputValidator.isValidName(criteriaDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
        if (!inputValidator.isValidDescription(criteriaDTO.twoPoints)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        if (!inputValidator.isValidDescription(criteriaDTO.fourPoints)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        if (!inputValidator.isValidDescription(criteriaDTO.sixPoints)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        if (!inputValidator.isValidDescription(criteriaDTO.eightPoints)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        if (!inputValidator.isValidDescription(criteriaDTO.tenPoints)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
    }
}
