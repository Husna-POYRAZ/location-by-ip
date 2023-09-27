package com.hpoyraz.locationbyip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.net.UnknownHostException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LocationGeoIp2Exception.class)
    public ResponseEntity<String> handleGeoIp2Exception(LocationGeoIp2Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(LocationIOException.class)
    public ResponseEntity<String> handleIOException(LocationIOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<String> handleUnknownHostException(UnknownHostException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(DistrictnameNotFoundException.class)
    public ResponseEntity<String> handleDistrictNameNotFoundException(DistrictnameNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}

