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
public class GAddressComponent {

    @Key("short_name")
    protected String shortName;
    @Key("long_name")
    protected String longName;
    @Key("types")
    protected String[] types;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }
}
