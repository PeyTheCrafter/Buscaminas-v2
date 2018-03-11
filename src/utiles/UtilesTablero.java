package utiles;

import modelo.Tablero;

public class UtilesTablero {
	public UtilesTablero() {
		super();
	}

	/**
	 * Calcula el lado a partir del número de casillas introducido.
	 * 
	 * @param casillas
	 *            número total de casillas del tablero.
	 * @return el lado del tablero.
	 */
	public int calcularLado(int casillas) {
		return (int) Math.floor(Math.sqrt(casillas));
	}

	/**
	 * Calcula el número total de casillas en función del número de minas y de la
	 * dificultad.
	 * 
	 * @param numeroMinas
	 *            número de minas.
	 * @param relacion
	 *            dificultad elegida.
	 * @return el número total de casillas.
	 */
	public int calcularCasillas(int numeroMinas, int relacion) {
		int casillas = relacion * numeroMinas;
		return casillas;
	}
}
