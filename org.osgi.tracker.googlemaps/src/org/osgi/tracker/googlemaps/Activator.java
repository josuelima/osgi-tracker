package org.osgi.tracker.googlemaps;

import java.util.Hashtable;

import org.osgi.tracker.googlemaps.external.IGoogleMaps;
import org.osgi.tracker.googlemaps.internal.GoogleMapsImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando GoogleMaps ...");
		
		IGoogleMaps service = new GoogleMapsImpl();
		Activator.context.registerService(IGoogleMaps.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("GoogleMaps registrado");		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo GoogleMaps");
		Activator.context = null;
	}

}
