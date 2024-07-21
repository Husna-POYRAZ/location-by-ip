package com.hpoyraz.locationbyip.service.impl;

import com.hpoyraz.locationbyip.exception.LocationGeoIp2Exception;
import com.hpoyraz.locationbyip.exception.LocationIOException;
import com.hpoyraz.locationbyip.service.interfaces.ILocationService;
import com.hpoyraz.locationbyip.util.constants.DatabaseConstants;
import com.hpoyraz.locationbyip.exception.DistrictnameNotFoundException;
import com.hpoyraz.locationbyip.model.Location;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

@Service
public class LocationService implements ILocationService {


    @Override
    public Location getLocationByIP(String ipAddress) {
        try {
            File database = new File(DatabaseConstants.dbLocation);
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            InetAddress ip = InetAddress.getByName(ipAddress);
            CityResponse response = reader.city(ip);
            Country country = response.getCountry();

            List<Subdivision> subdivisionList = response.getSubdivisions();

            Location location = new Location();
            location.setIp(ipAddress);
            location.setNetwork(String.valueOf(response.getTraits().getNetwork()));
            location.setCountryName(response.getCountry().getName().equals("Turkey") ? "Türkiye" : country.getName());

            String cityName = response.getCity().getName();
            if (!subdivisionList.isEmpty()) {
                Subdivision subdivision = subdivisionList.get(0);
                String districtName = subdivision.getNames().values().stream().findFirst().orElseThrow(() -> new DistrictnameNotFoundException("District not found!"));
                if (!districtName.isEmpty() && !districtName.equals(cityName) && cityName != null) {
                    cityName = districtName + "," + cityName;
                }
            } else {
                if (cityName == null || cityName.isEmpty()) {
                    String timeZone = response.getLocation().getTimeZone();
                    String[] parts = timeZone.split("/");
                    cityName = parts[1];
                }
            }

            location.setCity(cityName);
            location.setContinentName(response.getContinent().getName());
            location.setContinentCode(response.getContinent().getCode());
            location.setTimeZone(response.getLocation().getTimeZone());
            location.setLatitude(response.getLocation().getLatitude());
            location.setLongitude(response.getLocation().getLongitude());

            return location;
        } catch (IOException e) {
            throw new LocationIOException("I/O Error: " + e.getMessage());
        } catch (GeoIp2Exception e) {
            throw new LocationGeoIp2Exception("GeoIP2 Error: " + e.getMessage());
        }
    }
}