package com.hpoyraz.locationbyip.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(LocationGeoIp2Exception.class)
    public ResponseEntity<String> handleGeoIp2Exception(LocationGeoIp2Exception ex) {
        String errorMessage = "Error: Location information not found.";
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(LocationIOException.class)
    public ResponseEntity<String> handleIOException(LocationIOException ex) {
        String errorMessage = "Error: Input/Output error has occurred.";
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(DistrictnameNotFoundException.class)
    public ResponseEntity<String> handeleDistrictnameNotFoundException(DistrictnameNotFoundException ex) {
        String errorMessage = "Error: District name not found.";
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String errorMessage = "Something went wrong.";
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}