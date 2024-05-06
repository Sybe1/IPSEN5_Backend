package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Criteria {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String zeroPoints;
    private String twoPoints;
    private String fourPoints;
    private String sixPoints;
    private String eightPoints;
    private String tenPoints;

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
