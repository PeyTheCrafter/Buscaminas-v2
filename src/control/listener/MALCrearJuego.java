package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.SwingUtilities;

import control.ParaUI;
import utiles.UtilesTablero;

public class MALCrearJuego implements ActionListener {
	ParaUI control;
	UtilesTablero utiles = new UtilesTablero();

	public MALCrearJuego(ParaUI control) {
		super();
		this.control = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int numeroMinas = Integer.valueOf(this.control.getTxtNumeroMinas().getText());
		int casillas = this.utiles.calcularCasillas(numeroMinas, this.control.getDificultad());
		int lado = this.utiles.calcularLado(casillas);
		this.control.crearJuego(lado, numeroMinas);
	}
}
