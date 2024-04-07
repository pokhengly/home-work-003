package org.spring.homework003.service.serviceimpl;

import org.spring.homework003.model.Attendees;
import org.spring.homework003.model.Events;
import org.spring.homework003.model.dto.request.EventsRequest;
import org.spring.homework003.repository.AttendeeRepository;
import org.spring.homework003.repository.EventRepository;
import org.spring.homework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventServiceImpl(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Events> getAllEvent(Integer offSet, Integer limit) {
        return eventRepository.getAllEvent(offSet, limit);
    }

    @Override
    public Events addEvent(EventsRequest eventsRequest) {
        Events events = eventRepository.addEvent(eventsRequest);
        List<Attendees> attendees = new ArrayList<>();
        for (Integer attendeeId : eventsRequest.getAttendeesId()) {
            Integer addAttendeeToEvent = eventRepository.addAttendeeToEvent(events.getEventId(), attendeeId);
            Attendees attendeeById = attendeeRepository.getAttendeeById(addAttendeeToEvent);
            attendees.add(attendeeById);
        }
        events.setAttendees(attendees);
        return events;
    }

    @Override
    public Events getEventById(Integer id) {
        return eventRepository.getEventById(id);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.deleteEvent(id);
    }


}
