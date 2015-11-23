package br.edu.facisa.caixa.gui;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Emprestimo {

	private JPanel panel;
	public JTextField textValorEmprestimo;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Create the application.
	 */
	public Emprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setSize(535,  320);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(225, 176, 46, 14);
		panel.add(lblNewLabel_1);
		
		textValorEmprestimo = new JTextField();
		textValorEmprestimo.setEditable(false);
		textValorEmprestimo.setColumns(10);
		textValorEmprestimo.setBounds(179, 192, 147, 33);
		panel.add(textValorEmprestimo);
		
	}
}
