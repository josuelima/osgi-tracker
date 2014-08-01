package org.osgi.tracker.servlet;

import java.io.IOException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.tracker.bus.external.IBus;
import org.osgi.tracker.animal.external.IAnimal;
import org.osgi.tracker.map.external.IMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrackerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static BundleContext context;
	
	static BundleContext getContext() { 
		return context; 
	}
	
	public TrackerServlet(BundleContext bundleContext) {
		context = bundleContext;	
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		String busMapUrl = getBusMapUrl();
		String animalMapUrl = getAnimalMapUrl();
		
		String html = "";
		
		// HTML HEADER
		html += "<html><body><h1>Sistema de Rastreamento</h1><br><ul>";
		
		// Caso o onibus ou serviÁo de mapa não esteja disponível		
		if(busMapUrl == null) {
			html += "<li><b>Onibus:</b> ServiÁo não disponível no momento</li>";
		} else {
			html += "<li><b>Onibus</b> <br>";
			html += "<iframe style=\"height: 270px; width: 450px;\" src=\"" + busMapUrl + "\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></li>";
		}
		
		// Caso o presidiario ou serviço de mapa não esteja disponível		
		if(animalMapUrl == null) {
			html += "<li><b>Animal:</b> ServiÁo não disponível no momento</li>";
		} else {
			html += "<li><b>Animal</b> <br>";
			html += "<iframe style=\"height: 270px; width: 450px;\" src=\"" + animalMapUrl + "\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></li>";
		}		
		
		// HTML FOOTER
		html += "</ul></body></html>";
		
		// output
		resp.getWriter().write(html);
		
	}
	
	
	// Busca as coordenadas do onibus
	private String getBusMapUrl() {
		ServiceReference<?> ref = context.getServiceReference(IBus.class.getName());
		if(ref == null) {
			return null;
		} else {
			IBus busService = (IBus) context.getService(ref);
			return getMapUrl(busService.currentPosition());
		}
	}
	
	// Busca as coordenadas do animal
	private String getAnimalMapUrl() {
		ServiceReference<?> ref = context.getServiceReference(IAnimal.class.getName());
		if(ref == null) {
			return null;
		} else {
			IAnimal animalService = (IAnimal) context.getService(ref);
			return getMapUrl(animalService.currentPosition());
		}
	}
	
	// Retorna a url para o mapa (google maps ou open quest, dado as coordenadas)
	private String getMapUrl(String coordinates) {
		ServiceReference<?> ref = context.getServiceReference(IMap.class.getName());
		if(ref == null) {
			return null;
		} else {
			IMap mapService = (IMap) context.getService(ref);
			return mapService.getMapUrl(coordinates);
		}
	}

}
