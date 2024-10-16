package main_menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main_IMC.Ventana_IMC;
import main_tabla.Ventana;
import ventana_binario_hexadecimal.VentanaPrincipal;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDesktopPane desktopPane = new JDesktopPane();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 650, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("aplicaciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Conversor hex-bin");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ven = new VentanaPrincipal();
				if(ven.getSize()!=desktopPane.getSize()) {
					desktopPane.setSize(ven.getSize());
					//no hacefalta decrara el prame por que esta clase hereda de ella
					setSize(ven.getSize());
				}
				//ESTE METODO ES IMPORTANTE POR QUE ES EL QUE NOS DEJA HACER LA VENTANA MAS GRANDE
				ven.setMaximizable(true);
				desktopPane.add(ven);
				ven.setVisible(true);
				//esto funciona pero no logro limpiar el frame una vez ejecutado
				setSize(Math.max(getWidth(), getX() + getWidth() + 50),
	                      Math.max(getHeight(), getY() + getHeight() + 50));
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Calculadora IMC");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ventana_IMC ven = new Ventana_IMC();
				if(ven.getSize()!=desktopPane.getSize()) {
					setSize(ven.getSize());
				}
				desktopPane.add(ven);
				ven.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tabla estudiantes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana ven = new Ventana();
				if(desktopPane.getAllFrames().length>0) {
					//algo tiene que ir dentro del if para que funcione
				if(ven.getSize()!=desktopPane.getSize()) {
					setSize(ven.getSize());
				}}
				desktopPane.add(ven);
				ven.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
