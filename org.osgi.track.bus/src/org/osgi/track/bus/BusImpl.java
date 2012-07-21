package org.osgi.track.bus;

import org.osgi.businterface.IBusService;

public class BusImpl implements IBusService {
	
	// Retorna as coordenadas do onibus
	@Override
	public String currentPosition() {
		return "100;100";
	}
	
}