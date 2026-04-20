package clases;

public interface controlVolumen {
	final static int MIN_VOLUMEN = 0;
	final static int MAX_VOLUMEN = 100;
	public void subirVolumen() throws MandoApagadoException;
	public void bajarVolumen() throws MandoApagadoException;
}
