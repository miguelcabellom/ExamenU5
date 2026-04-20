package clases;

/**
 * Clase MandoAireAcondicionado para Mandos de Aires Acondicionados, hereda de la clase
 * MandoDistancia y de la interfaz controlVelocidad
 */
public class MandoAireAcondicionado extends MandoDistancia implements controlVelocidad {
	private final static int MAX_VELOCIDAD = 5;
	private final static int MIN_VELOCIDAD = 0;
	private final static int MAX_TEMPERATURA = 32;
	private final static int MIN_TEMPERATURA = 16;
	
	private enum modos {FRIO, CALOR};
	
	private int velocidad = MIN_VELOCIDAD;
	private modos modo = modos.FRIO;
	private double temperatura = MIN_TEMPERATURA;
	
	/**
	 * Constructor de mandos de Aires Acondicionados
	 * @param modelo String modelo del mando
	 * @param precio double precio del mando
	 */
	public MandoAireAcondicionado(String modelo, double precio) {
		super(modelo, precio);
	}

	/**
	 * Getters/Setters
	 * @return
	 */
	public int getVelocidad() {
		return velocidad;
	}
	public double getTemperatura() {
		return velocidad;
	}
	public modos getModo() {
		return modo;
	}
	
	/**
	 * Metodo que cambia el modo del mando
	 * @throws MandoApagadoException no esta encendido
	 */
	public void cambiarModo() throws MandoApagadoException {
		if (isEncendido()) {
			switch (modo) {
				case FRIO -> {
					modo = modos.CALOR;
				}
				case CALOR -> {
					modo = modos.FRIO;
				}
			}
			System.out.println("Cambiado a modo " + modo);
		} else throw new MandoApagadoException();
	}
	
	/**
	 * Metodo que cambia la temperatura del ventilador del Aire Acondicionado
	 * @param temperatura int temperatura del ventilador menor o igual a 32 y mayor o igual a 16
	 * @throws MandoApagadoException no esta encendido
	 */
	public void cambiarTemperatura(int temperatura) throws MandoApagadoException {
		if (isEncendido()) {
			if (temperatura <= MAX_TEMPERATURA && temperatura >= MIN_TEMPERATURA) {
				this.temperatura = temperatura;
				System.out.println("Temperatura cambiada a "+temperatura);
			}
			else System.out.println("Imposible cambiar temperatura, fuera de limites");
		} else throw new MandoApagadoException();
		
	}
	
	/**
	 * Override al metodo subirVelocidad de la interfaz contolVelocidad para subir la velocidad del 
	 * ventilador del Aire Acondicionado, maximo 5
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
	 * Override al metodo bajarVelocidad de la interfaz contolVelocidad para bajar la velocidad del
	 * ventilador del Aire Acondicionado, minimo 0
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
		return super.toString()+ " MandoAireAcondicionado, velocidad: "+velocidad+", temperatura: "+temperatura+", modo: "+modo;
	}
}
