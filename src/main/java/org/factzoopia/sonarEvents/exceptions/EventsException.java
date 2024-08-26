package org.factzoopia.sonarEvents.exceptions;

public class EventsException  extends RuntimeException {

    public EventsException(String message) {
        super(message);
    }

    public EventsException(String message, Throwable cause) {
        super(message, cause);
    }
}
