package org.factzoopia.sonarEvents.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.factzoopia.sonarEvents.models.Email;

public class EmailTest {

    @Test
    public void testConstructor() {
        Email email = new Email("receiver@example.com", "recipient@example.com", "subject", "body");
        assertNotNull(email);
        assertEquals("receiver@example.com", email.getReceiver());
        assertEquals("recipient@example.com", email.getRecipient());
        assertEquals("subject", email.getSubject());
        assertEquals("body", email.getBody());
    }

    @Test
    public void testGettersAndSetters() {
        Email email = new Email("receiver@example.com", "recipient@example.com", "subject", "body");
        email.setInfo("additional info");
        assertEquals("additional info", email.getInfo());
    }
}