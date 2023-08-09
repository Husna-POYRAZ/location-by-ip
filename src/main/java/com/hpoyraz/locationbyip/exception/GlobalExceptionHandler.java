package com.hpoyraz.locationbyip.exception;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GeoIp2Exception.class)
    public ResponseEntity<String> handleGeoIp2Exception(GeoIp2Exception ex) {
        String errorMessage = "Error: Location information not found.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        String errorMessage = "Error: Input/Output error has occurred.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(DistrictnameNotFoundException.class)
    public ResponseEntity<String> handeleDistrictnameNotFoundException (DistrictnameNotFoundException ex) {
        String errorMessage = "Error: District name not found.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String errorMessage = "Something went wrong.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

}
