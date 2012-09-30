/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballardview.devfest.places.service.bean;

import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author saden
 */
public class GPlacesList {

    @Key
    protected String status;
    @Key
    protected List<GPlace> results;

    public List<GPlace> getResults() {
        return results;
    }

    public void setResults(List<GPlace> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[status: ");
        sb.append(status);
        sb.append(", count: ");
        sb.append(results.size());
        sb.append("]");
        return sb.toString();
    }
}
