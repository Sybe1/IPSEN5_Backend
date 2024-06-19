package ipsen5.dto;

import ipsen5.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PostDTO {
    public UUID id;
    public String title;
    public String text;
    private String imageUrl;
    public LocalDate localDate;
    public List<String> genres;
    public User user;
}
