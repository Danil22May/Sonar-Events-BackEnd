package org.factzoopia.sonarEvents.repositories;

import org.factzoopia.sonarEvents.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    
    @Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}

