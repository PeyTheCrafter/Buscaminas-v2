package utiles;

import modelo.Tablero;

public class UtilesTablero {
	public UtilesTablero() {
		super();
	}

	/*
	 * Calcula el lado a partir del n�mero de casillas.
	 */
	public int calcularLado(int casillas) {
		return (int) Math.floor(Math.sqrt(casillas));
	}

	/*
	 * Calcula el n�mero de casillas total en funci�n de las minas y de la
	 * dificultad.
	 */
	public int calcularCasillas(int numeroMinas, int relacion) {
		int casillas = relacion * numeroMinas;
		return casillas;
	}
}
