package org.factzoopia.sonarEvents.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    public void testConstructorVacio() {
        Admin admin = new Admin();
        assertNotNull(admin);
    }

    @Test
    public void testConstructorConParametros() {
        String email = "admin@example.com";
        String password = "password123";
        Long id = 1L;
        String role = "ROLE_ADMIN";
        Admin admin = new Admin(email, password, id, role);
        assertEquals(email, admin.getName()); 
        assertEquals(password, admin.getPassword());
        assertEquals(id, admin.getId());
        assertEquals(role, admin.getRole());
    }

    @Test
    public void testGettersYSetters() {
        Admin admin = new Admin();
        String email = "admin@example.com";
        admin.setName(email);
        assertEquals(email, admin.getName());

        String password = "password123";
        admin.setPassword(password);
        assertEquals(password, admin.getPassword());

        Long id = 1L;
        admin.setId(id);
        assertEquals(id, admin.getId());

        String role = "ROLE_ADMIN";
        admin.setRole(role);
        assertEquals(role, admin.getRole());
    }

    @Test
    public void testNombre() {
        Admin admin = new Admin();
        String email = "admin@example.com";
        admin.setName(email);
        assertEquals(email, admin.getName());
    }
}