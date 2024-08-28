package org.factzoopia.sonarEvents.controllers;

import org.factzoopia.sonarEvents.models.Event;
import org.factzoopia.sonarEvents.services.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    @Test
    public void testGetAllEvents() {
        List<Event> events = Arrays.asList(new Event(), new Event());
        when(eventService.getAllEvents()).thenReturn(events);

        ResponseEntity<List<Event>> response = eventController.getAllEvents();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(events, response.getBody());
    }

    @Test
    public void testGetEventById() {
        // Mock event service to return an event
        Event event = new Event();
        when(eventService.getEventById(1L)).thenReturn(event);

        ResponseEntity<Event> response = eventController.getEventById(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(event, response.getBody());
    }

}