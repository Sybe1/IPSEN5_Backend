package ipsen5.dao;

import ipsen5.models.Rights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RightsRepository extends JpaRepository<Rights, Long> {
}