package org.example.airportservice.exception;

public class AirportAlreadyExist extends RuntimeException {
    public AirportAlreadyExist(String s) {
        super(s);
    }
}
