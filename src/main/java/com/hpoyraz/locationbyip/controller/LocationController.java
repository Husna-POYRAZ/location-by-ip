package com.hpoyraz.locationbyip.controller;

import com.hpoyraz.locationbyip.model.Location;
import com.hpoyraz.locationbyip.service.impl.LocationService;
import com.hpoyraz.locationbyip.service.interfaces.ILocationService;
import com.hpoyraz.locationbyip.util.constants.ApiConstants;
import lombok.RequiredArgsConstructor;;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(ApiConstants.Location.BASE_URL)
public class LocationController {
    private final ILocationService locationService;

    @GetMapping("/{ipAddress}")
    public ResponseEntity<Location> getLocationByIP(@PathVariable String ipAddress) {
        return ResponseEntity.ok(locationService.getLocationByIP(ipAddress));
    }

}
