package org.spring.homework003.repository;

import org.apache.ibatis.annotations.*;
import org.spring.homework003.model.Attendees;
import org.spring.homework003.model.dto.request.AttendeesRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("SELECT * FROM attendees OFFSET #{offSet} LIMIT #{limit}")
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    List<Attendees> getAllAttendee(@Param("offSet") Integer offSet, @Param("limit") Integer limit);

    @Select("INSERT INTO attendees (attendee_name, email) VALUES (" +
            "#{attendeesRequest.attendeeName}, " +
            "#{attendeesRequest.email}) " +
            "RETURNING *;")
    @ResultMap("attendeeMapper")
    Attendees addAttendee(@Param("attendeesRequest") AttendeesRequest attendeesRequest);

    @Select("SELECT * FROM attendees WHERE attendee_id = #{id}")
    @ResultMap("attendeeMapper")
    Attendees getAttendeeById(Integer id);

    @Select("UPDATE attendees SET " +
            "attendee_name = #{attendeesRequest.attendeeName}, " +
            "email = #{attendeesRequest.email} " +
            "WHERE attendee_id = #{id} " +
            "RETURNING *;")
    @ResultMap("attendeeMapper")
    Attendees updateAttendee(Integer id, AttendeesRequest attendeesRequest);

    @Delete("DELETE FROM attendees WHERE attendee_id = #{id}")
    @ResultMap("attendeeMapper")
    void deleteAttendee(Integer id);

}
