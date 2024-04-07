package org.spring.homework003.service;

import org.spring.homework003.model.Events;
import org.spring.homework003.model.dto.request.EventsRequest;

import java.util.List;

public interface EventService {

    List<Events> getAllEvent(Integer offSet, Integer limit);

    Events addEvent(EventsRequest eventsRequest);

    Events getEventById(Integer id);

    void deleteEvent(Integer id);

    Events updateEvent(Integer id, EventsRequest eventsRequest);
}
