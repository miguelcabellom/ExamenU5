package clases;

/**
 * Clase MandoAspiradora para Mandos de Aspiradoras, hereda de la clase
 * MandoDistancia y de la interfaz controlVelocidad
 */
public class MandoAspiradora extends MandoDistancia implements controlVelocidad {
	private final static int MAX_VELOCIDAD = 3;
	private final static int MIN_VELOCIDAD = 0;
	
	private int velocidad = 0;

	/**
	 * Constructor de mandos de Aspiradoras
	 * @param modelo String modelo del mando
	 * @param precio double precio del mando
	 */
	public MandoAspiradora(String modelo, double precio) {
		super(modelo, precio);
	}

	/**
	 * Getters/Setters
	 * @return
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Override al metodo subirVelocidad de la interfaz contolVelocidad para subir la velocidad de 
	 * la Aspiradora, maximo 5
	 * @throws MandoApagadoException no esta encendido
	 */
	@Override
	public void subirVelocidad() throws MandoApagadoException {
		if (isEncendido()) {
			if (velocidad < MAX_VELOCIDAD) {
				velocidad += CAMBIO_VELOCIDAD;
				System.out.println("Velocidad subida");
			}
			else System.out.println("Imposible subir velocidad, esta al maximo");
		} else throw new MandoApagadoException();
	}
	/**
	 * Override al metodo bajarVelocidad de la interfaz contolVelocidad para bajar la velocidad de
	 * la Aspiradora, minimo 0
	 * @throws MandoApagadoException no esta encendido
	 */
	@Override
	public void bajarVelocidad() throws MandoApagadoException {
		if (isEncendido()) {
			if (velocidad > MIN_VELOCIDAD) {
				velocidad -= CAMBIO_VELOCIDAD;
				System.out.println("Velocidad bajada");
			}
			else System.out.println("Imposible bajar velocidad, esta al minimo");
		} else throw new MandoApagadoException();
	}

	/**
	 * Override al metodo toString para mostrar informacion que queremos sobre el objeto
	 */
	@Override
	public String toString() {
		return super.toString()+ " MandoAspiradora, velocidad: "+velocidad;
	}
}
