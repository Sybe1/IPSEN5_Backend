package ipsen5.models;

import java.io.Serializable;

import ipsen5.models.enums.Rights;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RolePriviligesId implements Serializable {
    @ManyToOne
    private Role roleId;

    @Enumerated(EnumType.STRING)
    private Rights rightsId;

    public RolePriviligesId(Role roleId, Rights rightsId) {
        this.roleId = roleId;
        this.rightsId = rightsId;
    }

    public RolePriviligesId() {
    }
}

