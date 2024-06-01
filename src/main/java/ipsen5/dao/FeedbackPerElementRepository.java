package ipsen5.dao;

import ipsen5.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackPerElementRepository extends JpaRepository<FeedbackPerElement, FeedbackPerElementId> {
    List<FeedbackPerElement> findByIdSubmissionId(Submission submission);

}
