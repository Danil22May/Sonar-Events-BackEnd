package org.factzoopia.sonarEvents.repositories;

import java.util.List;

import org.factzoopia.sonarEvents.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByPastTrue();  // Creo que con esto podemos hacer consulta de eventos pasados

    List<Event> findByAvailableTrue(); // Y con esto la consulta de si estan disponibles
}
