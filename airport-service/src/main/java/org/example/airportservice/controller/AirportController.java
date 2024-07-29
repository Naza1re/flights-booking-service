package org.example.airportservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.airportservice.dto.AirportResponse;
import org.example.airportservice.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airport")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(airportService.getAirportById(id));
    }



}
