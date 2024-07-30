package org.example.airportservice.mapper;

import lombok.RequiredArgsConstructor;
import org.example.airportservice.dto.AirportRequest;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.model.Airport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportMapper {
    private final ModelMapper modelMapper;

    public AirportResponse fromEntityToResponse(Airport airport) {
        return modelMapper.map(airport, AirportResponse.class);
    }

    public Airport fromRequestToEntity(AirportRequest airport) {
        return modelMapper.map(airport, Airport.class);
    }
}
