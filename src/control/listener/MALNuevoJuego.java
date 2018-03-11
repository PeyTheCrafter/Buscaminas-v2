package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import control.Principal;

public class MALNuevoJuego implements ActionListener {
	ParaUI control;

	public MALNuevoJuego(ParaUI control) {
		this.control = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.control.borrarJuego();
		this.control.getCurrentPanel("panelSeleccion");
	}

}
