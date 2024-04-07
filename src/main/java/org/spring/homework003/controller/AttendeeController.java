package org.spring.homework003.controller;

import org.spring.homework003.model.Attendees;
import org.spring.homework003.model.Venues;
import org.spring.homework003.model.apiresponse.APIResponse;
import org.spring.homework003.model.dto.request.AttendeesRequest;
import org.spring.homework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Attendees>>> getAllAttendee(@RequestParam(defaultValue = "1") Integer offSet,
                                                                       @RequestParam(defaultValue = "3") Integer limit) {
        List<Attendees> attendees = attendeeService.getAllAttendee(offSet, limit);
        APIResponse<List<Attendees>> response = new APIResponse<>(
                "All attendees  have been successfully fetched.",
                attendees,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Attendees>> addAttendee(@RequestBody AttendeesRequest attendeesRequest) {
        Attendees attendees = attendeeService.addAttendee(attendeesRequest);
        APIResponse<Attendees> response = new APIResponse<>(
                "Attendee added successfully",
                attendees,
                HttpStatus.CREATED,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Attendees>> getAttendeeById(@PathVariable Integer id) {
        Attendees attendees = attendeeService.getAttendeeById(id);
        APIResponse<Attendees> response = new APIResponse<>(
                "The attendee has been successfully founded.",
                attendees,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Attendees>> updateAttendee(@PathVariable Integer id, @RequestBody AttendeesRequest attendeesRequest) {
        Attendees attendees = attendeeService.updateAttendee(id, attendeesRequest);
        APIResponse<Attendees> response = new APIResponse<>(
                "The attendee has been successfully updated.",
                attendees,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Attendees>> deleteAttendee(@PathVariable Integer id) {
        attendeeService.deleteAttendee(id);
        APIResponse<Attendees> response = new APIResponse<>(
                "The attendee has been successfully deleted.",
                null,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
