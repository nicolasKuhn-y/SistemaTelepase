package ar.edu.unlam.pb2.sistemaMonitoreo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.sistemaMonitoreo.excepciones.VehiculoNotFoundException;

public class Autopista {

	private Map<Integer, Vehiculo> telepase;
	private Set<Vehiculo> vehiculosEnCirculacion;

	public Autopista() {
		this.telepase = new HashMap<>();
		this.vehiculosEnCirculacion = new HashSet<>();
	}

	public Boolean registrarTelepase(Integer numeroTelepase, Vehiculo vehiculo) {

		if (this.telepase.containsKey(numeroTelepase))
			throw new TelepaseEmitidoException("El telepase se encuentra emitido");

		this.telepase.put(numeroTelepase, vehiculo);
		return Boolean.TRUE;

	}

	public Boolean ingresarAutopista(Integer numeroTelepase) {

		if (this.telepase.containsKey(numeroTelepase)) {
			this.vehiculosEnCirculacion.add(this.telepase.get(numeroTelepase));
			return Boolean.TRUE;
		}

		throw new VehiculoNotFoundException("El vehiculo no cuenta con un telepase.");

	}

	public Vehiculo salirAutopista(Vehiculo vehiculoBuscado) {

		for (Vehiculo vehiculo : vehiculosEnCirculacion) {

			if (vehiculo.equals(vehiculoBuscado)) {
				this.vehiculosEnCirculacion.remove(vehiculo);
				return vehiculo;
			}

		}
		throw new VehiculoNotFoundException("El vehiculo no se encuentra en circulacion");
	}

	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente() {

		TreeSet<Vehiculo> vehiculosOrdenados = new TreeSet<>(new OrdenXPatente());

		for (Vehiculo vehiculo : this.vehiculosEnCirculacion) {

			if (vehiculo.enInfraccion())
				vehiculosOrdenados.add(vehiculo);

		}

		return vehiculosOrdenados;
	}

	public Integer getVehiculosEnCirculacion() {

		return this.vehiculosEnCirculacion.size();
	}
}
