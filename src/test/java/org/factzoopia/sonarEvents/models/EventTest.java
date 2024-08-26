package org.factzoopia.sonarEvents.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private Event event;
    private Timestamp futureDate;
    private Timestamp pastDate;

    @BeforeEach
    void setUp() {
        futureDate = new Timestamp(System.currentTimeMillis() + 100000); 
        pastDate = new Timestamp(System.currentTimeMillis() - 100000);   

        event = new Event(1L, "Test Event", futureDate, true, false, 100, 50, "Test Description", "test_image.jpg");
    }

    @Test
    void testHasEventPassed_FutureDate() {
        assertFalse(event.hasEventPassed(), "El evento no debería haber pasado");
    }

    @Test
    void testHasEventPassed_PastDate() {
        event.setDate(pastDate);
        assertTrue(event.hasEventPassed(), "El evento debería haber pasado");
    }

    @Test
    void testIsEventAvailable_Available() {
        assertTrue(event.isEventAvailable(), "El evento debería estar disponible");
    }

    @Test
    void testIsEventAvailable_FullCapacity() {
        event.setRegisteredParticipants(100); 
        assertFalse(event.isEventAvailable(), "El evento no debería estar disponible porque está lleno");
    }

    @Test
    void testIsEventAvailable_PastEvent() {
        event.setPast(true);
        assertFalse(event.isEventAvailable(), "El evento no debería estar disponible porque es pasado");
    }

    @Test
    void testRegisterParticipant_Success() {
        event.registerParticipant();
        assertEquals(51, event.getRegisteredParticipants());
    }

    @Test
    void testRegisterParticipant_Failure() {
        event.setRegisteredParticipants(100); 

        IllegalStateException exception = assertThrows(IllegalStateException.class, event::registerParticipant);
        assertEquals("The event is not available for more participants.", exception.getMessage());
    }

    @Test
    void testGettersAndSetters() {
        event.setId(2L);
        assertEquals(2L, event.getId());

        event.setTitle("New Title");
        assertEquals("New Title", event.getTitle());

        event.setDate(pastDate);
        assertEquals(pastDate, event.getDate());

        event.setAvailable(false);
        assertFalse(event.getAvailable());

        event.setPast(true);
        assertTrue(event.getPast());

        event.setMaxParticipants(200);
        assertEquals(200, event.getMaxParticipants());

        event.setRegisteredParticipants(75);
        assertEquals(75, event.getRegisteredParticipants());

        event.setDescription("New Description");
        assertEquals("New Description", event.getDescription());

        event.setImage("new_image.jpg");
        assertEquals("new_image.jpg", event.getImage());
    }
}
