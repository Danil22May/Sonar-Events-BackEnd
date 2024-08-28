package org.factzoopia.sonarEvents.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testConstructorConParametros() {
        String email = "user@example.com";
        String password = "password";
        User user = new User(email, password);
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void testGettersYSetters() {
        User user = new User();
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());

        String email = "user@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());

        String password = "password";
        user.setPassword(password);
        assertEquals(password, user.getPassword());

        String role = "ROLE_ADMIN";
        user.setRole(role);
        assertEquals(role, user.getRole());
    }
    @Test
public void testConstructorVacio() {
    User user = new User();
    assertNotNull(user);
}
}
