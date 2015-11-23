package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Extrato {

	private JPanel panel;
	private JLabel lblSaque;
	public JTextPane txtpnLoremIpsum;
	private JLabel lbl_finalizar_sessao;
	private JLabel lblRetornarATela;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLblDeposito() {
		return lblSaque;
	}

	public void setLblDeposito(JLabel lblDeposito) {
		this.lblSaque = lblDeposito;
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
		
		txtpnLoremIpsum = new JTextPane();
		txtpnLoremIpsum.setText("Extrato:");
		txtpnLoremIpsum.setBounds(101, 150, 371, 95);
		panel.add(txtpnLoremIpsum);
		
		lbl_finalizar_sessao = new JLabel("Finalizar Sess\u00E3o");
		lbl_finalizar_sessao.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_finalizar_sessao.setForeground(Color.DARK_GRAY);
		lbl_finalizar_sessao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_finalizar_sessao.setBounds(24, 241, 141, 26);
		lbl_finalizar_sessao.setVisible(true);
		panel.add(lbl_finalizar_sessao);
		
		lblRetornarATela = new JLabel("Retornar a tela de opera\u00E7\u00F5es");
		lblRetornarATela.setHorizontalAlignment(SwingConstants.LEFT);
		lblRetornarATela.setForeground(Color.DARK_GRAY);
		lblRetornarATela.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRetornarATela.setBounds(314, 241, 211, 26);
		lblRetornarATela.setVisible(true);
		panel.add(lblRetornarATela);
		
	}
}
