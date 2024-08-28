package org.factzoopia.sonarEvents.services;

import java.util.List;
import java.util.Arrays;

import org.factzoopia.sonarEvents.models.User;
import org.factzoopia.sonarEvents.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {

        User user = new User("user@example.com", "password");

        when(repository.save(user)).thenReturn(user);

        User result = userService.createUser(user);

        verify(repository).save(user);

        assertEquals(user, result);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(
                new User("user1@example.com", "password1"),
                new User("user2@example.com", "password2"));

        when(repository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        verify(repository).findAll();

        assertEquals(users, result);
    }
}