package com.hpoyraz.locationbyip.controller;

import com.hpoyraz.locationbyip.model.Location;
import com.hpoyraz.locationbyip.service.impl.LocationService;
import com.hpoyraz.locationbyip.util.constants.ApiConstants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.Location.BASE_URL)
public class LocationController {
    private final LocationService locationService;

    @SneakyThrows
    @GetMapping("/{ipAddress}")
    public Location getLocationByIP(@PathVariable String ipAddress) {
        return locationService.getLocationByIP(ipAddress);
    }
}
