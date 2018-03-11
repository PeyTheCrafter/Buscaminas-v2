package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import control.Dificultad;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class UI_bug extends JFrame {

	private final float SCALE = 0.75f;

	protected JPanel contentPane;
	protected PanelBG panelBg;
	protected JPanel panelBotonera;
	protected JPanel panelSeleccion;
	protected JPanel panel;
	protected JLabel lblDificultad;
	protected JComboBox cbSelectorDificultad;
	protected JLabel lblMinas;
	protected JTextField txtNumeroMinas;
	protected JButton btnCrearJuego;
	protected Botonera botonera;
	private JLabel lblMeteSoloNmeros;
	protected JLabel lblEstadoJuego;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	protected JMenuItem mntmNuevoJuego;

	public UI_bug() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				actualizarTamano();
			}
		});
		setMinimumSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		mntmNuevoJuego = new JMenuItem("Nuevo juego");
		mnJuego.add(mntmNuevoJuego);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelBg = new PanelBG("assets/bg.png");
		panelBg.setBorder(null);
		contentPane.add(panelBg, BorderLayout.CENTER);
		panelBg.setLayout(new CardLayout(0, 0));

		panelBotonera = new Botonera();
		panelBotonera.setMaximumSize(new Dimension(200, 200));
		panelBotonera.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		panelBotonera.setOpaque(false);
		panelBg.add(panelBotonera, "panelBotonera");
		GridBagLayout gbl_panelBotonera = new GridBagLayout();
		gbl_panelBotonera.columnWidths = new int[] { 0, 300, 0, 0 };
		gbl_panelBotonera.rowHeights = new int[] { 0, 150, 0, 0 };
		gbl_panelBotonera.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelBotonera.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelBotonera.setLayout(gbl_panelBotonera);
		
		lblEstadoJuego = new JLabel("");
		lblEstadoJuego.setForeground(Color.WHITE);
		lblEstadoJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblEstadoJuego = new GridBagConstraints();
		gbc_lblEstadoJuego.anchor = GridBagConstraints.SOUTH;
		gbc_lblEstadoJuego.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoJuego.gridx = 1;
		gbc_lblEstadoJuego.gridy = 0;
		panelBotonera.add(lblEstadoJuego, gbc_lblEstadoJuego);

		botonera = new Botonera();
		GridBagConstraints gbc_botonera = new GridBagConstraints();
		gbc_botonera.insets = new Insets(0, 0, 5, 5);
		gbc_botonera.gridx = 1;
		gbc_botonera.gridy = 1;
		panelBotonera.add(botonera, gbc_botonera);

		panelSeleccion = new JPanel();
		panelSeleccion.setOpaque(false);
		panelSeleccion.setMaximumSize(new Dimension(200, 220));
		panelSeleccion.setPreferredSize(new Dimension(200, 200));
		panelSeleccion.setBorder(null);
		panelBg.add(panelSeleccion, "panelSeleccion");
		GridBagLayout gbl_panelSeleccion = new GridBagLayout();
		gbl_panelSeleccion.columnWidths = new int[] { 0, 35, 0, 0 };
		gbl_panelSeleccion.rowHeights = new int[] { 0, 10, 0, 0 };
		gbl_panelSeleccion.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelSeleccion.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelSeleccion.setLayout(gbl_panelSeleccion);

		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(300, 200));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		panelSeleccion.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 35, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 1;
		panel.add(lblDificultad, gbc_lblDificultad);

		cbSelectorDificultad = new JComboBox();
		cbSelectorDificultad.setBackground(new Color(0, 128, 128));
		cbSelectorDificultad.setModel(new DefaultComboBoxModel(Dificultad.values()));
		cbSelectorDificultad.setForeground(new Color(255, 255, 255));
		cbSelectorDificultad.setBorder(null);
		cbSelectorDificultad.setOpaque(false);
		cbSelectorDificultad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_cbSelectorDificultad = new GridBagConstraints();
		gbc_cbSelectorDificultad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelectorDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelectorDificultad.gridx = 2;
		gbc_cbSelectorDificultad.gridy = 1;
		panel.add(cbSelectorDificultad, gbc_cbSelectorDificultad);

		lblMinas = new JLabel("Minas:");
		lblMinas.setForeground(new Color(255, 255, 255));
		lblMinas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMinas = new GridBagConstraints();
		gbc_lblMinas.anchor = GridBagConstraints.EAST;
		gbc_lblMinas.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinas.gridx = 1;
		gbc_lblMinas.gridy = 2;
		panel.add(lblMinas, gbc_lblMinas);

		setTxtNumeroMinas(new JTextField());
		txtNumeroMinas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNumeroMinas.setForeground(new Color(255, 255, 255));
		txtNumeroMinas.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
		txtNumeroMinas.setOpaque(false);
		GridBagConstraints gbc_txtNumeroMinas = new GridBagConstraints();
		gbc_txtNumeroMinas.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumeroMinas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumeroMinas.gridx = 2;
		gbc_txtNumeroMinas.gridy = 2;
		panel.add(txtNumeroMinas, gbc_txtNumeroMinas);
		txtNumeroMinas.setColumns(10);
		
		lblMeteSoloNmeros = new JLabel("Mete solo n\u00FAmeros o te borro system32");
		lblMeteSoloNmeros.setForeground(Color.WHITE);
		lblMeteSoloNmeros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMeteSoloNmeros = new GridBagConstraints();
		gbc_lblMeteSoloNmeros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMeteSoloNmeros.gridx = 2;
		gbc_lblMeteSoloNmeros.gridy = 3;
		panel.add(lblMeteSoloNmeros, gbc_lblMeteSoloNmeros);

		btnCrearJuego = new JButton("Crear juego");
		btnCrearJuego.setForeground(Color.WHITE);
		btnCrearJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearJuego.setContentAreaFilled(false);
		btnCrearJuego.setBorderPainted(false);
		btnCrearJuego.setOpaque(false);
		GridBagConstraints gbc_btnCrearJuego = new GridBagConstraints();
		gbc_btnCrearJuego.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrearJuego.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearJuego.gridx = 2;
		gbc_btnCrearJuego.gridy = 5;
		panel.add(btnCrearJuego, gbc_btnCrearJuego);

		getCurrentPanel("panelSeleccion");
	}

	private void actualizarTamano() {
		int h = contentPane.getHeight();
		int w = contentPane.getWidth();
		int nh = (int) (h * SCALE);
		int nw = (int) (w * SCALE);
		if (h > w) {
			botonera.setPreferredSize(new Dimension(nw, nw));
		} else {
			botonera.setPreferredSize(new Dimension(nh, nh));
		}
	}

	public void getCurrentPanel(String name) {
		((CardLayout) panelBg.getLayout()).show(panelBg, name);
	}

	public void setTxtNumeroMinas(JTextField txtNumeroMinas) {
		this.txtNumeroMinas = txtNumeroMinas;
	}

	public JTextField getTxtNumeroMinas() {
		return this.txtNumeroMinas;
	}

	public int getDificultad() {
		Dificultad dificultad = (Dificultad) cbSelectorDificultad.getSelectedItem();
		return dificultad.getValor();
	}
	
	public Botonera getBotonera() {
		return botonera;
	}
}
