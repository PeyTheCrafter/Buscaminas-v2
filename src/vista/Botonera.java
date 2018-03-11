package vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Botonera extends JPanel {
	public JButton[][] botonera;

	/**
	 * Create the panel.
	 */
	public Botonera() {
		setOpaque(false);
		setLayout(new GridLayout(1, 0, 0, 0));
		setPreferredSize(new Dimension(350, 350));
	}

	public void añadirBotones() {
		for (int i = 0; i < this.botonera.length; i++) {
			for (int j = 0; j < this.botonera.length; j++) {
				JButton boton = new JButton();
				this.botonera[i][j] = boton;
				boton.setName(i + "-" + j);
				this.add(boton);
			}
		}
	}

	public void crearBotonera(int ancho, int alto) {
		this.botonera = new JButton[ancho][alto];
		this.setLayout(new GridLayout(ancho, alto, 0, 0));
	}

	public void desactivarBotonera() {
		for (int i = 0; i < this.botonera.length; i++) {
			for (int j = 0; j < this.botonera[i].length; j++) {
				this.botonera[i][j].setEnabled(false);
			}
		}
	}

	public void mostrarMina(int x, int y) {
		this.botonera[x][y].setBorder(new LineBorder(Color.RED, 2));
		this.botonera[x][y].setBackground(new Color(255, 64, 64));
	}
}
