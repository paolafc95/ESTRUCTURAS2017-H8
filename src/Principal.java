import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
*Byron Mota, 15246
 *Paola Fuentes, 151126
 * @version 1.0
 * GUI para dar la interfaz al usuario
 * 
 */
public class Principal {
	
	/* Atributos */
	static String tipo = "", tipo2 = "", tipo3 = "";
	private static Diccionario dic = new Diccionario();
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	private JButton btnEnviar;
	private JFrame frame;
	private JTextField txtNombrea;
	private JTextField textField;
	private JTextPane textPane;
	private JScrollPane scrollPane;

	/**
	 * Metodo simple para verificar si no se ingreso una opcion de
	 * implementacion adecuada.
	 * 
	 * @param s
	 *            contiene el texto ingresado por el usuario
	 */
	static void defensiva(String s) {
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			System.exit(0);
		} else if (!(s.equalsIgnoreCase("HS") || s.equalsIgnoreCase("SP"))) {
			JOptionPane.showMessageDialog(null,
					"No ha ingresado una opcion valida");
			System.exit(0);
		}
	}


	/**
	 * Metodo main para correr el programa
	 * @param args .
	 */
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"Por favor ingrese la implementacion de mapeo que desee utilizar\n"
						+ "Para SplayTree ingrese ''SP''\n"
						+ "Para HashMap ingrese ''HS''\n", "Datos necesarios",
				JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el tipo: ");
		defensiva(tipo);
		dic.listo(tipo);
		Principal window = new Principal();
		window.frame.setVisible(true);

	}

	/**
	 * Crear la aplicacion
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializar componentes graficos
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 537, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNombre = new JLabel("Ingrese el directorio del diccionario:");

		btnEnviar = new JButton("Enviar");

		txtNombrea = new JTextField();
		txtNombrea.setColumns(10);
		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		btnEnviar.addActionListener(new ManejadorEventos());

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblIngreseElDirectorio = new JLabel(
				"Ingrese el directorio de oracion/palabra:");

		textPane = new JTextPane();
		textPane.setEditable(false);

		scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(196))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(552, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblIngreseElDirectorio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(239, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(268, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNombre)
					.addGap(14)
					.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIngreseElDirectorio)
					.addGap(7)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(68))
		);
		frame.getContentPane().setLayout(groupLayout);

		// Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
	}
	// Inner class para manejar eventos
		private class ManejadorEventos implements ActionListener {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
			 * )
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// Para enviar datos, y asignar ambientes
				if (e.getSource() == btnEnviar) {

					dic.crear(txtNombrea.getText());
					textPane.setText(dic.traducir(textField.getText()));

				}
			}
		}
}
