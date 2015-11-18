package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Operacoes {

	private JPanel panel;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operacoes window = new Operacoes();
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
	public Operacoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		panel.setBackground(SystemColor.window);
		panel.setSize(535,  320);
		panel.setLayout(null);
		
		JLabel lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		lblSelecioneAOpo.setForeground(Color.DARK_GRAY);
		lblSelecioneAOpo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelecioneAOpo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneAOpo.setBounds(0, 95, 535, 26);
		panel.add(lblSelecioneAOpo);
		
		JLabel lblEmprstimos = new JLabel("Empr\u00E9stimos");
		lblEmprstimos.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmprstimos.setForeground(Color.DARK_GRAY);
		lblEmprstimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmprstimos.setBounds(15, 112, 141, 26);
		panel.add(lblEmprstimos);
		
		JLabel lblPagamentos = new JLabel("Pagamentos");
		lblPagamentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblPagamentos.setForeground(Color.DARK_GRAY);
		lblPagamentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPagamentos.setBounds(17, 156, 141, 26);
		panel.add(lblPagamentos);
		
		JLabel lblRecarga = new JLabel("Recarga");
		lblRecarga.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecarga.setForeground(Color.DARK_GRAY);
		lblRecarga.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRecarga.setBounds(17, 200, 141, 26);
		panel.add(lblRecarga);
		
		JLabel lblTr = new JLabel("Transfer\u00EAncia");
		lblTr.setHorizontalAlignment(SwingConstants.LEFT);
		lblTr.setForeground(Color.DARK_GRAY);
		lblTr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTr.setBounds(17, 245, 141, 26);
		panel.add(lblTr);
		
		JLabel lblSaque = new JLabel("Saque");
		lblSaque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaque.setForeground(Color.DARK_GRAY);
		lblSaque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaque.setBounds(399, 119, 116, 26);
		panel.add(lblSaque);
		
		JLabel lblExtrato = new JLabel("Extrato");
		lblExtrato.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExtrato.setForeground(Color.DARK_GRAY);
		lblExtrato.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExtrato.setBounds(379, 162, 141, 26);
		panel.add(lblExtrato);
		
		JLabel lblDeposito = new JLabel("Deposito");
		lblDeposito.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeposito.setForeground(Color.DARK_GRAY);
		lblDeposito.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeposito.setBounds(379, 207, 141, 26);
		panel.add(lblDeposito);
		
		JLabel lblBloquearCarto = new JLabel("Bloquear Cart\u00E3o");
		lblBloquearCarto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloquearCarto.setForeground(Color.DARK_GRAY);
		lblBloquearCarto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloquearCarto.setBounds(378, 247, 141, 26);
		panel.add(lblBloquearCarto);
		
	}
}
