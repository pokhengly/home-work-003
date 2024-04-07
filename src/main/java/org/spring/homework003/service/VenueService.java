package org.spring.homework003.service;


import org.spring.homework003.model.Venues;
import org.spring.homework003.model.dto.request.VenuesRequest;
import org.spring.homework003.model.dto.response.VenuesResponse;

import java.util.List;

public interface VenueService {

    List<Venues> getAllVenues(Integer offSet, Integer limit);

    Venues addVenue(VenuesRequest venuesRequest);

    Venues getVenueById(Integer id);

    void deleteVenue(Integer id);

    Venues updateVenue(Integer id, VenuesRequest venuesRequest);



//    List<VenuesResponse> getAllVenues();
//
//    VenuesResponse addVenue(VenuesRequest venuesRequest);
//
//    VenuesResponse getVenueById(Integer id);
//
//    VenuesResponse deleteVenue(Integer id);
//
//    VenuesResponse updateVenue(Integer id, VenuesRequest venuesRequest);
}
