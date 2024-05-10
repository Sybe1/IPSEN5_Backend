package ipsen5.dao;


import ipsen5.models.FeedbackPerElement;
import ipsen5.models.FeedbackPerElementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackPerElementRepository extends JpaRepository<FeedbackPerElement, FeedbackPerElementId>{
}




