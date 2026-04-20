package clases;

/**
 * Clase MandoTV para Mandos de TV, hereda de la clase
 * MandoDistancia y de la interfaz controlVolumen
 */
public class MandoTV extends MandoDistancia implements controlVolumen {
	private static final int CAMBIO_VOLUMEN = 5;
	private static final int MIN_CANAL = 1;
	private static final int MAX_CANAL = 99;
	
	private int volumen = MIN_VOLUMEN;
	private int canal = MIN_CANAL;
	
	/**
	 * Constructor de mandos de TV
	 * @param modelo String modelo del mando
	 * @param precio double precio del mando
	 */
	public MandoTV(String modelo, double precio) {
		super(modelo, precio);
	}

	/**
	 * Getters/Setters
	 * @return
	 */
	public int getVolumen() {
		return volumen;
	}
	public int getCanal() {
		return canal;
	}
	
	/**
	 * Metodo para cambiar el Canal de la TV con el mando
	 * @param canal int canal a cambiar
	 * @throws MandoApagadoException no esta encendido
	 */
	public void cambiarCanal(int canal) throws MandoApagadoException {
		if (isEncendido()) {
			if (canal < MIN_CANAL && canal > MAX_CANAL) System.out.println("El canal no existe");
			else {
				this.canal = canal;
				System.out.println("Canal cambiado al "+canal);
			}
		} else throw new MandoApagadoException();
	}
	
	/**
	 * Override al metodo subirVolumen de la interfaz contolVolumen para subir el volumen con 
	 * el mando de Minicadena, maximo 100
	 * @throws MandoApagadoException no esta encendido
	 */
	@Override
	public void subirVolumen() throws MandoApagadoException {
		if (isEncendido()) {
			if (volumen < MAX_VOLUMEN) {
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
			if (volumen > MIN_VOLUMEN) {
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
		return super.toString()+ " MandoTV, volumen: "+volumen+", canal: "+canal;
	}
}
