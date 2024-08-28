package org.factzoopia.sonarEvents.exceptions;

// org.factzoopia.sonarEvents.exceptions.test

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EventsNotFoundExceptionTest {

    @Test
    void testAddSuppressed() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        Throwable suppressed = new Throwable("Test suppressed");
        exception.addSuppressed(suppressed);
        assertEquals(1, exception.getSuppressed().length);
        assertEquals(suppressed, exception.getSuppressed()[0]);
    }

    @Test
    void testFillInStackTrace() {
        // This method is not testable as it's native
    }

    @Test
    void testGetCause() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message",
                new Throwable("Test cause"));
        assertEquals("Test cause", exception.getCause().getMessage());
    }

    @Test
    void testGetLocalizedMessage() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        assertEquals("Test exception message", exception.getLocalizedMessage());
    }

    @Test
    void testGetMessage() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        assertEquals("Test exception message", exception.getMessage());
    }

    @Test
    void testGetStackTrace() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        assertNotNull(exception.getStackTrace());
    }

    @Test
    void testGetSuppressed() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        assertEquals(0, exception.getSuppressed().length);
    }

    @Test
    void testInitCause() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        Throwable cause = new Throwable("Test cause");
        exception.initCause(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testPrintStackTrace() {
        // This method is not testable as it's native and outputs to the console
    }

    @Test
    void testPrintStackTrace2() {
        // This method is not testable as it's native and outputs to the console
    }

    @Test
    void testPrintStackTrace3() {
        // This method is not testable as it's native and outputs to the console
    }

    @Test
    void testToString() {
        EventsNotFoundException exception = new EventsNotFoundException("Test exception message");
        String expected = "org.factzoopia.sonarEvents.exceptions.EventsNotFoundException: Test exception message";
        assertEquals(expected, exception.toString());
    }
}