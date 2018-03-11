package modelo;

public class Tablero {
	public Casilla casillas[][];
	private int minas;

	public Tablero(int lado, int minas) {
		super();
		this.minas = minas;
		this.casillas = new Casilla[lado][lado];
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				this.casillas[i][j] = new Casilla(i, j);
			}
		}
	}

	public void sortearMinas() {
		int contador = 0;
		do {
			int x = (int) (Math.random() * this.casillas.length);
			int y = (int) (Math.random() * this.casillas.length);
			if (!this.casillas[x][y].isMina()) {
				colocarMina(x, y);
				contador++;
			}
		} while (contador < this.minas);
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
	public boolean comprobarRango(int x, int y) {
		return x >= 0 && x < this.casillas.length && y >= 0 && y < this.casillas[x].length;
	}

	public Casilla[][] getTablero() {
		return casillas;
	}

	public void setTablero(Casilla[][] tablero) {
		this.casillas = tablero;
	}

	public int getMinas() {
		return minas;
	}

	public void setMinas(int minas) {
		this.minas = minas;
	}

	/*
	 * Coloca una mina en la posición.
	 */
	public void colocarMina(int x, int y) {
		this.casillas[x][y].setMina(true);
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
		casillas[x][y].setMarcada(true);
	}

	public void desmarcarCasilla(int x, int y) {
		this.casillas[x][y].setMarcada(false);
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
		casillas[x][y].setVelada(false);
	}

	/**
	 * Calcula el número de casillas marcadas alrededor de una casilla.
	 * 
	 * @param x
	 *            coordenada x.
	 * @param y
	 *            coordenada y.
	 * @return el número de casillas mardadas.
	 */
	public int calcularBanderasAlrededor(int x, int y) {
		int contador = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (comprobarRango(i, j) && this.casillas[i][j].isMarcada()) {
					contador++;
				}
			}
		}
		return contador;
	}

	public void desvelarCasillasAlrededor(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (comprobarRango(i, j) && this.casillas[i][j].isVelada() && !this.casillas[i][j].isMarcada()) {
					desvelarCasilla(i, j);
				}
			}
		}
	}

	/**
	 * Recorre el tablero y comprueba si la casilla actual es una mina. Si lo es,
	 * incrementa en 1 el número de minas de las casillas de alrededor.
	 */
	public void calcularMinasAlrededor() {
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas.length; j++) {
				if (this.casillas[i][j].isMina()) {
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
	public void incrementarMinas(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (comprobarRango(i, j) && !this.casillas[i][j].isMina()) {
					this.casillas[i][j].numeroMinas++;
				}
			}
		}
	}

	/**
	 * Recorre de forma recursiva el tablero, comprobando los alrededores de
	 * aquellas casillas vacías.
	 * 
	 * @param x
	 *            coordenada x de origen.
	 * @param y
	 *            coordenada y de origen.
	 */
	public void recorrer(int x, int y) {
		desvelarCasilla(x, y);
		if (this.casillas[x][y].getNumeroMinas() == 0) {
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (comprobarRango(i, j) && !this.casillas[i][j].isMina() && !this.casillas[i][j].isMarcada()) {
						if (this.casillas[i][j].getNumeroMinas() == 0 && this.casillas[i][j].isVelada()) {
							recorrer(i, j);
						} else {
							desvelarCasilla(i, j);
						}
					}
				}
			}
		}
	}
}
