package org.spring.homework003.repository;

import org.apache.ibatis.annotations.*;
import org.spring.homework003.model.Events;
import org.spring.homework003.model.dto.request.EventsRequest;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("SELECT e.*, v.*, a.* FROM events e " +
            "LEFT JOIN venues v ON e.venue_id = v.venue_id " +
            "LEFT JOIN event_attendee ea ON e.event_id = ea.event_id " +
            "LEFT JOIN attendees a ON ea.attendee_id = a.attendee_id " +
            "OFFSET #{offSet} LIMIT #{limit}")
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.spring.homework003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "org.spring.homework003.repository.AttendeeRepository.getAttendeeById"))
    })
    List<Events> getAllEvent(@Param("offSet") Integer offSet, @Param("limit") Integer limit);

    @Select("""
            INSERT INTO events (event_name, event_date, venue_id)
            VALUES (#{eventsRequest.eventName}, #{eventsRequest.eventDate}, #{eventsRequest.venueId})
            RETURNING *
            """)
    @ResultMap("eventMapper")
    Events addEvent(@Param("eventsRequest") EventsRequest eventsRequest);

    @Select("""
            INSERT INTO event_attendee (event_id, attendee_id)
            VALUES (#{eventId}, #{attendeeId})
            RETURNING attendee_id
            """)
    Integer addAttendeeToEvent(@Param("eventId") Integer eventId, @Param("attendeeId") Integer attendeeId);

    @Select("SELECT * FROM events WHERE event_id = #{id} ")
    @ResultMap("eventMapper")
    Events getEventById(Integer id);

    @Delete("""
            DELETE FROM event_attendee WHERE event_id = #{id};
            DELETE FROM events WHERE event_id = #{id}
            """)
    void deleteEvent(Integer id);

    @Select("""
            UPDATE events
            SET event_name = #{eventsRequest.eventName},
                event_date = #{eventsRequest.eventDate},
                venue_id = #{eventsRequest.venueId}
            WHERE event_id = #{id}
            RETURNING *
            """)
    @ResultMap("eventMapper")
    Events updateEvent(Integer id, EventsRequest eventsRequest);

}
