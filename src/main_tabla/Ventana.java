package main_tabla;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo_tabla.Estudiante;
import modelo_tabla.Materias;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Ventana extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3912342185977751758L;

	private JTable table;
	ArrayList<Estudiante>estudiantes = new ArrayList<Estudiante>();

	

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(0, 0, 650, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setName("Ventana Lista-Tabla");
		
		
		
		
		
		
		
		
		
//panel de botones con botones		
		JPanel panel_botones = new JPanel();
		getContentPane().add(panel_botones, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		panel_botones.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_botones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_botones.add(btnNewButton_2);
		String[] columnas= {"Id","Nombre","Apellido","Nota","materia"};
		
		//lista de objetos dentro de la tabla
		 Object[][]datos= {
				 //en este estatico tendria que cargar los mismos datos!
				{"1","Pedro","ertb","ds",Materias.Biologia.getNombrecurso()},
				{"2","antonio","erh","sdv",Materias.Fisica.getNombrecurso()},
				{"3","juan","wrgt","dfvf",Materias.Biologia.getNombrecurso()},
				{"4","perco","rtgw","scds",Materias.Fisica.getNombrecurso()},
				{"5","contran","retbet","sdfds",Materias.LenguaEspañola.getNombrecurso()},
				{"6","cdv","erthe","efv",Materias.Fisica.getNombrecurso()},
				{"7","dte","erthe","adf",Materias.LenguaEspañola.getNombrecurso()},
				{"8","Pedrertheto","","erthet",Materias.Fisica.getNombrecurso()},
		};
		 estudiantes.add(new Estudiante("1","juan","ertb","6.0",Materias.Biologia));
		 estudiantes.add(new Estudiante("1","daniel","ertb","7.8",Materias.Biologia));
		 estudiantes.add(new Estudiante("1","Pedro","ertb","8.4",Materias.Fisica));
		 estudiantes.add(new Estudiante("1","alex","ertb","5.6",Materias.Fisica));
		 estudiantes.add(new Estudiante("1","Pedro","ertb","7.6",Materias.LenguaEspañola));
		 estudiantes.add(new Estudiante("1","ivan","ertb","5.9",Materias.LenguaEspañola));
		 estudiantes.add(new Estudiante("1","fernado","ertb","8.0",Materias.Matematica));
		 estudiantes.add(new Estudiante("1","gennaro","ertb","9.0",Materias.Matematica));
		 
		 
		 DefaultTableModel modelo = new DefaultTableModel(datos,columnas);
		 JPanel panel_tabla = new JPanel();
		getContentPane().add(panel_tabla, BorderLayout.CENTER);
		table = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(table);	
		panel_tabla.add(table);
		table.add(scroll);		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		String[]clases= {
				Materias.Biologia.getNombrecurso(),
				Materias.Fisica.getNombrecurso(),
				Materias.LenguaEspañola.getNombrecurso(),
				Materias.Matematica.getNombrecurso(),
		};
		JList<String>list = new JList<>(clases);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String dato =list.getSelectedValue();
				//metodo creado ppara cambiar lo que se muestre si se da click a una materia
				cambiarComtenido(dato);
			}
		});
		panel.add(list);
		
		
		
		
	}
        private void cambiarComtenido(String materia) {
        	//este default table model es el que permite usar addrow()
        	DefaultTableModel modificar_row = (DefaultTableModel) table.getModel();
        	modificar_row.setRowCount(0);
        	for(Estudiante es:estudiantes) {
        		if(es.getMateria().getNombrecurso() == materia) {
        			modificar_row.addRow(new Object[] {
        					//como es un  objeto generico necesitamos pasar por los parametros de forma explicita y deja de ser objeto estudiante y pasa a ser Object
        					es.getId(),
        					es.getNombre(),
        					es.getApellidos(),
        					es.getNota(),
        					es.getMateria().getNombrecurso()
        			});
        		}
        	}
		}
}
