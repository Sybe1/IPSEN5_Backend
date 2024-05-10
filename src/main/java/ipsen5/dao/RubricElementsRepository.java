package ipsen5.dao;


import ipsen5.models.RubricElements;
import ipsen5.models.RubricElementsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricElementsRepository extends JpaRepository<RubricElements, RubricElementsId>{
}




