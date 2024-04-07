package org.spring.homework003.repository;

import org.apache.ibatis.annotations.*;
import org.spring.homework003.model.Venues;
import org.spring.homework003.model.dto.request.VenuesRequest;

import java.util.List;


@Mapper
public interface VenueRepository {

    @Select("SELECT * FROM venues" +
            " OFFSET #{offSet} LIMIT #{limit}")
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "location", column = "location")
    })
    List<Venues> getAllVenues(@Param("offSet") Integer offSet, @Param("limit") Integer limit);
    @Select("INSERT INTO venues (venue_name, location) " +
            "VALUES (#{venueRequest.venueName}, " +
            "#{venueRequest.location}) " +
            "RETURNING *")
    @ResultMap("venueMapper")
    Venues addVenue(@Param("venueRequest") VenuesRequest venuesRequest);

    @Select("SELECT * FROM venues WHERE venue_id = #{id}")
    @ResultMap("venueMapper")
    Venues getVenueById(Integer id);

    @Delete("DELETE FROM venues WHERE venue_id = #{id}")
    void deleteVenue(Integer id);

    @Select("UPDATE venues SET venue_name = " +
            "#{venuesRequest.venueName}, " +
            "location = #{venuesRequest.location} " +
            "WHERE venue_id = #{id} " +
            "RETURNING *")
    @ResultMap("venueMapper")
    Venues updateVenue(Integer id, @Param("venuesRequest") VenuesRequest venuesRequest);


//    @Select("SELECT * FROM venues")
//    @Results(id = "venueMapper", value = {
//            @Result(property = "venueId", column = "venue_id"),
//            @Result(property = "venueName", column = "venue_name"),
//            @Result(property = "location", column = "location")
//    })
//    List<Venues> getAllVenues();
//
//    @Insert("INSERT INTO venues (venue_name, location) VALUES (" +
//            "#{venuesRequest.venueName}, " +
//            "#{venuesRequest.location}) " +
//            "RETURNING *")
//    @ResultMap("venueMapper")
//    Object addVenue(VenuesRequest venuesRequest);
//
//    @Select("SELECT * FROM venues WHERE venue_id = #{id}")
//    @ResultMap("venueMapper")
//    Object getVenueById(Integer id);
//
//    @Select("DELETE FROM venues WHERE venue_id = #{id}")
//    @ResultMap("venueMapper")
//    Object deleteVenue(Integer id);
//
//    @Select("UPDATE venues SET venue_name = " +
//            "#{venuesRequest.venueName}, location = " +
//            "#{venuesRequest.location} " +
//            "WHERE venue_id = #{id} " +
//            "RETURNING *")
//    @ResultMap("venueMapper")
//    Object updateVenue(Integer id, VenuesRequest venuesRequest);
}
