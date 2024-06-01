package ipsen5.dto;

import ipsen5.models.Status;
import ipsen5.models.User;

public class SubmissionDTO {
    public String text;
    public boolean extra_feedback;
    public String story_Details;

    public Status statusID;
    public User user_id;
}
