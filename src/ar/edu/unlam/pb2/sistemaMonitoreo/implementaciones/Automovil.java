package ar.edu.unlam.pb2.sistemaMonitoreo.implementaciones;

import ar.edu.unlam.pb2.sistemaMonitoreo.Vehiculo;

public class Automovil extends Vehiculo {

	private final static Integer LIMITE_VELOCIDAD = 130;

	public Automovil(String patente) {
		super(patente, LIMITE_VELOCIDAD);

	}

	@Override
	public Boolean enInfraccion() {
		return super.getVelocidadActual() > LIMITE_VELOCIDAD;
	}

}
