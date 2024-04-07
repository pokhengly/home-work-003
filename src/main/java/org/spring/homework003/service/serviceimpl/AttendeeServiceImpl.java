package org.spring.homework003.service.serviceimpl;

import org.spring.homework003.model.Attendees;
import org.spring.homework003.model.dto.request.AttendeesRequest;
import org.spring.homework003.repository.AttendeeRepository;
import org.spring.homework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {


    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendees> getAllAttendee(Integer offSet, Integer limit) {
        return attendeeRepository.getAllAttendee(offSet, limit);
    }

    @Override
    public Attendees addAttendee(AttendeesRequest attendeesRequest) {
        return attendeeRepository.addAttendee(attendeesRequest);
    }

    @Override
    public Attendees getAttendeeById(Integer id) {
        return attendeeRepository.getAttendeeById(id);
    }

    @Override
    public Attendees updateAttendee(Integer id, AttendeesRequest attendeesRequest) {
        return attendeeRepository.updateAttendee(id, attendeesRequest);
    }

    @Override
    public void deleteAttendee(Integer id) {
        attendeeRepository.deleteAttendee(id);
    }
}
