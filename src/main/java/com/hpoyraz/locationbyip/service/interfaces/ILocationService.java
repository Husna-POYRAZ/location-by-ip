package com.hpoyraz.locationbyip.service.interfaces;

import com.hpoyraz.locationbyip.model.Location;

public interface ILocationService {
    Location getLocationByIP(String ipAddress);
}
