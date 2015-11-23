package br.edu.facisa.caixa.gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deposito {

	private JPanel panel;
	public JTextField textField;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Create the application.
	 */
	public Deposito() {
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
		
		JLabel lblNewLabel = new JLabel("Digite o valor para dep\u00F3sito");
		lblNewLabel.setBounds(181, 136, 178, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(193, 173, 147, 33);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
	}
}
