package com.hpoyraz.locationbyip.exception;

import lombok.Getter;

import java.io.IOException;

@Getter
public class LocationIOException extends RuntimeException {
    public LocationIOException(String message) {
        super(message);
    }
}
