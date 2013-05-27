import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;


public class Numerico {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Integer valorInicial;
	private Integer iteraciones;

	

	/**
	 * Create the application.
	 */
	public Numerico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 45, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				valorInicial = Integer.parseInt(textField_1.getText());
				iteraciones = Integer.parseInt(textField_2.getText());
				raphson.setFunction(textField.getText());
				double raiz=raphson.Newton(valorInicial,0.00001,iteraciones);
		        System.out.println("\nRaiz encontrada: "+raiz+"\n");
			}
		});
		btnCalcular.setBounds(293, 42, 117, 25);
		frame.getContentPane().add(btnCalcular);
		
		JLabel lblFuncin = new JLabel("Función");
		lblFuncin.setBounds(12, 47, 70, 15);
		frame.getContentPane().add(lblFuncin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 90, 30, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 136, 30, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor inicial");
		lblNewLabel.setBounds(12, 92, 142, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIteraciones = new JLabel("Iteraciones");
		lblIteraciones.setBounds(12, 138, 142, 15);
		frame.getContentPane().add(lblIteraciones);
	}
}
