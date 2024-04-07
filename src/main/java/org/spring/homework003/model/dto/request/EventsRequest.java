package org.spring.homework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

    private Integer event_id;
    private String event_name;
    private Date event_date;
    private Integer venue_id;
}
