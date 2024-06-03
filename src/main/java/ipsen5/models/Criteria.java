package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Criteria {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String zeroPoints;
    private String twoPoints;
    private String fourPoints;
    private String sixPoints;
    private String eightPoints;
    private String tenPoints;

    @ManyToMany(mappedBy = "criteria")
    @JsonBackReference
    private Set<Rubric> rubrics = new HashSet<>();

    public Criteria() {
    }

    public Criteria(String name, String zeroPoints, String twoPoints, String fourPoints, String sixPoints, String eightPoints, String tenPoints) {
        this.name = name;
        this.zeroPoints = zeroPoints;
        this.twoPoints = twoPoints;
        this.fourPoints = fourPoints;
        this.sixPoints = sixPoints;
        this.eightPoints = eightPoints;
        this.tenPoints = tenPoints;
    }
}
