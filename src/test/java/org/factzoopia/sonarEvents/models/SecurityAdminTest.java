package org.factzoopia.sonarEvents.models;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;

@ExtendWith(MockitoExtension.class)
public class SecurityAdminTest {

    @Mock
    private Admin admin;

    @InjectMocks
    private SecurityAdmin securityAdmin;

    @Test
    void testGetAuthorities() {
        Collection<? extends org.springframework.security.core.GrantedAuthority> authorities = securityAdmin
                .getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("ROLE_ADMIN", authorities.iterator().next().getAuthority());
    }

    @Test
    void testGetPassword() {
        when(admin.getPassword()).thenReturn("password");
        assertEquals("password", securityAdmin.getPassword());
    }

    @Test
    void testGetUsername() {
        when(admin.getName()).thenReturn("username");
        assertEquals("username", securityAdmin.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(securityAdmin.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(securityAdmin.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(securityAdmin.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertTrue(securityAdmin.isEnabled());
    }
}