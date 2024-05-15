package ipsen5.dto;

import ipsen5.models.Feedback;
import ipsen5.models.Post;
import ipsen5.models.Status;
import ipsen5.models.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class SubmissionDTO {
    public String text;
    public boolean extra_feedback;
    public String story_Details;

    public Feedback feedbackID;
    public Status statusID;
    public User user_id;
}
