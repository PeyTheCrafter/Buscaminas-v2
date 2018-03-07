package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.SwingUtilities;

import control.ParaUI;

public class MALCrearJuego implements ActionListener {
	ParaUI control;

	public MALCrearJuego(ParaUI control) {
		super();
		this.control = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.crearJuego();
	}
}
