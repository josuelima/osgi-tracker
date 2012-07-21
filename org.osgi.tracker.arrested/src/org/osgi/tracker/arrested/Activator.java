package org.osgi.tracker.arrested;

import java.util.Hashtable;

import org.osgi.tracker.arrested.external.IArrested;
import org.osgi.tracker.arrested.internal.ArrestedImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando presidiario ...");
		
		IArrested service = new ArrestedImpl();
		Activator.context.registerService(IArrested.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("Presidiario registrado");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo presidiario");
		Activator.context = null;
	}

}
