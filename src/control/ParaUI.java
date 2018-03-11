package control;

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

	/*
	 * Crea el juego.
	 */
	public void crearJuego(int lado, int numeroMinas) {
		this.tablero = new Tablero(lado, numeroMinas);
		System.out.println(this.tablero.casillas[1][1].getNumeroMinas());
		this.listenerBotonera = new MALBotonera(this, tablero);
		crearBotonera(lado);
		añadirListenerBotonera();
		getCurrentPanel("panelBotonera");
	}

	public void crearBotonera(int lado) {
		botonera.crearBotonera(lado, lado);
		botonera.añadirBotones();
	}

	public void añadirListenerBotonera() {
		for (int i = 0; i < this.botonera.botonera.length; i++) {
			for (int j = 0; j < this.botonera.botonera.length; j++) {
				this.botonera.botonera[i][j].addActionListener(listenerBotonera);
			}
		}
	}

	public void realizarJuagada(int[] coordenadas) {

	}
}