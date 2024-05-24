package ipsen5.dto;

import ipsen5.models.User;

import java.time.LocalDate;

public class PostDTO {
    public String title;
    public String text;
    public String imageUrl;
    public LocalDate localDate;
    public User user;
}
