package org.spring.homework003.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesResponse {

    private Integer id;
    private String venueName;
    private String location;
}
