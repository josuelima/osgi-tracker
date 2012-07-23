package org.osgi.tracker.map.internal;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.tracker.map.external.IMap;
import org.osgi.tracker.googlemaps.external.IGoogleMaps;
import org.osgi.tracker.bingmaps.external.IBingMaps;

public class MapImpl implements IMap {

	private static BundleContext context;
	private static int GOOGLE_MAPS_COUNTER = 0;
	
	static BundleContext getContext() { 
		return context; 
	}	
	
	public MapImpl(BundleContext bundleContext) {
		context = bundleContext;
	}
	
	public String getMapUrl(String coordinates) {
		
		/**
		 * Aqui sera simulado que o Google Maps tem o limite de apenas 1 request
		 * entao somente o primeiro mapa sera montado com google maps forcando que o
		 * o servico seja trocado para o bingmaps
		 */		
		
		if(GOOGLE_MAPS_COUNTER < 1) {
			GOOGLE_MAPS_COUNTER++;
			return getGoogleMapsLink(coordinates);
		} else {
			// Troca o servico
			return getBingMapsLink(coordinates);
		}
	}
	
	// Monta link com o googlemaps
	private String getGoogleMapsLink(String coordinates) {
		ServiceReference<?> ref = context.getServiceReference(IGoogleMaps.class.getName());
		if(ref == null) {
			return null;
		} else {
			IGoogleMaps googleMapsService = (IGoogleMaps) context.getService(ref);
			return googleMapsService.getMapUrl(coordinates);
		}
	}
	
	// Monta link com o bingmaps
	private String getBingMapsLink(String coordinates) {
		ServiceReference<?> ref = context.getServiceReference(IBingMaps.class.getName());
		if(ref == null) {
			return null;
		} else {
			IBingMaps bingMapsService = (IBingMaps) context.getService(ref);
			return bingMapsService.getMapUrl(coordinates);
		}
	}	

}