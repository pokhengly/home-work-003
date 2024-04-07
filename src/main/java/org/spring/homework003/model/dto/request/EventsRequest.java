package org.spring.homework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsRequest {

    private String eventName;
    private Date eventDate;
    private Integer venueId;
    private List<Integer> attendeesId;
}
