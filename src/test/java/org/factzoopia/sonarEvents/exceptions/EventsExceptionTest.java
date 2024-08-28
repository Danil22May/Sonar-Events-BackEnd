package org.factzoopia.sonarEvents.exceptions;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EventsExceptionTest {

    @Test
    void testAddSuppressed() {
        EventsException exception = new EventsException("Test exception message");
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
        EventsException exception = new EventsException("Test exception message", new Throwable("Test cause"));
        assertEquals("Test cause", exception.getCause().getMessage());
    }

    @Test
    void testGetLocalizedMessage() {
        EventsException exception = new EventsException("Test exception message");
        assertEquals("Test exception message", exception.getLocalizedMessage());
    }

    @Test
    void testGetMessage() {
        EventsException exception = new EventsException("Test exception message");
        assertEquals("Test exception message", exception.getMessage());
    }

    @Test
    void testGetStackTrace() {
        EventsException exception = new EventsException("Test exception message");
        assertNotNull(exception.getStackTrace());
    }

    @Test
    void testGetSuppressed() {
        EventsException exception = new EventsException("Test exception message");
        assertEquals(0, exception.getSuppressed().length);
    }

    @Test
    void testInitCause() {
        EventsException exception = new EventsException("Test exception message");
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
        EventsException exception = new EventsException("Test exception message");
        String expected = "org.factzoopia.sonarEvents.exceptions.EventsException: Test exception message";
        assertEquals(expected, exception.toString());
    }
}
