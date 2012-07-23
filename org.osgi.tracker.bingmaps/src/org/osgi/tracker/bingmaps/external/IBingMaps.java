package org.osgi.tracker.bingmaps.external;

public interface IBingMaps {
	
	// Dadas as coordenadas retorna a URL do mapa
	public String getMapUrl(String coordinates);
	
}
