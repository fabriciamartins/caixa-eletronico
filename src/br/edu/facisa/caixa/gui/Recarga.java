package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Recarga {

	private JPanel panel;
	private JTextField textNumeroRecarga;
	private JTextField textValorRecarga;
	
	public JPanel getPanelDeposito() {
		return panel;
	}

	public void setPanelDeposito(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField() {
		return textNumeroRecarga;
	}

	public void setTextField(JTextField textField) {
		this.textNumeroRecarga = textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recarga window = new Recarga();
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
	public Recarga() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(176, 98, 178, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		textNumeroRecarga = new JTextField();
		textNumeroRecarga.setBounds(96, 160, 141, 33);
		textNumeroRecarga.setEditable(false);
		panel.add(textNumeroRecarga);
		textNumeroRecarga.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero");
		lblNewLabel_1.setBounds(96, 142, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(284, 142, 46, 14);
		panel.add(lblValor);
		
		textValorRecarga = new JTextField();
		textValorRecarga.setEditable(false);
		textValorRecarga.setColumns(10);
		textValorRecarga.setBounds(284, 160, 141, 33);
		panel.add(textValorRecarga);
		
	}
}
