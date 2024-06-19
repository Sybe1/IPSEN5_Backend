package ipsen5.dto;

import lombok.Getter;

public class RoleDTO {
    @Getter
    public String id;
    @Getter
    public String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

