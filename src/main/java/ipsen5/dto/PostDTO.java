package ipsen5.dto;

import ipsen5.models.Rating;
import ipsen5.models.User;

import java.time.LocalDate;
import java.util.List;

public class PostDTO {
    public String title;
    public String text;
    public String imageUrl;
    public LocalDate localDate;
    public List<String> genres;
    public User user;
}
