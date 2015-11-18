package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BloquearCartao {

	private JPanel panel;
	private JLabel lbl;
	
	public JPanel getPanelDeposito() {
		return panel;
	}

	public void setPanelDeposito(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloquearCartao window = new BloquearCartao();
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
	public BloquearCartao() {
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
		
		lbl = new JLabel("Deseja bloquear o cart\u00E3o?");
		lbl.setBounds(146, 141, 246, 26);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl.setForeground(new Color(204, 51, 0));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(false);
		panel.add(lbl);
		
	}
}
