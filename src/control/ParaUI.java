package control;

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
		System.out.println(this.tablero.getAncho() + " " + this.tablero.getAlto());
		botonera.crearBotonera(this.tablero.getAncho(), this.tablero.getAlto());
		botonera.a�adirBotones();
		getCurrentPanel("panelBotonera");
	}
}
