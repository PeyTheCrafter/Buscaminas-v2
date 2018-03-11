package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import control.ParaUI;
import modelo.Casilla;
import modelo.Tablero;
import vista.Botonera;

public class MALBotonera implements ActionListener {
	ParaUI control;
	Tablero tablero;

	public MALBotonera(ParaUI control, Tablero tablero) {
		super();
		this.control = control;
		this.tablero = tablero;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		System.out.println(boton.getName());
		int[] coordenadas = interpretarCoordenadas(boton.getName());
		this.tablero.recorrer(coordenadas[0], coordenadas[1]);
		control.actualizarVentana();
		mostrarTableroConsola(this.tablero);
	}

	private void mostrarTableroConsola(Tablero tablero) {
		for (int i = 0; i < tablero.casillas.length; i++) {
			for (int j = 0; j < tablero.casillas.length; j++) {
				System.out.print(this.tablero.casillas[i][j].getNumeroMinas());
			}
			System.out.println();
		}
		System.out.println();
	}

	private int[] interpretarCoordenadas(String cadena) {
		String coord[] = cadena.split("-");
		int coordenadas[] = new int[2];
		for (int i = 0; i < coordenadas.length; i++) {
			coordenadas[i] = Integer.valueOf(coord[i]);
		}
		return coordenadas;
	}
}
