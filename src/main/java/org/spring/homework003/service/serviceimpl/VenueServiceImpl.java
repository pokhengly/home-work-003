package org.spring.homework003.service.serviceimpl;

import org.spring.homework003.model.Venues;
import org.spring.homework003.model.dto.request.VenuesRequest;
import org.spring.homework003.repository.VenueRepository;
import org.spring.homework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {


    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venues> getAllVenues(Integer offSet, Integer limit) {
        return venueRepository.getAllVenues(offSet, limit);
    }

    @Override
    public Venues addVenue(VenuesRequest venuesRequest) {
        return venueRepository.addVenue(venuesRequest);
    }

    @Override
    public Venues getVenueById(Integer id) {
        return venueRepository.getVenueById(id);
    }

    @Override
    public void deleteVenue(Integer id) {
        venueRepository.deleteVenue(id);
    }

    @Override
    public Venues updateVenue(Integer id, VenuesRequest venuesRequest) {
        return venueRepository.updateVenue(id, venuesRequest);
    }
}
