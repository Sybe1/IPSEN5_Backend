package ipsen5.repository;

import ipsen5.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {

}
