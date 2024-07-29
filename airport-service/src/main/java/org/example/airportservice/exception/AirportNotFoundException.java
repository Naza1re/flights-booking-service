package org.example.airportservice.exception;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String s) {
        super(s);
    }
}
