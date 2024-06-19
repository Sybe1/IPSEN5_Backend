package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Rubric {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'-]+$")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "rubric_criteria",
            joinColumns = @JoinColumn(name = "rubric_id"),
            inverseJoinColumns = @JoinColumn(name = "criteria_id"))
    @JsonManagedReference
    @NotNull
    private Set<Criteria> criteria = new HashSet<>();

    public Rubric() {
    }

    public Rubric(String title) {
        this.title = title;
    }
}
