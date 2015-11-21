package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Transferencia {

	private JPanel panel;
	private JTextField textContaTransferencia;
	private JTextField textValorTransferencia;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextContaDestino() {
		return this.textContaTransferencia;
	}
	
	public void setTextContaDestino(String contaDestino) {
		this.textContaTransferencia.setText(contaDestino);
	}
	
	public JTextField getTextValor() {
		return this.textValorTransferencia;
	}
	
	public void setTextValor(String valor){
		this.textValorTransferencia.setText(valor);
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
		
		JLabel lblConta = new JLabel("Conta Destino");
		lblConta.setBounds(110, 146, 86, 14);
		panel.add(lblConta);
		
		textContaTransferencia = new JTextField();
		textContaTransferencia.setEditable(false);
		textContaTransferencia.setColumns(10);
		textContaTransferencia.setBounds(110, 160, 147, 33);
		panel.add(textContaTransferencia);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(281, 146, 46, 14);
		panel.add(lblNewLabel_1);
		
		textValorTransferencia = new JTextField();
		textValorTransferencia.setEditable(false);
		textValorTransferencia.setColumns(10);
		textValorTransferencia.setBounds(281, 160, 147, 33);
		panel.add(textValorTransferencia);
		
	}
}
