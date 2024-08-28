package org.factzoopia.sonarEvents.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testLogin() {

        when(SecurityContextHolder.getContext()).thenReturn(securityContext);

        when(securityContext.getAuthentication()).thenReturn(authentication);

        when(authentication.getName()).thenReturn("username");
        when(authentication.getAuthorities().iterator().next().toString()).thenReturn("ROLE_USER");

        ResponseEntity<Map<String, String>> response = authController.login();
        assertNotNull(response);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        Map<String, String> json = response.getBody();
        assertNotNull(json);
        assertEquals("Logged", json.get("message"));
        assertEquals("username", json.get("username"));
        assertEquals("ROLE_USER", json.get("roles"));
    }
}