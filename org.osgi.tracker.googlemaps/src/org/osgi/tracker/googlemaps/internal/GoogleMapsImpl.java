package org.osgi.tracker.googlemaps.internal;

import org.osgi.tracker.googlemaps.external.IGoogleMaps;

public class GoogleMapsImpl implements IGoogleMaps {

	// URL BASE que sera formatada adicionando a localizacao do objeto
	private static String BASE_URL = "https://maps.google.com/maps?output=embed&q=";

	// Dada as coordenadas monta a url
	public String getMapUrl(String coordinates) {
		return BASE_URL + coordinates;
	}
	
}
