package org.osgi.tracker.bus;

import java.util.Hashtable;

import org.osgi.tracker.bus.external.IBus;
import org.osgi.tracker.bus.internal.BusImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando onibus ...");
		
		IBus service = new BusImpl();
		Activator.context.registerService(IBus.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("Onibus registrado");		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo onibus");
		Activator.context = null;
	}

}
