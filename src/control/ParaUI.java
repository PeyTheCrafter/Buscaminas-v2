package control;

import java.awt.Color;

import javax.swing.border.LineBorder;

import control.listener.MALBotonera;
import control.listener.MALCrearJuego;
import modelo.Casilla;
import modelo.Tablero;
import utiles.UtilesTablero;
import vista.UI_bug;

public class ParaUI extends UI_bug {
	Tablero tablero;
	UtilesTablero utiles;
	MALCrearJuego listenerCrearJuego = new MALCrearJuego(this);
	MALBotonera listenerBotonera;

	public ParaUI() {
		btnCrearJuego.addActionListener(listenerCrearJuego);
	}

	public void actualizarVentana() {
		for (int i = 0; i < this.tablero.casillas.length; i++) {
			for (int j = 0; j < this.tablero.casillas[i].length; j++) {
				if (!this.tablero.casillas[i][j].isVelada()) {
					this.botonera.botonera[i][j].setText(String.valueOf(this.tablero.casillas[i][j].getNumeroMinas()));
				}
				if (this.tablero.casillas[i][j].isMina()) {
					this.botonera.botonera[i][j].setBorder(new LineBorder(Color.RED));
				}
				if (this.tablero.casillas[i][j].getNumeroMinas() > 0 && !this.tablero.casillas[i][j].isVelada()) {
					this.botonera.botonera[i][j].setBorder(new LineBorder(Color.RED, 3));
				}
			}
		}
	}

	/*
	 * Crea el juego.
	 */
	public void crearJuego(int lado, int numeroMinas) {
		this.tablero = new Tablero(lado, numeroMinas);
		this.tablero.sortearMinas();
		this.tablero.calcularMinasAlrededor();
		this.listenerBotonera = new MALBotonera(this, tablero);
		crearBotonera(lado);
		aņadirListenerBotonera();
		getCurrentPanel("panelBotonera");
		actualizarVentana();
	}

	public void crearBotonera(int lado) {
		botonera.crearBotonera(lado, lado);
		botonera.aņadirBotones();
	}

	public void aņadirListenerBotonera() {
		for (int i = 0; i < this.botonera.botonera.length; i++) {
			for (int j = 0; j < this.botonera.botonera.length; j++) {
				this.botonera.botonera[i][j].addActionListener(listenerBotonera);
			}
		}
	}
}