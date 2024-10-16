package ventana_binario_hexadecimal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JInternalFrame{

	private static final long serialVersionUID = -7072301963712682878L;
	private JInternalFrame frame;
	private JTextField numero_binario_hexa;
	private JTextField resultadoCalculo;
	JLabel multi_label= new JLabel();



	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(0, 0, 585, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblPresioneEsteBoton = new JLabel("Presione este boton para calcular hexadecimal");
		panel.add(lblPresioneEsteBoton);
		
		JLabel lblPresioneElBoton = new JLabel("presione el boton para calcular binario");
		panel.add(lblPresioneElBoton);
		
		JButton boton_hexa = new JButton("Hexadecimal");
		boton_hexa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multi_label.setText("introduzca el numero a convertir en hexadecimal:");
			}
		});
		
			
		panel.add(boton_hexa);
		
		JButton boton_binario = new JButton("binario");
		boton_binario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//por alguna razon si  no seteo  primero el texto a vacio  no cambio el contenido del label
				multi_label.setText("");
				multi_label.setText("introduzca el numero a convertir en binario:");
				
			}
		});
		panel.add(boton_binario);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		
		multi_label.setBounds(38, 21, 282, 20);
		multi_label.setText("introduzca el numero a convertir en binario:");
		panel_1.add(multi_label);
		
		numero_binario_hexa = new JTextField();
		numero_binario_hexa.setBounds(347, 21, 153, 20);
		panel_1.add(numero_binario_hexa);
		numero_binario_hexa.setColumns(10);
		
		JButton boton_calculo = new JButton("calcular ");
		boton_calculo.setBounds(242, 77, 89, 23);
		panel_1.add(boton_calculo);
		
		JLabel Resultado = new JLabel("Resultado:");
		Resultado.setBounds(62, 137, 129, 34);
		panel_1.add(Resultado);
		
		resultadoCalculo = new JTextField();
		resultadoCalculo.setEditable(false);
		resultadoCalculo.setBounds(142, 137, 309, 34);
		panel_1.add(resultadoCalculo);
		resultadoCalculo.setColumns(10);
		
	}
}
