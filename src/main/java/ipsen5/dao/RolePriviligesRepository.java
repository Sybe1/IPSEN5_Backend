package ipsen5.dao;

import ipsen5.models.Role;
import ipsen5.models.RolePriviliges;
import ipsen5.models.RolePriviligesId;
import ipsen5.models.enums.Rights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePriviligesRepository extends JpaRepository<RolePriviliges, RolePriviligesId> {
    RolePriviliges findByIdRoleIdAndIdRightsId(Role role, Rights rights);


    List<RolePriviliges> findByIdRoleId(Role id_roleId);
}
