package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.edu.facisa.caixa.modelo.RandomSenhaLetras;
import javax.swing.JTextField;

public class SenhaLetras {

	private JPanel panel;
	private RandomSenhaLetras senhaLetras;
	public JLabel esquerda01;
	public JLabel esquerda02;
	public JLabel esquerda03;
	public JLabel esquerda04;
	public JLabel direita01;
	public JLabel direita02;
	public JLabel direita03;
	public JLabel direita04;
	public JTextField textField;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Create the application.
	 */
	public SenhaLetras() {
		senhaLetras = new RandomSenhaLetras();
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
		
		//JLabel lblEmprstimos = new JLabel("Empr\u00E9stimos");
		esquerda01 = new JLabel(senhaLetras.getRandomLetra());
		esquerda01.setHorizontalAlignment(SwingConstants.LEFT);
		esquerda01.setForeground(Color.DARK_GRAY);
		esquerda01.setFont(new Font("Tahoma", Font.BOLD, 14));
		esquerda01.setBounds(15, 112, 141, 26);
		panel.add(esquerda01);
		
		//JLabel lblPagamentos = new JLabel("Pagamentos");
		esquerda02 = new JLabel(senhaLetras.getRandomLetra());
		esquerda02.setHorizontalAlignment(SwingConstants.LEFT);
		esquerda02.setForeground(Color.DARK_GRAY);
		esquerda02.setFont(new Font("Tahoma", Font.BOLD, 14));
		esquerda02.setBounds(17, 156, 141, 26);
		panel.add(esquerda02);
		
		//JLabel lblRecarga = new JLabel("Recarga");
		esquerda03 = new JLabel(senhaLetras.getRandomLetra());
		esquerda03.setHorizontalAlignment(SwingConstants.LEFT);
		esquerda03.setForeground(Color.DARK_GRAY);
		esquerda03.setFont(new Font("Tahoma", Font.BOLD, 14));
		esquerda03.setBounds(17, 200, 141, 26);
		panel.add(esquerda03);
		
		//JLabel lblTr = new JLabel("Transfer\u00EAncia");
		esquerda04 = new JLabel(senhaLetras.getRandomLetra());
		esquerda04.setHorizontalAlignment(SwingConstants.LEFT);
		esquerda04.setForeground(Color.DARK_GRAY);
		esquerda04.setFont(new Font("Tahoma", Font.BOLD, 14));
		esquerda04.setBounds(17, 245, 141, 26);
		panel.add(esquerda04);
		
		//JLabel lblSaque = new JLabel("Saque");
		direita01 = new JLabel(senhaLetras.getRandomLetra());
		direita01.setHorizontalAlignment(SwingConstants.RIGHT);
		direita01.setForeground(Color.DARK_GRAY);
		direita01.setFont(new Font("Tahoma", Font.BOLD, 14));
		direita01.setBounds(399, 119, 116, 26);
		panel.add(direita01);
		
		//JLabel lblExtrato = new JLabel("Extrato");
		direita02 = new JLabel(senhaLetras.getRandomLetra());
		direita02.setHorizontalAlignment(SwingConstants.RIGHT);
		direita02.setForeground(Color.DARK_GRAY);
		direita02.setFont(new Font("Tahoma", Font.BOLD, 14));
		direita02.setBounds(379, 162, 141, 26);
		panel.add(direita02);
		
		//JLabel lblDeposito = new JLabel("Deposito");
		direita03 = new JLabel(senhaLetras.getRandomLetra());
		direita03.setHorizontalAlignment(SwingConstants.RIGHT);
		direita03.setForeground(Color.DARK_GRAY);
		direita03.setFont(new Font("Tahoma", Font.BOLD, 14));
		direita03.setBounds(379, 207, 141, 26);
		panel.add(direita03);
		
		//JLabel lblBloquearCarto = new JLabel("Bloquear Cart\u00E3o");
		direita04 = new JLabel(senhaLetras.getRandomLetra());
		direita04.setHorizontalAlignment(SwingConstants.RIGHT);
		direita04.setForeground(Color.DARK_GRAY);
		direita04.setFont(new Font("Tahoma", Font.BOLD, 14));
		direita04.setBounds(378, 247, 141, 26);
		panel.add(direita04);
		
		textField = new JTextField();
		textField.setBounds(218, 161, 86, 20);
		textField.setEnabled(false);
		panel.add(textField);
		textField.setColumns(10);
		
	}
}
