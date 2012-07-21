package org.osgi.track.bus;

import org.osgi.businterface.IBusService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator {
	
	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		String name = (String) Activator.context.getBundle().getHeaders().get(Constants.BUNDLE_NAME); 
		System.out.println(" Bundle " + name + " starting ...");
		
		IBusService service = new BusImpl();
		Activator.context.registerService(IBusService.class.getName(), service, null);
		System.out.println(" Bundle " + name + " registered service.");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		String name = (String) Activator.context.getBundle().getHeaders().get(Constants.BUNDLE_NAME); 
		System.out.println(" Bundle " + name + " stopping ...");
		Activator.context = null;
	}

}
