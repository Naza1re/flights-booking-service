package org.example.airportservice.service;


import org.example.airportservice.dto.AirportResponse;

public interface AirportService {
    AirportResponse getAirportById(Long id);
}
