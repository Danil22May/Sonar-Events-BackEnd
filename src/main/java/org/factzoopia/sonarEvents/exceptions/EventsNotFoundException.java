package org.factzoopia.sonarEvents.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Event not found...")


public class EventsNotFoundException extends EventsException {

    public EventsNotFoundException(String message){
        super(message);
    }

    public EventsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
