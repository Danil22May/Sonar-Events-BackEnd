package org.factzoopia.sonarEvents.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void testConstructorConParametros() {
        String receiver = "receiver@example.com";
        String info = "Información del email";
        Email email = new Email(receiver, info, info, info);
        assertEquals(receiver, email.getReceiver());
        assertEquals(info, email.getInfo());
    }

    @Test
    public void testGettersYSetters() {
        Email email = new Email(null, null, null, null);
        String receiver = "receiver@example.com";
        email.setReceiver(receiver);
        assertEquals(receiver, email.getReceiver());

        String info = "Información del email";
        email.setInfo(info);
        assertEquals(info, email.getInfo());
    }
}
