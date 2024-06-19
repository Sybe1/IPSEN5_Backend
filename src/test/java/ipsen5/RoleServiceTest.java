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




}
