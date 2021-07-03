package ar.edu.unlam.pb2.sistemaMonitoreo.excepciones;

public class VehiculoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5585495374120756509L;

	public VehiculoNotFoundException(String mensaje) {
		super(mensaje);
	}

}
