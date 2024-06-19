package ipsen5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriteriaDTO {
    public String mainName;
    public String subName;
    public String zeroPoints;
    public String onePoints;
    public String twoPoints;
    public String threePoints;
    public String fourPoints;
    public String fivePoints;

    public CriteriaDTO(String mainName, String subName, String zeroPoints, String onePoints, String twoPoints, String threePoints, String fourPoints, String fivePoints) {
        this.mainName = mainName;
        this.subName = subName;
        this.zeroPoints = zeroPoints;
        this.onePoints = onePoints;
        this.twoPoints = twoPoints;
        this.threePoints = threePoints;
        this.fourPoints = fourPoints;
        this.fivePoints = fivePoints;
    }
}
