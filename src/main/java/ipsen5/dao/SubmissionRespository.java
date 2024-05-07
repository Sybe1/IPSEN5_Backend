package ipsen5.dao;

import ipsen5.models.Rating;
import ipsen5.models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubmissionRespository extends JpaRepository<Submission, UUID> {

}
