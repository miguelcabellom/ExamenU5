package clases;

public class MandoDistancia implements Comparable {
	protected String modelo;
	protected double precio;
	protected boolean encendido = false;
	
	MandoDistancia(String modelo, double precio) {
		setModelo(modelo);
		setPrecio(precio);
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isEncendido() {
		return encendido;
	}
	
	public void encender() {
		if (isEncendido()) System.out.println("Ya estaba encendido");
		else {
			encendido = true;
			System.out.println("Encendiendo");
		}
	}
	public void apagar() {
		if (!isEncendido()) System.out.println("Ya estaba apagado");
		else {
			encendido = false;
			System.out.println("Apagando");
		}
	}

	/**
	 * Override al metodo toString para mostrar informacion que queremos sobre el objeto
	 */
	@Override
	public String toString() {
		return "Mando, modelo: "+modelo+", precio: "+precio+", está encendido?: "+encendido;
	}
	
	@Override
	public boolean equals(Object obj) {
		MandoDistancia otroMando = (MandoDistancia) obj;
		return modelo.equals(otroMando.modelo);
	}
	
	@Override
	public int compareTo(Object obj) {
		MandoDistancia otroMando = (MandoDistancia) obj;
		return modelo.compareToIgnoreCase(otroMando.modelo);
	}
	
}
