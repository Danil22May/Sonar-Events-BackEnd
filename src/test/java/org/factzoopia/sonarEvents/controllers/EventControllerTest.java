package org.factzoopia.sonarEvents.controllers;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;

import org.factzoopia.sonarEvents.models.Event;
import org.factzoopia.sonarEvents.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    private ObjectMapper objectMapper;

    @BeforeEach
      public void setup() {
        mockMvc = MockMvcBuilders
            .standaloneSetup(new EventController(eventService))
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

    @Test
    public void testGetAllEvents() throws Exception {
        // Arrange
        Event event1 = new Event(1L, "Concert", Timestamp.valueOf("2024-01-01 10:00:00"), true, false, 100, 50, "Description", "image.jpg");
        Event event2 = new Event(2L, "Festival", Timestamp.valueOf("2024-02-01 10:00:00"), true, false, 200, 100, "Description", "image.jpg");
        List<Event> events = Arrays.asList(event1, event2);

        when(eventService.getAllEvents()).thenReturn(events);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Concert"))
                .andExpect(jsonPath("$[1].title").value("Festival"));
    }

    @Test
    public void testGetEventById() throws Exception {
        // Arrange
        Event event = new Event(1L, "Concert", Timestamp.valueOf("2024-01-01 10:00:00"), true, false, 100, 50, "Description", "image.jpg");
        
        when(eventService.getEventById(1L)).thenReturn(event);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Concert"));
    }

    @Test
    public void testCreateEvent() throws Exception {
        // Arrange
        Event event = new Event(null, "New Event", Timestamp.valueOf("2024-03-01 10:00:00"), true, false, 150, 0, "Description", "image.jpg");
        Event createdEvent = new Event(1L, "New Event", Timestamp.valueOf("2024-03-01 10:00:00"), true, false, 150, 0, "Description", "image.jpg");
        
        when(eventService.createEvent(event)).thenReturn(createdEvent);

        // Act & Assert
        mockMvc.perform(post("/api/v1/events/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Event"));
    }

    @Test
    public void testUpdateEvent() throws Exception {
        // Arrange
        Event event = new Event(1L, "Updated Event", Timestamp.valueOf("2024-04-01 10:00:00"), true, false, 200, 50, "Updated Description", "updated_image.jpg");
        
        when(eventService.updateEvent(event)).thenReturn(event);

        // Act & Assert
        mockMvc.perform(put("/api/v1/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Event"));
    }

    @Test
    public void testDeleteEvent() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/v1/events/1"))
                .andExpect(status().isNoContent());
        
        verify(eventService, times(1)).deleteEventById(1L);
    }

    @Test
    public void testHasEventPassed() throws Exception {
        // Arrange
        when(eventService.hasEventPassed(1L)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/1/hasPassed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.").value(true));
    }

    @Test
    public void testIsEventAvailable() throws Exception {
        // Arrange
        when(eventService.isEventAvailable(1L)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/1/isAvailable"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.").value(true));
    }

    @Test
    public void testRegisterParticipant() throws Exception {
        // Arrange
        Event event = new Event(1L, "Concert", Timestamp.valueOf("2024-01-01 10:00:00"), true, false, 100, 50, "Description", "image.jpg");
        Event updatedEvent = new Event(1L, "Concert", Timestamp.valueOf("2024-01-01 10:00:00"), true, false, 100, 51, "Description", "image.jpg");
        
        when(eventService.registerParticipant(1L)).thenReturn(updatedEvent);

        // Act & Assert
        mockMvc.perform(post("/api/v1/events/1/register"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registeredParticipants").value(51));
    }

    @Test
    public void testGetPastEvents() throws Exception {
        // Arrange
        Event pastEvent = new Event(1L, "Past Event", Timestamp.valueOf("2023-01-01 10:00:00"), true, true, 100, 100, "Past Event", "image.jpg");
        List<Event> pastEvents = Arrays.asList(pastEvent);
        
        when(eventService.getPastEvents()).thenReturn(pastEvents);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/past"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Past Event"));
    }

    @Test
    public void testGetAvailableEvents() throws Exception {
        // Arrange
        Event availableEvent = new Event(1L, "Available Event", Timestamp.valueOf("2024-06-01 10:00:00"), true, false, 100, 50, "Available Event", "image.jpg");
        List<Event> availableEvents = Arrays.asList(availableEvent);
        
        when(eventService.getAvailableEvents()).thenReturn(availableEvents);

        // Act & Assert
        mockMvc.perform(get("/api/v1/events/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Available Event"));
    }
}
=======
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
>>>>>>> features/firebase
