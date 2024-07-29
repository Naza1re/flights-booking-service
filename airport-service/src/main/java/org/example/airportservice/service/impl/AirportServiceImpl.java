package org.example.airportservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.exception.AirportNotFoundException;
import org.example.airportservice.mapper.AirportMapper;
import org.example.airportservice.model.Airport;
import org.example.airportservice.repository.AirportRepository;
import org.example.airportservice.service.AirportService;
import org.springframework.stereotype.Service;

import static org.example.airportservice.util.ExceptionMessages.AIRPORT_NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public AirportResponse getAirportById(Long id) {
        Airport airport = getOrThrow(id);
        return airportMapper.fromEntityToResponse(airport);
    }

    private Airport getOrThrow(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(()-> new AirportNotFoundException(String.format(AIRPORT_NOT_FOUND_EXCEPTION_MESSAGE,id)));
    }
}
