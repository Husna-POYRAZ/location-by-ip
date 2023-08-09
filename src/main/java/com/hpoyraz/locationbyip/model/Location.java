package com.hpoyraz.locationbyip.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String ip;
    private String network;
    private String countryName;
    private String city;
    private String continentName;
    private String continentCode;
    private String timeZone;
    private double latitude;
    private double longitude;
}
