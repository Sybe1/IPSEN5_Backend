package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Entity(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String donation_link;

//    @ManyToOne
//    private Role role;

    public User() {
    }

    public User(String first_name, String last_name, String email, String password, String donation_link) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.donation_link = donation_link;
    }
}
