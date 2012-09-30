/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballardview.devfest.places.service;


import com.ballardview.devfest.places.service.bean.GPlaceDetail;
import com.ballardview.devfest.places.service.bean.GPlacesList;
import com.ballardview.devfest.places.service.enums.GRequestField;

import com.google.api.client.extensions.android3.json.AndroidJsonFactory;
import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import org.apache.http.client.HttpResponseException;

public class GooglePlacesService {

    /**
     * Global instance of the HTTP transport.
     */
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    // Google API Key
    private static final String API_KEY = "AIzaSyCDFSQNJSEpW0xSk_1AzFminUa14NBEZCg";
    // Google Places serach url's
    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?";
    private static final String RADIUS = "30000";
    private static final String SENSOR = "false";


    /**
     * Searching places
     *
     * @param latitude - latitude of place
     * @params longitude - longitude of place
     * @param radius - radius of searchable area
     * @param types - type of place to search
     * @return list of places
     *
     */
    public GPlacesList search(double latitude, double longitude, double radius, String types)
            throws Exception {

        try {

            HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
            HttpRequest request = httpRequestFactory
                    .buildGetRequest(new GenericUrl(PLACES_SEARCH_URL));
            request.getUrl().put(GRequestField.key.name(), API_KEY);
            request.getUrl().put(GRequestField.location.name(), latitude + "," + longitude);
            request.getUrl().put(GRequestField.radius.name(), RADIUS); // in meters
            request.getUrl().put(GRequestField.sensor.name(), SENSOR);
            if (types != null) {
                request.getUrl().put("types", types);
            }

            GPlacesList list = request.execute().parseAs(GPlacesList.class);
            // Check log cat for places response status
            //Log.d("Places Status", "" + list.status);
            return list;

        } catch (HttpResponseException e) {
            //Log.e("Error:", e.getMessage());
            return null;
        }

    }

    /**
     * Searching single place full details
     *
     * @param refrence - reference id of place - which you will get in search
     * api request
     *
     */
    public GPlaceDetail getPlaceDetails(String reference) throws Exception {
        try {

            HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
            HttpRequest request = httpRequestFactory
                    .buildGetRequest(new GenericUrl(PLACES_DETAILS_URL));
            request.getUrl().put(GRequestField.key.name(), API_KEY);
            request.getUrl().put(GRequestField.reference.name(), reference);
            request.getUrl().put(GRequestField.sensor.name(), SENSOR);

            GPlaceDetail place = request.execute().parseAs(GPlaceDetail.class);

            return place;

        } catch (HttpResponseException e) {
            //Log.e("Error in Perform Details", e.getMessage());
            throw e;
        }
    }

    /**
     * Creating http request Factory
     *
     */
    public static HttpRequestFactory createRequestFactory(
            final HttpTransport transport) {
        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                GoogleHeaders headers = new GoogleHeaders();
                headers.setApplicationName("API Project");
                request.setHeaders(headers);
                JsonObjectParser parser = new JsonObjectParser(new AndroidJsonFactory());
                request.setParser(parser);
            }
        });
    }
}