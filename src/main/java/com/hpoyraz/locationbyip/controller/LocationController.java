package com.hpoyraz.locationbyip.controller;

import com.hpoyraz.locationbyip.model.Location;
import com.hpoyraz.locationbyip.service.impl.LocationService;
import com.hpoyraz.locationbyip.util.constants.ApiConstants;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping(ApiConstants.Location.BASE_URL)
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/{ipAddress}")
    public ResponseEntity<?> getLocationByIP(@PathVariable String ipAddress) {
        try {
            Location location = locationService.getLocationByIP(ipAddress);
            return ResponseEntity.ok(location);
        } catch (IOException | GeoIp2Exception e) {
            String errorMessage = "Error: Location information not found.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
