package org.spring.homework003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venues {

    private Integer venueId;
    private String venueName;
    private String location;

}
