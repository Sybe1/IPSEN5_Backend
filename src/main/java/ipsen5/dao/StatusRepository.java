package ipsen5.dao;

import ipsen5.models.Status;
import ipsen5.models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {

}
