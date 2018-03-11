package utiles;

import modelo.Tablero;

public class UtilesTablero {
	public UtilesTablero() {
		super();
	}

	/**
	 * Calcula el lado a partir del n�mero de casillas introducido.
	 * 
	 * @param casillas
	 *            n�mero total de casillas del tablero.
	 * @return el lado del tablero.
	 */
	public int calcularLado(int casillas) {
		return (int) Math.floor(Math.sqrt(casillas));
	}

	/**
	 * Calcula el n�mero total de casillas en funci�n del n�mero de minas y de la
	 * dificultad.
	 * 
	 * @param numeroMinas
	 *            n�mero de minas.
	 * @param relacion
	 *            dificultad elegida.
	 * @return el n�mero total de casillas.
	 */
	public int calcularCasillas(int numeroMinas, int relacion) {
		int casillas = relacion * numeroMinas;
		return casillas;
	}
}
