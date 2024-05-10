package ipsen5.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RolePriviliges {
    @EmbeddedId
    private RolePriviligesId id;

    public RolePriviliges(RolePriviligesId id) {
        this.id = id;
    }

    public RolePriviliges() {
    }
}
