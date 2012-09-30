package com.ballardview.devfest.places.service;

import static com.ballardview.devfest.places.service.GooglePlacesService.API_KEY;
import static com.ballardview.devfest.places.service.GooglePlacesService.HTTP_TRANSPORT;
import static com.ballardview.devfest.places.service.GooglePlacesService.PLACES_SEARCH_URL;
import static com.ballardview.devfest.places.service.GooglePlacesService.RADIUS;
import static com.ballardview.devfest.places.service.GooglePlacesService.SENSOR;
import static com.ballardview.devfest.places.service.GooglePlacesService.createRequestFactory;

import java.io.IOException;

import android.os.AsyncTask;

import com.ballardview.devfest.places.adapter.PlacesListAdapter;
import com.ballardview.devfest.places.service.bean.GPlacesList;
import com.ballardview.devfest.places.service.bean.SearchParams;
import com.ballardview.devfest.places.service.enums.GRequestField;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;

public class PlacesSearchTask extends AsyncTask<SearchParams, Void, GPlacesList> {

	private PlacesListAdapter mListAdapter;

	public PlacesSearchTask(PlacesListAdapter placesListAdapter) {
		mListAdapter = placesListAdapter;
	}

	@Override
	protected GPlacesList doInBackground(SearchParams... params) {
		double latitude = params[0].getLatitude();
		double longitude = params[0].getLongitude();
		@SuppressWarnings("unused")
		double radius = params[0].getRadius();
		String types = params[0].getTypes();

		try {

			HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
			HttpRequest request = httpRequestFactory
					.buildGetRequest(new GenericUrl(PLACES_SEARCH_URL));
			request.getUrl().put(GRequestField.key.name(), API_KEY);
			request.getUrl().put(GRequestField.location.name(),
					latitude + "," + longitude);
			request.getUrl().put(GRequestField.radius.name(), RADIUS); // in
																		// meters
			request.getUrl().put(GRequestField.sensor.name(), SENSOR);
			if (types != null) {
				request.getUrl().put("types", types);
			}

			GPlacesList list = request.execute().parseAs(GPlacesList.class);
			// Check log cat for places response status
			// Log.d("Places Status", "" + list.status);
			return list;

		} catch (IOException e) {
			// Log.e("Error:", e.getMessage());
			return null;
		}
	}

	@Override
	protected void onPostExecute(GPlacesList result) {
		mListAdapter.setList(result);
	}

}
