package control;

import control.listener.MALCrearJuego;
import modelo.Tablero;
import utiles.UtilesTablero;
import vista.UI_bug;

public class ParaUI extends UI_bug {
	Tablero tablero;
	UtilesTablero utiles;
	MALCrearJuego listenerCrearJuego = new MALCrearJuego(this);

	public ParaUI() {
		btnCrearJuego.addActionListener(listenerCrearJuego);
		this.utiles = new UtilesTablero();
	}

	public void crearJuego() {
		int numeroMinas = Integer.valueOf(txtNumeroMinas.getText());
		int casillas = this.utiles.calcularCasillas(numeroMinas, getDificultad());
		int lado = this.utiles.calcularLado(casillas);
		this.tablero = new Tablero(30, 30, 10);
		botonera.crearBotonera(this.tablero.getAncho(), this.tablero.getAlto());
		botonera.añadirBotones();
		getCurrentPanel("panelBotonera");
	}
}