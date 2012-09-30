/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballardview.devfest.places.service.bean;

import com.google.api.client.util.Key;
import com.ballardview.devfest.places.service.enums.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saden
 */
public class GPlace {

    @Key
    protected String id;
    @Key
    protected String name;
    @Key
    protected String reference;
    @Key
    protected String vicinity;
    @Key("formatted_address")
    protected String address;
    @Key("formatted_phone_number")
    protected String telephone;
    @Key("international_phone_number")
    protected String internationalTelephone;
    @Key("website")
    protected String websiteUrl;
    @Key("url")
    protected String googleUrl;
    @Key
    protected Float rating;
    @Key
    protected GGeometry geometry;
    @Key("icon")
    protected String iconUrl;
    @Key("address_components")
    protected GAddressComponent[] addressComponent;
    protected Map<GAddressType, String> addrMap = new HashMap();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GGeometry geometry) {
        this.geometry = geometry;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternationalTelephone() {
        return internationalTelephone;
    }

    public void setInternationalTelephone(String internationalTelephone) {
        this.internationalTelephone = internationalTelephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public GAddressComponent[] getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(GAddressComponent[] addressComponents) {
        this.addressComponent = addressComponents;
        this.addrMap = new EnumMap<GAddressType, String>(GAddressType.class);
        for (GAddressComponent comp : this.addressComponent) {
            addrMap.put(GAddressType.valueOf(comp.getTypes()[0]), comp.getLongName());
        }
    }

    public String getAddressComponent(GAddressType type) {
        if (addrMap == null || addrMap.isEmpty()) {
            if (addressComponent != null && addressComponent.length > 0) {
                for (GAddressComponent comp : this.addressComponent) {
                    GAddressType addrTyp = GAddressType.valueOf(comp.getTypes()[0]);
                    if (addrTyp == type) {
                        return comp.getLongName();
                    }
                }
                return null;
            }
        }

        return addrMap.get(type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[name: ");
        sb.append(name);
        sb.append(", address: ");
        sb.append(vicinity);
        sb.append(", vicinity: ");
        sb.append(address);
        sb.append(", telephone: ");
        sb.append(telephone);
        sb.append(", geometry: ");
        sb.append(geometry);
        sb.append(", website: ");
        sb.append(websiteUrl);
        sb.append("]");
        return sb.toString();
    }
}
