package org.osgi.tracker.animal;

import java.util.Hashtable;

import org.osgi.tracker.animal.external.IAnimal;
import org.osgi.tracker.animal.internal.AnimalImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Registrando animal ...");
		
		IAnimal service = new AnimalImpl();
		Activator.context.registerService(IAnimal.class.getName(), service, new Hashtable<String, Object>());
		
		System.out.println("Animal registrado");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Removendo animal");
		Activator.context = null;
	}

}
