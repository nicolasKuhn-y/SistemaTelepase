package ar.edu.unlam.pb2.sistemaMonitoreo;

import ar.edu.unlam.pb2.sistemaMonitoreo.interfaces.Imultable;

public abstract class Vehiculo implements Imultable {

	private final String PATENTE;
	private Integer velocidadActual;
	private final Integer LIMITE_VELOCIDAD;

	public Vehiculo(String patente, Integer limiteVelocidad) {
		this.PATENTE = patente;
		this.velocidadActual = 0;
		this.LIMITE_VELOCIDAD = limiteVelocidad;
	}

	public void incrementarVelocidad(Integer velocidad) {
		this.velocidadActual += velocidad;
	}

	public Integer getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(Integer velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public String getPATENTE() {
		return PATENTE;
	}

	public Integer getLIMITE_VELOCIDAD() {
		return LIMITE_VELOCIDAD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PATENTE == null) ? 0 : PATENTE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (PATENTE == null) {
			if (other.PATENTE != null)
				return false;
		} else if (!PATENTE.equals(other.PATENTE))
			return false;
		return true;
	}



}
