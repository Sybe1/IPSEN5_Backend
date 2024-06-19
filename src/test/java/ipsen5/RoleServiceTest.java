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
        // Given
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId("123");
        roleDTO.setName("Admin");

        // When
        roleService.createRole(roleDTO);

        // Then
        verify(roleRepository, Mockito.times(1)).save(any(Role.class));
    }

    @Test
    public void testEditRole() {

        RoleDTO updatedRoleDTO = new RoleDTO();
        updatedRoleDTO.setName("Creator");

        // Mocking behavior
        when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).thenReturn(role); // Mock the save operation

        // When
        roleService.editRole(role.getId(), updatedRoleDTO);

        // Then
        verify(roleRepository, Mockito.times(1)).findById(role.getId()); // Verify findById was called once
        verify(roleRepository, Mockito.times(1)).save(role); // Verify save was called once with the updated role

        // Assert the updated name
        assertEquals(updatedRoleDTO.getName(), role.getName());
    }

    @Test
    public void testEditRoleNotFound() {
        // Given
        UUID nonExistingId = UUID.randomUUID();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("Creator");

        // Mocking behavior for a non-existing role
        when(roleRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // When
        try {
            roleService.editRole(nonExistingId, roleDTO);
        } catch (RuntimeException ex) {
            // Then
            assertEquals("Role not found", ex.getMessage());
        }
    }




}
