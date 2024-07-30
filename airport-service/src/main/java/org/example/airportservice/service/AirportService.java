package org.example.airportservice.service;


import org.example.airportservice.dto.AirportRequest;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.dto.AirportResponseList;

public interface AirportService {
    AirportResponse getAirportById(Long id);

    AirportResponseList getAllAirports();

    AirportResponse createAirport(AirportRequest request);


    AirportResponse updateAirport(Long id, AirportRequest request);

    AirportResponse deleteAirportById(Long id);
}
