package ipsen5.dto;

import ipsen5.models.Role;

public class AuthenticationDTO {

    public String username;

    public String first_name;
    public String last_name;
    public String email;
    public String password;

    public String donation_link;
    public String imageUrl;
    public Role role;

    public AuthenticationDTO(String username, String first_name, String last_name, String email, String password, String donation_link, String imageUrl, Role role) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.donation_link = donation_link;
        this.imageUrl = imageUrl;
        this.role = role;
    }
}
