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
	}

	public void añadirBotones() {
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {
				this.botonera[i][j] = new JButton();
			}
		}
	}

	public void crearBotonera(int ancho, int alto) {
		this.botonera = new JButton[ancho][alto];
		setLayout(new GridLayout(ancho, alto, 0, 0));
	}
}
