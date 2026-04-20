package clases;

public interface controlVelocidad {
	final static int CAMBIO_VELOCIDAD = 1;
	public void subirVelocidad() throws MandoApagadoException;
	public void bajarVelocidad() throws MandoApagadoException;
}
