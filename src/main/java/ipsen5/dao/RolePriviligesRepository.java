package ipsen5.dao;

import ipsen5.models.Role;
import ipsen5.models.RolePriviliges;
import ipsen5.models.RolePriviligesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolePriviligesRepository extends JpaRepository<RolePriviliges, RolePriviligesId> {
    List<RolePriviliges> findByIdRoleId(Role id_roleId);
}
