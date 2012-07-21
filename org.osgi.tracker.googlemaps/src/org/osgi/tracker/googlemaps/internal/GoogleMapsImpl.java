package org.osgi.tracker.googlemaps.internal;

import org.osgi.tracker.googlemaps.external.IGoogleMaps;

public class GoogleMapsImpl implements IGoogleMaps {

	private static String BASE_URL = "https://maps.google.com/maps?output=embed&q=";
	
	public String getMapUrl(String coordinates) {
		return BASE_URL + coordinates;
	}
	
}
