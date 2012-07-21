package org.osgi.tracker.map;

import java.util.Hashtable;

import org.osgi.tracker.map.external.IMap;
import org.osgi.tracker.map.internal.MapImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando Map ...");
		
		IMap service = new MapImpl(Activator.context);
		Activator.context.registerService(IMap.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("Map registrado");		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo Map");
		Activator.context = null;
	}

}
