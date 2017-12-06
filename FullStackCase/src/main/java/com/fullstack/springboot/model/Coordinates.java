package com.fullstack.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sourabh Suman on 06/12/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    private double latitude, longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
