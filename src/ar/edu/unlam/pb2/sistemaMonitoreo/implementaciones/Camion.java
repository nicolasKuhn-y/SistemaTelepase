package ar.edu.unlam.pb2.sistemaMonitoreo.implementaciones;

import ar.edu.unlam.pb2.sistemaMonitoreo.Vehiculo;

public class Camion extends Vehiculo {

	private Integer cantidadDeEjes;
	private final static Integer LIMITE_VELOCIDAD = 80;

	public Camion(String patente, Integer cantidadEjes) {
		super(patente, LIMITE_VELOCIDAD);
		this.cantidadDeEjes = cantidadEjes;

	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}

	@Override
	public Boolean enInfraccion() {
		return super.getVelocidadActual() > LIMITE_VELOCIDAD;
	}

}
