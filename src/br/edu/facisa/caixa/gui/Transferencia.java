package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Transferencia {

	private JPanel panel;
	private JTextField textDataTransferencia;
	private JTextField textContaTransferencia;
	private JTextField textValorTransferencia;
	
	public JPanel getPanelDeposito() {
		return panel;
	}

	public void setPanelDeposito(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField() {
		return textDataTransferencia;
	}

	public void setTextField(JTextField textField) {
		this.textDataTransferencia = textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferencia window = new Transferencia();
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
	public Transferencia() {
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
		
		textDataTransferencia = new JTextField();
		textDataTransferencia.setBounds(98, 158, 147, 33);
		textDataTransferencia.setEditable(false);
		panel.add(textDataTransferencia);
		textDataTransferencia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(98, 144, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblConta = new JLabel("Conta Destino");
		lblConta.setBounds(278, 144, 86, 14);
		panel.add(lblConta);
		
		textContaTransferencia = new JTextField();
		textContaTransferencia.setEditable(false);
		textContaTransferencia.setColumns(10);
		textContaTransferencia.setBounds(278, 158, 147, 33);
		panel.add(textContaTransferencia);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(240, 207, 46, 14);
		panel.add(lblNewLabel_1);
		
		textValorTransferencia = new JTextField();
		textValorTransferencia.setEditable(false);
		textValorTransferencia.setColumns(10);
		textValorTransferencia.setBounds(194, 223, 147, 33);
		panel.add(textValorTransferencia);
		
	}
}
