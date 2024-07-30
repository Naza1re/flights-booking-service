package org.example.airportservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.airportservice.dto.AirportRequest;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.dto.AirportResponseList;
import org.example.airportservice.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirportById(id));

    }

    @GetMapping
    public ResponseEntity<AirportResponseList> getAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @PostMapping
    public ResponseEntity<AirportResponse> createAirport(@RequestBody AirportRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(airportService.createAirport(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(
            @RequestBody AirportRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(airportService.updateAirport(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AirportResponse> deleteAirport(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(airportService.deleteAirportById(id));
    }

}
