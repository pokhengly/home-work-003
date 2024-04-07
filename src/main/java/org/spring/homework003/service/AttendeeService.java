package org.spring.homework003.service;

import org.spring.homework003.model.Attendees;
import org.spring.homework003.model.dto.request.AttendeesRequest;

import java.util.List;

public interface AttendeeService {

    List<Attendees> getAllAttendee(Integer offSet, Integer limit);

    Attendees addAttendee(AttendeesRequest attendeesRequest);

    Attendees getAttendeeById(Integer id);

    Attendees updateAttendee(Integer id, AttendeesRequest attendeesRequest);

    void deleteAttendee(Integer id);
}
