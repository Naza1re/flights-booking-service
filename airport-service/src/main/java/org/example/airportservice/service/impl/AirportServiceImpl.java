package org.example.airportservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.airportservice.dto.AirportRequest;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.dto.AirportResponseList;
import org.example.airportservice.exception.AirportAlreadyExist;
import org.example.airportservice.exception.AirportNotFoundException;
import org.example.airportservice.mapper.AirportMapper;
import org.example.airportservice.model.Airport;
import org.example.airportservice.repository.AirportRepository;
import org.example.airportservice.service.AirportService;
import org.example.airportservice.util.ExceptionMessages;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public AirportResponseList getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        List<AirportResponse> airportResponses = airports.stream()
                .map(airportMapper::fromEntityToResponse)
                .toList();
        return AirportResponseList.builder()
                .airportResponseList(airportResponses)
                .build();
    }

    private void checkAirportExisting(String name) {
        if (airportRepository.findAirportByName(name)) {
            throw new AirportAlreadyExist(String.format(ExceptionMessages.AIRPORT_ALREADY_EXIST,name));
        }
    }

    @Override
    public AirportResponse createAirport(AirportRequest request) {
        checkAirportExisting(request.getName());
        Airport airportToSave = airportMapper.fromRequestToEntity(request);
        Airport savedAirport = airportRepository.save(airportToSave);
        return airportMapper.fromEntityToResponse(savedAirport);

    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) {
        Airport airport = getOrThrow(id);
        Airport airportToSave = airportMapper.fromRequestToEntity(request);
        airportToSave.setId(airport.getId());
        Airport savedAirport = airportRepository.save(airportToSave);
        return airportMapper.fromEntityToResponse(savedAirport);
    }

    @Override
    public AirportResponse deleteAirportById(Long id) {
        Airport airport = getOrThrow(id);
        airportRepository.delete(airport);
        return airportMapper.fromEntityToResponse(airport);
    }

    private Airport getOrThrow(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException(String.format(AIRPORT_NOT_FOUND_EXCEPTION_MESSAGE, id)));
    }
}
