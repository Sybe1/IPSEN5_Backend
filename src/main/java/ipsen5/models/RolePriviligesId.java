package ipsen5.models;

import java.io.Serializable;

import ipsen5.models.enums.Rights;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class RolePriviligesId implements Serializable {
    @ManyToOne
    @NotNull
    private Role roleId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Rights rightsId;

    public RolePriviligesId(Role roleId, Rights rightsId) {
        this.roleId = roleId;
        this.rightsId = rightsId;
    }

    public RolePriviligesId() {
    }
}

