package com.hpoyraz.locationbyip.service;

import com.hpoyraz.locationbyip.exception.LocationGeoIp2Exception;
import com.hpoyraz.locationbyip.model.Location;
import com.hpoyraz.locationbyip.service.impl.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {
    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        locationService = new LocationService();
    }

    @Test
    public void shouldReturnLocationForValidIP() {
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
    public void shouldThrowLocationGeoIp2ExceptionForInvalidIP() {
        String invalidIpAddress = "192.168.1.1";
        assertThrows(LocationGeoIp2Exception.class, () -> {
            locationService.getLocationByIP(invalidIpAddress);
        });
    }


    @Test
    public void shouldThrowLocationGeoIp2ExceptionForNullIP() throws LocationGeoIp2Exception{
        assertThrows(LocationGeoIp2Exception.class, () -> {
            locationService.getLocationByIP(null);
        });
    }
}

