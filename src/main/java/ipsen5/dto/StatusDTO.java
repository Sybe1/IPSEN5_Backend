package ipsen5.dto;

import ipsen5.models.Post;
import ipsen5.models.User;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class StatusDTO {
    public UUID id;
    public String status;

}
