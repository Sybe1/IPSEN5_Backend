package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Rubric {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    public Rubric() {
    }

    public Rubric(String title) {
        this.title = title;
    }
}
