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
public class GPlaceDetail {

    @Key
    protected String status;
    @Key
    protected GPlace result;

    @Override
    public String toString() {
        if (result != null) {
            return result.toString();
        }
        return super.toString();
    }

    public GPlace getResult() {
        return result;
    }

    public void setResult(GPlace result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
