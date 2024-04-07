package org.spring.homework003.controller;

import org.spring.homework003.model.Events;
import org.spring.homework003.model.apiresponse.APIResponse;
import org.spring.homework003.model.dto.request.EventsRequest;
import org.spring.homework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Events>>> getAllEvent(@RequestParam(defaultValue = "1") Integer offSet,
                                                                 @RequestParam(defaultValue = "3") Integer limit) {
        List<Events> event = eventService.getAllEvent(offSet, limit);
        APIResponse<List<Events>> response = new APIResponse<>(
                "All events have been successfully fetched.",
                event,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Events>> addEvent(@RequestBody EventsRequest eventsRequest) {
        Events event = eventService.addEvent(eventsRequest);
        APIResponse<Events> response = new APIResponse<>(
                "The event has been successfully added",
                event,
                HttpStatus.CREATED,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Events>> getEventById(@PathVariable Integer id) {
        Events event = eventService.getEventById(id);
        APIResponse<Events> response = new APIResponse<>(
                "The event has been successfully founded.",
                event,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Events>> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        APIResponse<Events> response = new APIResponse<>(
                "The event has been successfully deleted.",
                null,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }






}
