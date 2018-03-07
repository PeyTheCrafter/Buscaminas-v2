package modelo;

public class Tablero {
	private Casilla tablero[][];
	private int ancho;
	private int alto;
	private int minas;

	public Tablero(int ancho, int alto, int minas) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.minas = minas;
	}

	/**
	 * Coloca una mina en la posición seleccionada.
	 * 
	 * @param x
	 *            posición x.
	 * @param y
	 *            posición y.
	 */
	public void colocarMina(int x, int y) {
		this.tablero[x][y].setMina(true);
	}

	/**
	 * Marca la casilla seleccionada.
	 * 
	 * @param x
	 *            posición x.
	 * @param y
	 *            posición y.
	 */
	public void marcarCasilla(int x, int y) {
		this.tablero[x][y].setMarcada(true);
	}

	/**
	 * Desvela la casilla seleccionada.
	 * 
	 * @param x
	 *            posición x.
	 * @param y
	 *            posición y.
	 */
	public void desvelarCasilla(int x, int y) {
		this.tablero[x][y].setVelada(false);
	}

	/**
	 * Recorre el tablero y comprueba si la casilla actual es una mina. Si lo es,
	 * incrementa en 1 el número de minas de las casillas de alrededor.
	 */
	public void calcularMinasAlrededor() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (this.tablero[i][j].isMina()) {
					incrementarMinas(i, j);
				}
			}
		}
	}

	/**
	 * Incrementa el número de minas en las casillas adyacentes.<br>
	 * 
	 * @param x
	 *            posición x.
	 * @param y
	 *            posición y.
	 */
	private void incrementarMinas(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				if (comprobarRango(i, j) && x != 0 && y != 0) {
					this.tablero[i][j].numeroMinas++;
				}
			}
		}
	}

	/**
	 * Comprueba si la casilla actual está dentro del rango del tablero.
	 * 
	 * @param x
	 *            posición x.
	 * @param y
	 *            posición y.
	 * @return true si la casilla está dentro del tablero. False si no.
	 */
	private boolean comprobarRango(int x, int y) {
		return x >= 0 && x < this.tablero.length && y >= 0 && y < this.tablero[x].length;
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getMinas() {
		return minas;
	}

	public void setMinas(int minas) {
		this.minas = minas;
	}

}
