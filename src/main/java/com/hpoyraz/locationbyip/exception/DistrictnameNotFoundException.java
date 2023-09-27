package com.hpoyraz.locationbyip.exception;

import lombok.Getter;

@Getter
public class DistrictnameNotFoundException extends RuntimeException {
    public DistrictnameNotFoundException (String message) {
        super(message);
    }
}

