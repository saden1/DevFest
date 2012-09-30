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
public class GGeometry {

    @Key
    protected GLocation location;

    @Override
    public String toString() {
        if (location != null) {
            return location.toString();
        }
        return super.toString();
    }

    public void setLocation(GLocation location) {
        this.location = location;
    }

    public GLocation getLocation() {
        return location;
    }
}
