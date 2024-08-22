package org.factzoopia.sonarEvents.services;

import java.sql.Timestamp;
import java.util.List;

import org.apache.el.stream.Optional;
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

    public static Event getEventById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEventById'");
    }

    // public boolean isAvailable() {
    //     return this.isAvailable() && !this.past && this.registeredParticipants < this.maxParticipants;
    // }
    
}