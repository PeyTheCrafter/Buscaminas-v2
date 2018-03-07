package vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Botonera extends JPanel {
	public JButton[][] botonera;

	/**
	 * Create the panel.
	 */
	public Botonera() {
		setOpaque(false);
		setLayout(new GridLayout(1, 0, 0, 0));
	}

	public void añadirBotones() {
		for (int i = 0; i < this.botonera.length; i++) {
			for (int j = 0; j < this.botonera.length; j++) {
				JButton boton = new JButton();
				this.botonera[i][j] = boton;
				this.add(boton);
			}
		}
	}

	public void crearBotonera(int ancho, int alto) {
		this.botonera = new JButton[ancho][alto];
		this.setLayout(new GridLayout(ancho, alto, 0, 0));
	}
}
