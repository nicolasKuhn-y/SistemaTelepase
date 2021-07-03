package ar.edu.unlam.pb2.sistemaMonitoreo;

import java.util.Comparator;

public class OrdenXPatente implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo other1, Vehiculo other2) {
		return other1.getPATENTE().compareTo(other2.getPATENTE());
	}
}
