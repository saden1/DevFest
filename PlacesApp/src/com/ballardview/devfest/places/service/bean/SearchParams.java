package com.ballardview.devfest.places.service.bean;

public class SearchParams {
	private double latitude;
	private double longitude;
	private String types;
	private double radius;
	
	public SearchParams(double latitude, double longitude, String types, double radius) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.types = types;
		this.radius = radius;
	}

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

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
