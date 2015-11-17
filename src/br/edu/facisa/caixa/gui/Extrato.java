package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Extrato {

	private JPanel panel;
	private JLabel lblSaque;
	
	public JPanel getPanelSaque() {
		return panel;
	}

	public void setPanelSaque(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLblDeposito() {
		return lblSaque;
	}

	public void setLblDeposito(JLabel lblDeposito) {
		this.lblSaque = lblDeposito;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Extrato window = new Extrato();
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
	public Extrato() {
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
		
		lblSaque = new JLabel("Extrato Banc\u00E1rio!");
		lblSaque.setBounds(145, 120, 246, 14);
		lblSaque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaque.setForeground(new Color(128, 128, 128));
		lblSaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaque.setVisible(false);
		panel.add(lblSaque);
		
		JTextPane txtpnLoremIpsum = new JTextPane();
		txtpnLoremIpsum.setText("Lorem Ipsum \u00E9 simplesmente uma simula\u00E7\u00E3o de texto da ind\u00FAstria tipogr\u00E1fica e de impressos, e vem sendo utilizado desde o s\u00E9culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.");
		txtpnLoremIpsum.setBounds(101, 150, 371, 95);
		panel.add(txtpnLoremIpsum);
		
	}
}
