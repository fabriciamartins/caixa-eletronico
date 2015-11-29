package br.edu.facisa.caixa.gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BloquearCartaoFinalizado {

	private JPanel panel;
	private JLabel lbl;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	/**
	 * Create the application.
	 */
	public BloquearCartaoFinalizado() {
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
		
		lbl = new JLabel("Cart\u00E3o bloqueado com sucesso!");
		lbl.setBounds(147, 118, 246, 26);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(true);
		panel.add(lbl);
		
		JLabel lbl_finalizar_sessao = new JLabel("Finalizar Sess\u00E3o");
		lbl_finalizar_sessao.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_finalizar_sessao.setForeground(Color.DARK_GRAY);
		lbl_finalizar_sessao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_finalizar_sessao.setBounds(24, 241, 141, 26);
		lbl_finalizar_sessao.setVisible(true);
		panel.add(lbl_finalizar_sessao);
		
	}
}
