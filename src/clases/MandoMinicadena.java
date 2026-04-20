package clases;

/**
 * Clase MandoMinicadena para Mandos de Minicadena, hereda de la clase
 * MandoDistancia y de la interfaz controlVolumen
 */
public class MandoMinicadena extends MandoDistancia implements controlVolumen {
	private static final int CAMBIO_VOLUMEN = 10;
	private int volumen = 0;

	/**
	 * Constructor de mandos de Minicadena
	 * @param modelo String modelo del mando
	 * @param precio double precio del mando
	 */
	public MandoMinicadena(String modelo, double precio) {
		super(modelo, precio);
	}

	/**
	 * Getters/Setters
	 * @return
	 */
	public int getVolumen() {
		return volumen;
	}

	/**
	 * Override al metodo subirVolumen de la interfaz contolVolumen para subir el volumen con 
	 * el mando de Minicadena, maximo 100
	 * @throws MandoApagadoException no esta encendido
	 */
	@Override
	public void subirVolumen() throws MandoApagadoException {
		if (isEncendido()) {
			if (volumen < 100) {
				volumen += CAMBIO_VOLUMEN;
				System.out.println("Volumen subido");
			}
			else System.out.println("Imposible subir volumen, esta al maximo");
		} else throw new MandoApagadoException();
	}

	/**
	 * Override al metodo bajarVolumen de la interfaz contolVolumen para bajar el volumen con 
	 * el mando de Minicadena, minimo 0
	 * @throws MandoApagadoException no esta encendido
	 */
	@Override
	public void bajarVolumen() throws MandoApagadoException {
		if (isEncendido()) {
			if (volumen > 0) {
				volumen -= CAMBIO_VOLUMEN;
				System.out.println("Volumen bajado");
			}
			else System.out.println("Imposible bajar volumen, esta al minimo");
		} else throw new MandoApagadoException();
	}
	
	/**
	 * Override al metodo toString para mostrar informacion que queremos sobre el objeto
	 */
	@Override
	public String toString() {
		return super.toString()+ " MandoMinicadena, volumen: "+volumen;
	}
}
