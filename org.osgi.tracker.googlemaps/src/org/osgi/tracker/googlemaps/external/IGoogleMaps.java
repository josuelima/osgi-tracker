package org.osgi.tracker.googlemaps.external;

public interface IGoogleMaps {

	// Dadas as coordenadas retorna a URL do mapa
	public String getMapUrl(String coordinates);

}
