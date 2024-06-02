package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Status {
    @Id
    private UUID id;

    private String status;

    public Status(String status) {
        this.id = id;
        this.status = status;
    }

    public Status() {

    }

    public Status(UUID id, String status) {
    }
}
