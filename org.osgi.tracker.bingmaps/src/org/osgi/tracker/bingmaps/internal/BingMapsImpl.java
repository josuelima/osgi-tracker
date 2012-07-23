package org.osgi.tracker.bingmaps.internal;

import org.osgi.tracker.bingmaps.external.IBingMaps;

public class BingMapsImpl implements IBingMaps {
	
	// URL BASE que sera formatada adicionando a localizacao do objeto	
	private static String BASE_URL = "http://br.bing.com/maps/embed/?lvl=15&mkt=en-us&emid=5006da51-0919-ebe6-3928-3da69fb571a2&h=270&w=450&cp=LOCATION&pp=LOCATION";
	
	// Dada as coordenadas monta a url
	public String getMapUrl(String coordinates) {		
		String formatted_coordinates = coordinates.replaceAll(",", "~");
		String final_url = BASE_URL.replaceAll("LOCATION", formatted_coordinates); 
		return final_url;
	}
	
}
