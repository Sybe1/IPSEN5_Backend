package ipsen5.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @Getter
    @GeneratedValue
    private UUID id;

    @Getter
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'-]+$")
    @Column(unique = true)
    private String name;

    public Role (){
    }

    public Role(String name){
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
