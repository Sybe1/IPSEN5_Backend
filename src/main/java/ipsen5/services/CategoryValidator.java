package ipsen5.services;

import ipsen5.dto.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryValidator {
    private InputValidator inputValidator;
    public CategoryValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void categoryValidations(CategoryDTO categoryDTO){
        if (!inputValidator.isValidName(categoryDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
        if (!inputValidator.isValidDescription(categoryDTO.description)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
    }
}
