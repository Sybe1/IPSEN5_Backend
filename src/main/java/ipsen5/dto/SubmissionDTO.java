package ipsen5.dto;

import ipsen5.models.Feedback;
import ipsen5.models.Post;
import ipsen5.models.Status;
import ipsen5.models.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class SubmissionDTO {
        public String name;
        public String email;
        public String online_profiles;
        public String story_title;
        public String type;
        public int wordCount;
        public String genre;
        public String additional_notes;
        public String prefferd_destination;
        public Boolean platform_presence;
        public Boolean extra_feedback;
        public Boolean express_experience;
        public Status statusID;
        public User user_id;
}
