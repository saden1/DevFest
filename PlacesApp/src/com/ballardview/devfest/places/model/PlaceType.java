package com.ballardview.devfest.places.model;

import com.ballardview.devfest.places.service.enums.GPlaceType;

public class PlaceType {
	public int getCount() {
		return GPlaceType.values().length;
	}
	
	public Object getItem(int position) {
		return GPlaceType.values()[position];
	}
	
	public long getItemId(int position) {
		return 0;
	}
	
	public String getText(int position) {
		return getItem(position).toString();
	}
}
