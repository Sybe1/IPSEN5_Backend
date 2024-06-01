package ipsen5.dto;

import ipsen5.models.Criteria;
import ipsen5.models.Submission;

import java.util.UUID;

public class FeedbackPerElementDTO {
    public UUID submissionId;
    public UUID criteriaId;
    public int grade;
    public String feedback;
}
