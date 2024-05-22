package ipsen5.dto;

import ipsen5.models.Role;

public class AuthenticationDTO {

    public String first_name;
    public String last_name;
    public String email;
    public String username;

    public String password;

    public String donation_link;
    public Role role;

    public AuthenticationDTO(String first_name, String last_name, String email, String username, String password, String donation_link, Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.donation_link = donation_link;
        this.role = role;
    }
}
