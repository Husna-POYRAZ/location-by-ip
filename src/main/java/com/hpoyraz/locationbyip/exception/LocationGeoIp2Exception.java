package com.hpoyraz.locationbyip.exception;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.Getter;

@Getter
public class LocationGeoIp2Exception extends RuntimeException {
    public LocationGeoIp2Exception(String message) {
        super(message);
    }
}
