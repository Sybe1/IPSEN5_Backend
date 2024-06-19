package ipsen5;

import ipsen5.dto.RoleDTO;
import ipsen5.models.Role;
import ipsen5.repository.RoleRepository;
import ipsen5.services.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    private Role role;
    private Role role2;
    private List roles;

    @BeforeEach
    public void setup(){
        roleRepository = Mockito.mock(RoleRepository.class);
        roleService = new RoleService(roleRepository);
        role = new Role("Admin");
        role.setId(UUID.randomUUID());
        role2 = new Role("Moderator");
        role2.setId(UUID.randomUUID());
        roles = Arrays.asList(role, role2);
    }

    @Test
    public void testGetRoleByName() {
        Role role = new Role();
        role.setName("Admin");

        when(roleRepository.findByName("Admin")).thenReturn(Optional.of(role));

        Optional<Role> foundRole = roleService.findRoleByName("Admin");

        assertTrue(foundRole.isPresent());
        assertEquals("Admin", foundRole.get().getName());
    }

    @Test
    public void testGetRoleByNameNotFound() {
        when(roleRepository.findByName("Admin")).thenReturn(Optional.empty());

        Optional<Role> foundRole = roleService.findRoleByName("Admin");

        assertFalse(foundRole.isPresent());
    }


    @Test
    public void testGetAllRoles() {
        List<Role> roles = Arrays.asList(new Role("Admin"), new Role("User"));

        when(roleRepository.findAll()).thenReturn(roles);

        List<Role> foundRoles = roleService.getAllRoles();

        assertNotNull(foundRoles);
        assertEquals(2, foundRoles.size());
        assertEquals("Admin", foundRoles.get(0).getName());
        assertEquals("User", foundRoles.get(1).getName());
    }

    @Test
    public void testGetAllRolesEmpty() {
        when(roleRepository.findAll()).thenReturn(Collections.emptyList());

        List<Role> foundRoles = roleService.getAllRoles();

        assertNotNull(foundRoles);
        assertTrue(foundRoles.isEmpty());
    }

    @Test
    public void testCreateRole() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId("123");
        roleDTO.setName("Admin");

        roleService.createRole(roleDTO);

        verify(roleRepository, Mockito.times(1)).save(any(Role.class));
    }

    @Test
    public void testEditRole() {

        RoleDTO updatedRoleDTO = new RoleDTO();
        updatedRoleDTO.setName("Creator");

        when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).thenReturn(role);

        roleService.editRole(role.getId(), updatedRoleDTO);

        verify(roleRepository, Mockito.times(1)).findById(role.getId());
        verify(roleRepository, Mockito.times(1)).save(role);

        assertEquals(updatedRoleDTO.getName(), role.getName());
    }

    @Test
    public void testEditRoleNotFound() {
        UUID nonExistingId = UUID.randomUUID();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("Creator");

        when(roleRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        try {
            roleService.editRole(nonExistingId, roleDTO);
        } catch (RuntimeException ex) {
            assertEquals("Role not found", ex.getMessage());
        }
    }

    @Test
    public void testDeleteRole() {
        UUID roleId = UUID.randomUUID();

        when(roleRepository.findById(roleId)).thenReturn(Optional.of(new Role()));

        roleService.deleteRole(roleId);

        verify(roleRepository, Mockito.times(1)).findById(roleId);
        verify(roleRepository, Mockito.times(1)).deleteById(roleId);
    }

    @Test
    public void testDeleteRoleNotFound() {
        UUID nonExistingId = UUID.randomUUID();

        when(roleRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            roleService.deleteRole(nonExistingId);
        });

        verify(roleRepository, Mockito.times(1)).findById(nonExistingId);
        verify(roleRepository, Mockito.never()).deleteById(nonExistingId);

        String expectedMessage = "Role not found";
        String actualMessage = exception.getMessage();
        assert(actualMessage.contains(expectedMessage));
    }


}
