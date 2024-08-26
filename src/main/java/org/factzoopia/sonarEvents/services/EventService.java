package org.factzoopia.sonarEvents.services;

import java.util.List;

import org.factzoopia.sonarEvents.exceptions.EventsNotFoundException;
import org.factzoopia.sonarEvents.models.Event;
import org.factzoopia.sonarEvents.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EventsNotFoundException("Animal not found"));
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Event event) {
        if (!repository.existsById(event.getId())) {
            throw new EventsNotFoundException("Event not found");
        }
        return repository.save(event);
    }

    public void deleteEventById(Long id) {
        if (!repository.existsById(id)) {
            throw new EventsNotFoundException("Event not found");
        }
        repository.deleteById(id);
    }

    public boolean hasEventPassed(Long eventId) {
        Event event = getEventById(eventId);
        return event.hasEventPassed();
    }

    public boolean isEventAvailable(Long eventId) {
        Event event = getEventById(eventId);
        return event.isEventAvailable();
    }

    public Event registerParticipant(Long eventId) {
        Event event = getEventById(eventId);
        event.registerParticipant();
        return repository.save(event);
    }

    public List<Event> getPastEvents() {
        return repository.findByPastTrue();
    }

    public List<Event> getAvailableEvents() {
        return repository.findByAvailableTrue();
    }

}