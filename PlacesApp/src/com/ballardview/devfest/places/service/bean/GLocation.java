/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballardview.devfest.places.service.bean;

import com.google.api.client.util.Key;

/**
 *
 * @author saden
 */
public class GLocation {

    @Key("lat")
    protected Double latitude;
    @Key("lng")
    protected Double longitude;

    public GLocation() {
    }

    public GLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[latitude: ");
        sb.append(latitude);
        sb.append(", longitude: ");
        sb.append(longitude);
        sb.append("]");
        return sb.toString();
    }
}
