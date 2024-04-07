package org.spring.homework003.controller;

import lombok.Builder;
import org.spring.homework003.model.Venues;
import org.spring.homework003.model.apiresponse.APIResponse;
import org.spring.homework003.model.dto.request.VenuesRequest;
import org.spring.homework003.model.dto.response.VenuesResponse;
import org.spring.homework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
//@Builder
public class VenueController {

    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Venues>>> getAllVenues(@RequestParam(defaultValue = "1") Integer offSet,
                                                                  @RequestParam(defaultValue = "3") Integer limit) {
        List<Venues> venues = venueService.getAllVenues(offSet, limit);
        APIResponse<List<Venues>> response = new APIResponse<>(
                "All venues have been successfully fetched.",
                venues,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Venues>> addVenue(@RequestBody VenuesRequest venuesRequest) {
        Venues venues = venueService.addVenue(venuesRequest);
        APIResponse<Venues> response = new APIResponse<>(
                "The venue has been successfully added",
                venues,
                HttpStatus.CREATED,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Venues>> getVenueById(@PathVariable Integer id) {
        Venues venues = venueService.getVenueById(id);
        APIResponse<Venues> response = new APIResponse<>(
                "The venue has been successfully founded.",
                venues,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Venues>> deleteVenue(@PathVariable Integer id) {
        venueService.deleteVenue(id);
        APIResponse<Venues> response = new APIResponse<>(
                "The venue has been successfully deleted.",
                null,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Venues>> updateVenue(@PathVariable Integer id, @RequestBody VenuesRequest venuesRequest) {
        Venues venues = venueService.updateVenue(id, venuesRequest);
        APIResponse<Venues> response = new APIResponse<>(
                "The venue has been successfully updated.",
                venues,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


//    @PostMapping
//    public ResponseEntity<APIResponse<VenuesResponse>> addVenue(@RequestBody VenuesRequest venuesRequest) {
//        APIResponse<VenuesResponse> response = APIResponse.<VenuesResponse>builder()
//                .message("The venue has been successfully added")
//                .payload(venueService.addVenue(venuesRequest))
//                .status(HttpStatus.CREATED)
//                .dateTime(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<APIResponse<VenuesResponse>> getVenueById(@PathVariable Integer id){
//        APIResponse<VenuesResponse> response = APIResponse.<VenuesResponse>builder()
//                .message("The venue has been successfully founded.")
//                .payload(venueService.getVenueById(id))
//                .status(HttpStatus.OK)
//                .dateTime(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<APIResponse<VenuesResponse>> deleteVenue(@PathVariable Integer id){
//        APIResponse<VenuesResponse> response = APIResponse.<VenuesResponse>builder()
//                .message("The venue has been successfully deleted.")
//                .payload(venueService.deleteVenue(id))
//                .status(HttpStatus.NO_CONTENT)
//                .dateTime(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<APIResponse<VenuesResponse>> updateVenue(@PathVariable Integer id, @RequestBody VenuesRequest venuesRequest){
//        APIResponse<VenuesResponse> response = APIResponse.<VenuesResponse>builder()
//                .message("The venue has been successfully deleted.")
//                .payload(venueService.updateVenue(id, venuesRequest))
//                .status(HttpStatus.OK)
//                .dateTime(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }


}
