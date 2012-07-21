package org.osgi.tracker.servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator { 
	
	private static BundleContext context;
	
	static BundleContext getContext() { 
		return context; 
	}
	
	public void start(BundleContext bundleContext) throws Exception { 
		Activator.context = bundleContext; 
		ServiceReference<HttpService> sr = context.getServiceReference(HttpService.class); 
		HttpService http = (HttpService)context.getService(sr); 
   
		if (http != null) { 
			http.registerServlet("/tracker", new TrackerServlet(Activator.context), null, null); 
			System.out.println("Servlet registrado"); 
		}
	}

	public void stop(BundleContext bundleContext) throws Exception { 
		Activator.context = null; 
	}
	
}
