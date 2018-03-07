package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import modelo.Dificultad;

public class UI_bug extends JFrame {

	protected JPanel contentPane;
	protected PanelBG panelBg;
	protected Botonera panelBotonera;
	protected JPanel panelSeleccion;
	private JPanel panel;
	private JLabel lblDificultad;
	private JComboBox comboBox;
	private JLabel lblMinas;
	private JTextField textField;
	private JButton btnCrearJuego;

	public UI_bug() {
		setMinimumSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelBg = new PanelBG("assets/bg.png");
		panelBg.setBorder(new EmptyBorder(25, 50, 25, 50));
		contentPane.add(panelBg, BorderLayout.CENTER);
		panelBg.setLayout(new CardLayout(0, 0));

		panelBotonera = new Botonera();
		FlowLayout flowLayout = (FlowLayout) panelBotonera.getLayout();
		panelBotonera.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		panelBotonera.setOpaque(false);
		panelBg.add(panelBotonera, "panelBotonera");

		panelSeleccion = new JPanel();
		panelSeleccion.setOpaque(false);
		panelSeleccion.setMaximumSize(new Dimension(200, 220));
		panelSeleccion.setPreferredSize(new Dimension(200, 200));
		panelSeleccion.setBorder(null);
		panelBg.add(panelSeleccion, "panelSeleccion");
		GridBagLayout gbl_panelSeleccion = new GridBagLayout();
		gbl_panelSeleccion.columnWidths = new int[]{0, 35, 0, 0};
		gbl_panelSeleccion.rowHeights = new int[]{0, 10, 0, 0};
		gbl_panelSeleccion.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelSeleccion.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		gbl_panel.columnWidths = new int[]{0, 0, 35, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setModel(new DefaultComboBoxModel(Dificultad.values()));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBorder(null);
		comboBox.setOpaque(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		lblMinas = new JLabel("Minas:");
		lblMinas.setForeground(new Color(255, 255, 255));
		lblMinas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMinas = new GridBagConstraints();
		gbc_lblMinas.anchor = GridBagConstraints.EAST;
		gbc_lblMinas.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinas.gridx = 1;
		gbc_lblMinas.gridy = 2;
		panel.add(lblMinas, gbc_lblMinas);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
		textField.setOpaque(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
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
		gbc_btnCrearJuego.gridy = 4;
		panel.add(btnCrearJuego, gbc_btnCrearJuego);
		
		getCurrentPanel("panelSeleccion");
	}
	
	public void getCurrentPanel(String name) {
        ((CardLayout) panelBg.getLayout()).show(panelBg, name);
    }

}
