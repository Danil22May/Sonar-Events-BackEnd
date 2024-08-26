package org.factzoopia.sonarEvents.services;

import org.factzoopia.sonarEvents.models.Email;
import org.factzoopia.sonarEvents.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
   
    @Autowired
    private EmailRepository repository;

    public Email sendConfirmationEmail(Email email) {
        return repository.save(email);
    }

}
