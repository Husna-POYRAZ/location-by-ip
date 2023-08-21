package com.hpoyraz.locationbyip.service;

import com.hpoyraz.locationbyip.model.Location;
import com.hpoyraz.locationbyip.service.impl.LocationService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {
    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        locationService = new LocationService();
    }

    @Test
    public void shouldReturnLocationForValidIP() throws IOException, GeoIp2Exception {
        String validIpAddress = "123.45.67.89";
        Location location = locationService.getLocationByIP(validIpAddress);

        assertEquals(validIpAddress, location.getIp());
        assertNotNull(location.getNetwork());
        assertNotNull(location.getCountryName());
        assertNotNull(location.getContinentName());
        assertNotNull(location.getContinentCode());
        assertNotNull(location.getTimeZone());
        assertNotNull(location.getCity());
    }

    @Test
    public void shouldReturnNullForInvalidIP() throws IOException, GeoIp2Exception {
        String invalidIpAddress = "192.168.1.1";
        Location location = locationService.getLocationByIP(invalidIpAddress);

        assertNull(location);
    }

    @Test
    public void shouldReturnNullForNullIP() throws IOException, GeoIp2Exception {
        Location location = locationService.getLocationByIP(null);

        assertNull(location);
    }
}

