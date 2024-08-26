package org.factzoopia.sonarEvents.services;

import org.factzoopia.sonarEvents.exceptions.EventsNotFoundException;
import org.factzoopia.sonarEvents.models.Event;
import org.factzoopia.sonarEvents.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventService eventService;

    private Event event;
    private Event event2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Timestamp futureDate = new Timestamp(System.currentTimeMillis() + 100000);
        Timestamp pastDate = new Timestamp(System.currentTimeMillis() - 100000);

        event = new Event(1L, "Event 1", futureDate, true, false, 100, 50, "Description 1", "image1.jpg");
        event2 = new Event(2L, "Event 2", pastDate, false, true, 100, 100, "Description 2", "image2.jpg");
    }

    @Test
    void testGetAllEvents() {
        when(repository.findAll()).thenReturn(Arrays.asList(event, event2));

        List<Event> events = eventService.getAllEvents();

        assertEquals(2, events.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetEventById() {
        when(repository.findById(1L)).thenReturn(Optional.of(event));

        Event foundEvent = eventService.getEventById(1L);

        assertNotNull(foundEvent);
        assertEquals("Event 1", foundEvent.getTitle());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetEventById_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EventsNotFoundException.class, () -> eventService.getEventById(1L));
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreateEvent() {
        when(repository.save(event)).thenReturn(event);

        Event createdEvent = eventService.createEvent(event);

        assertNotNull(createdEvent);
        assertEquals("Event 1", createdEvent.getTitle());
        verify(repository, times(1)).save(event);
    }

    @Test
    void testUpdateEvent() {
        when(repository.existsById(event.getId())).thenReturn(true);
        when(repository.save(event)).thenReturn(event);

        Event updatedEvent = eventService.updateEvent(event);

        assertNotNull(updatedEvent);
        assertEquals("Event 1", updatedEvent.getTitle());
        verify(repository, times(1)).existsById(event.getId());
        verify(repository, times(1)).save(event);
    }

    @Test
    void testUpdateEvent_NotFound() {
        when(repository.existsById(event.getId())).thenReturn(false);

        assertThrows(EventsNotFoundException.class, () -> eventService.updateEvent(event));
        verify(repository, times(1)).existsById(event.getId());
        verify(repository, times(0)).save(event);
    }

    @Test
    void testDeleteEventById() {
        when(repository.existsById(1L)).thenReturn(true);

        eventService.deleteEventById(1L);

        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteEventById_NotFound() {
        when(repository.existsById(1L)).thenReturn(false);

        assertThrows(EventsNotFoundException.class, () -> eventService.deleteEventById(1L));
        verify(repository, times(1)).existsById(1L);
        verify(repository, times(0)).deleteById(1L);
    }

    @Test
    void testHasEventPassed() {
        when(repository.findById(1L)).thenReturn(Optional.of(event2)); // Evento pasado

        boolean result = eventService.hasEventPassed(1L);

        assertTrue(result);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testIsEventAvailable() {
        when(repository.findById(1L)).thenReturn(Optional.of(event)); // Evento disponible

        boolean result = eventService.isEventAvailable(1L);

        assertTrue(result);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testRegisterParticipant() {
        when(repository.findById(1L)).thenReturn(Optional.of(event));
        when(repository.save(event)).thenReturn(event);

        Event updatedEvent = eventService.registerParticipant(1L);

        assertNotNull(updatedEvent);
        assertEquals(51, updatedEvent.getRegisteredParticipants());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(event);
    }

    @Test
    void testGetPastEvents() {
        when(repository.findByPastTrue()).thenReturn(Arrays.asList(event2));

        List<Event> pastEvents = eventService.getPastEvents();

        assertEquals(1, pastEvents.size());
        assertEquals("Event 2", pastEvents.get(0).getTitle());
        verify(repository, times(1)).findByPastTrue();
    }

    @Test
    void testGetAvailableEvents() {
        when(repository.findByAvailableTrue()).thenReturn(Arrays.asList(event));

        List<Event> availableEvents = eventService.getAvailableEvents();

        assertEquals(1, availableEvents.size());
        assertEquals("Event 1", availableEvents.get(0).getTitle());
        verify(repository, times(1)).findByAvailableTrue();
    }
}
