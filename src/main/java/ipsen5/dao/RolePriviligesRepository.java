package ipsen5.dao;


import ipsen5.models.RolePriviliges;
import ipsen5.models.RolePriviligesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePriviligesRepository extends JpaRepository<RolePriviliges, RolePriviligesId>{
}




