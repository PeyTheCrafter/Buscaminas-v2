package control;

import java.awt.Color;

import javax.swing.border.LineBorder;

import control.listener.MALBotonera;
import control.listener.MALCrearJuego;
import control.listener.MALNuevoJuego;
import modelo.Casilla;
import modelo.Tablero;
import utiles.UtilesTablero;
import vista.UI_bug;

public class ParaUI extends UI_bug {
	Tablero tablero;
	UtilesTablero utiles;
	MALCrearJuego listenerCrearJuego = new MALCrearJuego(this);
	MALBotonera listenerBotonera;
	MALNuevoJuego listenerNuevoJuego = new MALNuevoJuego(this);

	public ParaUI() {
		this.btnCrearJuego.addActionListener(listenerCrearJuego);
		this.mntmNuevoJuego.addActionListener(listenerNuevoJuego);
	}

	/**
	 * Borra todos los elementos de la botonera.
	 */
	public void borrarJuego() {
		this.botonera.removeAll();
	}

	/**
	 * Desactiva los botones de la botonera, muestra la localizaci�n de las minas y
	 * muestra un mensaje.
	 */
	public void perder() {
		this.botonera.desactivarBotonera();
		for (int i = 0; i < this.botonera.botonera.length; i++) {
			for (int j = 0; j < this.botonera.botonera[i].length; j++) {
				if (this.tablero.casillas[i][j].isMina()) {
					this.botonera.mostrarMina(i, j);
				}
			}
		}
		this.lblEstadoJuego.setText("�Has perdido!");
	}

	/**
	 * Actualiza la ventana seg�n la informaci�n del tablero de juego.
	 */
	public void actualizarVentana() {
		for (int i = 0; i < this.tablero.casillas.length; i++) {
			for (int j = 0; j < this.tablero.casillas[i].length; j++) {
				if (!this.tablero.casillas[i][j].isMina() && !this.tablero.casillas[i][j].isVelada()) {
					this.botonera.botonera[i][j].setText(String.valueOf(this.tablero.casillas[i][j].getNumeroMinas()));
				}
				if (this.tablero.casillas[i][j].isMarcada()) {
					this.botonera.botonera[i][j].setBackground(new Color(0, 164, 164));
				} else {
					this.botonera.botonera[i][j].setBackground(null);
				}
			}
		}
		// actualizarVentanaDebug();
	}

	/**
	 * Actualiza la ventana seg�n informaci�n del tablero de juego oculta para el
	 * usuario.
	 */
	public void actualizarVentanaDebug() {
		for (int i = 0; i < this.tablero.casillas.length; i++) {
			for (int j = 0; j < this.tablero.casillas[i].length; j++) {
				if (this.tablero.casillas[i][j].isMina()) {
					this.botonera.botonera[i][j].setBorder(new LineBorder(Color.RED));
				}
				if (!this.tablero.casillas[i][j].isVelada()) {
					this.botonera.botonera[i][j].setBorder(new LineBorder(Color.BLUE));
				}
			}
		}
	}

	/**
	 * Crea el juego.
	 * 
	 * @param lado
	 *            lado del tablero de juego.
	 * @param numeroMinas
	 *            n�mero de minas para el juego actual.
	 */
	public void crearJuego(int lado, int numeroMinas) {
		this.tablero = new Tablero(lado, numeroMinas);
		this.tablero.sortearMinas();
		this.tablero.calcularMinasAlrededor();
		this.listenerBotonera = new MALBotonera(this, tablero);
		crearBotonera(lado);
		a�adirListenerBotonera();
		getCurrentPanel("panelBotonera");
		actualizarVentana();
	}

	/**
	 * Crea la botonera con las dimensiones especificadas.
	 * 
	 * @param lado
	 */
	public void crearBotonera(int lado) {
		botonera.crearBotonera(lado, lado);
		botonera.a�adirBotones();
	}

	/**
	 * A�ade los listener de los botones a la botonera.
	 */
	public void a�adirListenerBotonera() {
		for (int i = 0; i < this.botonera.botonera.length; i++) {
			for (int j = 0; j < this.botonera.botonera.length; j++) {
				this.botonera.botonera[i][j].addMouseListener(listenerBotonera);
			}
		}
	}

	/**
	 * Desactiva los botones de la botonera y muestra un mensaje.
	 */
	public void ganar() {
		this.botonera.desactivarBotonera();
		this.lblEstadoJuego.setText("�Has ganado!");
	}

	/**
	 * Comprueba si se ha ganado el juego. Si el n�mero de casillas desveladas
	 * coincide con el total de casillas del tablero menos el total de minas, se
	 * gana.
	 */
	public void comprobarJuego() {
		int casillasDesveladas = 0;
		for (int i = 0; i < this.tablero.casillas.length; i++) {
			for (int j = 0; j < this.tablero.casillas[i].length; j++) {
				if (!this.tablero.casillas[i][j].isVelada()) {
					casillasDesveladas++;
				}
			}
		}
		if (casillasDesveladas == Math.pow(this.tablero.casillas.length, 2) - this.tablero.getMinas()) {
			ganar();
		}
	}
}