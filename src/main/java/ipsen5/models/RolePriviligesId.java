package ipsen5.models;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RolePriviligesId implements Serializable {
    @ManyToOne
    private Role roleId;

    @ManyToOne
    private Rights rightsId;

    public RolePriviligesId(Role roleId, Rights rightsId) {
        this.roleId = roleId;
        this.rightsId = rightsId;
    }

    public RolePriviligesId() {
    }
}

