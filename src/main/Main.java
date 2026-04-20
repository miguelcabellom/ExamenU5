package main;

import java.util.Arrays;

import clases.MandoDistancia;
import clases.MandoTV;
import clases.MandoMinicadena;
import clases.MandoAspiradora;
import clases.MandoAireAcondicionado;

import clases.MandoApagadoException;

public class Main {

	public static void main(String[] args) {
		MandoDistancia[] mandos = new MandoDistancia[] {
			new MandoTV("Samsung", 20.50),
			new MandoMinicadena("Alcachofa", 15.99),
			new MandoAspiradora("BOS", 32.00),
			new MandoAireAcondicionado("Frioleros", 26.43)
		};
		Arrays.sort(mandos);
		System.out.println(Arrays.deepToString(mandos));
		
		seleccionFunciones(mandos);
	}
	
	/**
	 * Funcion para elegir la funcion correspondiente segun la clase del objeto de la lista
	 * @param mandos lista de Mandos Ordenada por modelo
	 */
	public static void seleccionFunciones(MandoDistancia[] mandos) {
		for (MandoDistancia mando : mandos) {
			mando.encender();
			if (mando instanceof MandoTV) funcionMandoTV(mando);
			else if (mando instanceof MandoMinicadena) funcionMandoMinicadena(mando);
			else if (mando instanceof MandoAspiradora) funcionMandoAspiradora(mando);
			else if (mando instanceof MandoAireAcondicionado) funcionMandoAireAcondicionado(mando);
		}
	}
	
	/**
	 * Funcion para los mandos de TV que cambian de canal y suben y bajan volumen 
	 * @param obj mando de TV
	 */
	public static void funcionMandoTV(Object obj) {
		MandoTV mando = (MandoTV) obj;
		try {
			mando.cambiarCanal(73);
			mando.subirVolumen();
			mando.bajarVolumen();
		} catch (MandoApagadoException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Funcion para los mandos de Minicadena que suben y bajan volumen
	 * @param obj mando de Minicadena
	 */
	public static void funcionMandoMinicadena(Object obj) {
		MandoMinicadena mando = (MandoMinicadena) obj;
		try {
			mando.subirVolumen();
			mando.bajarVolumen();
		} catch (MandoApagadoException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Funcion para los mandos de Aspiradora que suben y bajan la velocidad
	 * @param obj mando de Aspiradora
	 */
	public static void funcionMandoAspiradora(Object obj) {
		MandoAspiradora mando = (MandoAspiradora) obj;
		try {
			mando.subirVelocidad();
			mando.bajarVelocidad();
		} catch (MandoApagadoException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Funcion para los mandos de Aire Acondicionado que cambian el modo, cambian la temperatura y
	 * suben y bajan la velocidad
	 * @param obj mando de Aire Acondicionado
	 */
	public static void funcionMandoAireAcondicionado(Object obj) {
		MandoAireAcondicionado mando = (MandoAireAcondicionado) obj;
		try {
			mando.cambiarModo();
			mando.cambiarTemperatura(24);
			mando.subirVelocidad();
			mando.bajarVelocidad();
		} catch (MandoApagadoException e) {
			System.out.println(e);
		}
	}

}
