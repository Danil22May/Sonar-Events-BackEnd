package org.factzoopia.sonarEvents.services;

import org.factzoopia.sonarEvents.models.Email;
import org.factzoopia.sonarEvents.repositories.EmailRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private EmailRepository repository;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendConfirmationEmail() {
       
        Email email = new Email("receiver@example.com", "Información del email", null, null);

        when(repository.save(email)).thenReturn(email);

        Email result = emailService.sendConfirmationEmail(email);

        verify(repository).save(email);

        assertEquals(email, result);
    }
}
