package ipsen5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthenticationDTO {

    public String first_name;
    public String last_name;
    public String email;

    public String password;

    public String donation_link;

    public AuthenticationDTO(String first_name, String last_name, String email, String password, String donation_link) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.donation_link = donation_link;
    }
}
