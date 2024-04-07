package org.spring.homework003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

    private Integer eventId;
    private String eventName;
    private Date eventDate;
    private Venues venue;
    private List<Attendees> attendees;
}
