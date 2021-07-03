package ar.edu.unlam.pb2.sistemaMonitoreoTest;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.pb2.sistemaMonitoreo.*;
import ar.edu.unlam.pb2.sistemaMonitoreo.excepciones.*;
import ar.edu.unlam.pb2.sistemaMonitoreo.implementaciones.*;

public class AutopistaTest {

	@Test
	public void queSePuedaRegistrarElTelepaseDeUnVehiculo() {
		Autopista delBajo = new Autopista();

		Vehiculo dodge = new Automovil("AA22BB");

		Boolean resultado = delBajo.registrarTelepase(2131, dodge);

		assertTrue(resultado);

	}

	@Test
	public void queUnAutoConTelepasePuedaIngresarALaAutopista() {
		Autopista delBajo = new Autopista();

		Vehiculo dodge = new Automovil("AA22BB");

		delBajo.registrarTelepase(111, dodge);

		Boolean resultado = delBajo.ingresarAutopista(111);

		assertTrue(resultado);
	}

	@Test
	public void queUnAutoPuedaSalirDeLaAutopista() {
		Autopista delBajo = new Autopista();

		Vehiculo dodge = new Automovil("AA22BB");

		delBajo.registrarTelepase(111, dodge);
		delBajo.ingresarAutopista(111);

		Vehiculo esperado = dodge;
		Vehiculo obtenido = delBajo.salirAutopista(dodge);

		assertEquals(esperado, obtenido);
		assertTrue(delBajo.getVehiculosEnCirculacion().equals(0));
	}

	@Test
	public void queSePuedaDevolverOrdenadosXPatenteATodosLosVehiculosQueEstanEnInfraccion() {
		Autopista delBajo = new Autopista();

		Vehiculo dodge = new Automovil("ZZZ");
		Vehiculo ford = new Camion("BBB", 4);

		dodge.incrementarVelocidad(155);
		ford.incrementarVelocidad(100);

		delBajo.registrarTelepase(1111, dodge);
		delBajo.registrarTelepase(2222, ford);

		delBajo.ingresarAutopista(1111);
		delBajo.ingresarAutopista(2222);

		TreeSet<Vehiculo> listado = delBajo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();

		assertEquals(ford, listado.first());
		assertEquals(dodge, listado.last());
	}

	@Test(expected = TelepaseEmitidoException.class)
	public void queSeLanceUnaExcepcionSiSeQuiereRegistrarUnTelepaseYaEmitido() {
		Autopista delBajo = new Autopista();
		Vehiculo dodge = new Automovil("ZZZ");

		delBajo.registrarTelepase(1111, dodge);
		delBajo.registrarTelepase(1111, dodge);
	}

	@Test(expected = VehiculoNotFoundException.class)
	public void queSeLanceUnaExcepcionSiUnVehiculoQuiereEntrarALaAutopistaSinTelepase() {
		Autopista delBajo = new Autopista();

		delBajo.ingresarAutopista(111);
	}

	@Test(expected = VehiculoNotFoundException.class)
	public void queSeLanceUnaExcepcionSiUnVehiculoQuiereSalirDeAutopistaSinHaberEntrado() {
		Autopista delBajo = new Autopista();
		Vehiculo dodge = new Automovil("ZZZ");

		delBajo.salirAutopista(dodge);

	}

}
