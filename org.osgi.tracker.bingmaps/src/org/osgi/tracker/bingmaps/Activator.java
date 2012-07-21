package org.osgi.tracker.bingmaps;

import java.util.Hashtable;

import org.osgi.tracker.bingmaps.external.IBingMaps;
import org.osgi.tracker.bingmaps.internal.BingMapsImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando BingMaps ...");
		
		IBingMaps service = new BingMapsImpl();
		Activator.context.registerService(IBingMaps.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("BingMaps registrado");		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo BingMaps");
		Activator.context = null;
	}

}
