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
    private String mainName;
    private String subName;
    private String zeroPoints;
    private String onePoints;
    private String twoPoints;
    private String threePoints;
    private String fourPoints;
    private String fivePoints;

    @ManyToMany(mappedBy = "criteria")
    @JsonBackReference
    private Set<Rubric> rubrics = new HashSet<>();

    public Criteria() {
    }

    public Criteria(UUID id, String mainName, String subName, String zeroPoints, String onePoints, String twoPoints, String threePoints, String fourPoints, String fivePoints, Set<Rubric> rubrics) {
        this.id = id;
        this.mainName = mainName;
        this.subName = subName;
        this.zeroPoints = zeroPoints;
        this.onePoints = onePoints;
        this.twoPoints = twoPoints;
        this.threePoints = threePoints;
        this.fourPoints = fourPoints;
        this.fivePoints = fivePoints;
        this.rubrics = rubrics;
    }

    public Criteria(String mainName, String subName, String zeroPoints, String twoPoints, String fourPoints, String threePoints, String onePoints, String fivePoints) {
    }
}
