package org.example.airportservice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {
    public static final String AIRPORT_NOT_FOUND_EXCEPTION_MESSAGE = "Airport with id ' %s ' not found";
    public static final String AIRPORT_ALREADY_EXIST = "Airport with name ' %s ' already exist";
}
