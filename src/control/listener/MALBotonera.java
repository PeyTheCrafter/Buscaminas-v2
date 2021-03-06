package control.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import control.ParaUI;
import modelo.Tablero;

public class MALBotonera implements MouseListener {
	ParaUI control;
	Tablero tablero;

	public MALBotonera(ParaUI control, Tablero tablero) {
		super();
		this.control = control;
		this.tablero = tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton boton = (JButton) e.getSource();
		int[] coordenadas = interpretarCoordenadas(boton.getName());
		if (this.control.getBotonera().botonera[coordenadas[0]][coordenadas[1]].isEnabled()) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				accionesLMouse(e, coordenadas[0], coordenadas[1]);
			} else if (SwingUtilities.isRightMouseButton(e)) {
				accionesRMouse(e, coordenadas[0], coordenadas[1]);
			}
		}
		this.control.comprobarJuego();
	}

	/**
	 * Acciones para el bot�n izquierdo del rat�n.
	 * @param e evento.
	 * @param x coordenada x.
	 * @param y coordenada y.
	 */
	private void accionesLMouse(MouseEvent e, int x, int y) {
		if (this.tablero.casillas[x][y].isMina()) {
			this.control.perder();
		} else {
			if (this.tablero.casillas[x][y].isVelada()) {
				this.tablero.recorrer(x, y);
			} else {
				int marcadas = this.tablero.calcularBanderasAlrededor(x, y);
				if (marcadas == this.tablero.casillas[x][y].getNumeroMinas()
						&& this.tablero.casillas[x][y].getNumeroMinas() != 0) {
					this.tablero.desvelarCasillasAlrededor(x, y);
				}
			}
			this.control.actualizarVentana();
		}
	}

	/**
	 * Acciones para el bot�n derecho del rat�n.
	 * @param e evento.
	 * @param x coordenada x.
	 * @param y coordenada y.
	 */
	private void accionesRMouse(MouseEvent e, int x, int y) {
		if (this.tablero.casillas[x][y].isMarcada()) {
			this.tablero.desmarcarCasilla(x, y);
		} else {
			this.tablero.marcarCasilla(x, y);
		}
		this.control.actualizarVentana();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Interpreta las coordenadas numericas a partir de un string.
	 * @param cadena la cadena con las coordenadas en bruto.
	 * @return int[] con las coordendas procesadas.
	 */
	private int[] interpretarCoordenadas(String cadena) {
		String coord[] = cadena.split("-");
		int coordenadas[] = new int[2];
		for (int i = 0; i < coordenadas.length; i++) {
			coordenadas[i] = Integer.valueOf(coord[i]);
		}
		return coordenadas;
	}
}
