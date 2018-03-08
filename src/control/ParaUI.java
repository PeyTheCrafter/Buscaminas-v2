package control;

import java.awt.Dimension;
import java.awt.Window;

import control.listener.MALCrearJuego;
import modelo.Tablero;
import vista.UI;
import vista.UI_bug;

public class ParaUI extends UI_bug {
	Tablero tablero;
	MALCrearJuego listenerCrearJuego = new MALCrearJuego(this);

	public ParaUI() {
		btnCrearJuego.addActionListener(listenerCrearJuego);
	}

	public void crearJuego() {
		this.tablero = new Tablero(10, 10, 10);
		botonera.crearBotonera(this.tablero.getAncho(), this.tablero.getAlto());
		botonera.añadirBotones();
		getCurrentPanel("panelBotonera");
		ajustarTamano();
	}

	private void ajustarTamano() {
		System.out.println("Tamaño botonera: " + panelBotonera.getWidth() + " x " + panelBotonera.getHeight());
		botonera.setMaximumSize(new Dimension(25 * this.tablero.getAlto(), 25 * this.tablero.getAncho()));
	}
}
