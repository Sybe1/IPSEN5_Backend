package ipsen5.dto;

import ipsen5.models.User;
import ipsen5.models.enums.PrefferedDestination;

import java.time.LocalDate;
import java.util.List;

public class PostDTO {
    public String title;
    public String text;
    public String imageUrl;
    public PrefferedDestination prefferedDestination;
    public LocalDate localDate;
    public List<String> genres;
    public User user;
}
