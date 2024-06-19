package ipsen5.dto;

import ipsen5.models.Post;
import ipsen5.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReactionDTO {
    public String text;
    public Post post_id;
    public User user_id;


}
