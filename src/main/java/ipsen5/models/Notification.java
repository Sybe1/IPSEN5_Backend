package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String message;

    @NotNull
    private LocalDateTime timestamp;

    @ManyToOne
    @NotNull
    @JsonBackReference
    private User user;

    @NotNull
    private boolean read = false;

    public Notification() {
    }

    public Notification(String message, LocalDateTime timestamp, User user) {
        this.message = message;
        this.timestamp = timestamp;
        this.user = user;
    }
}