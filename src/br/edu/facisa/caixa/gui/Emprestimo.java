package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Emprestimo {

	private JPanel panel;
	private JTextField textDataEmprestimo;
	private JTextField textContaEmprestimo;
	private JTextField textValorEmprestimo;
	
	public JPanel getPanelDeposito() {
		return panel;
	}

	public void setPanelDeposito(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField() {
		return textDataEmprestimo;
	}

	public void setTextField(JTextField textField) {
		this.textDataEmprestimo = textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprestimo window = new Emprestimo();
					window.panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		textDataEmprestimo = new JTextField();
		textDataEmprestimo.setBounds(98, 158, 147, 33);
		textDataEmprestimo.setEditable(false);
		panel.add(textDataEmprestimo);
		textDataEmprestimo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(98, 144, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setBounds(278, 144, 46, 14);
		panel.add(lblConta);
		
		textContaEmprestimo = new JTextField();
		textContaEmprestimo.setEditable(false);
		textContaEmprestimo.setColumns(10);
		textContaEmprestimo.setBounds(278, 158, 147, 33);
		panel.add(textContaEmprestimo);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(240, 207, 46, 14);
		panel.add(lblNewLabel_1);
		
		textValorEmprestimo = new JTextField();
		textValorEmprestimo.setEditable(false);
		textValorEmprestimo.setColumns(10);
		textValorEmprestimo.setBounds(194, 223, 147, 33);
		panel.add(textValorEmprestimo);
		
	}
}
