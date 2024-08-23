package org.factzoopia.sonarEvents.controllers;

import java.util.List;

import org.factzoopia.sonarEvents.models.Event;
import org.factzoopia.sonarEvents.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}/events")

public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
}

@GetMapping(path = "/all")
  public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
}

   @GetMapping(path = "/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
          return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

      @PutMapping(path = "/{id}")
    public ResponseEntity<Event> uptadeEvent(@RequestBody Event event, @PathVariable Long id) {
        event.setId(id);
        Event updateEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updateEvent);
    }

      @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);

        return ResponseEntity.noContent().build();
    }

    // @PostMapping("/register")  HAY QUE PROBAR ESTE PUEDE SER EL MÉTODO PARA REGISTRAR USUARIOS
    // public ResponseEntity<User> registerUser(@RequestBody User user) {
    //     User registeredUser = userService.registerUser(user);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    // }

}