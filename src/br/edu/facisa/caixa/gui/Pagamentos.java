package br.edu.facisa.caixa.gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Pagamentos {

	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblDataVencimento;
	public JTextField textDataVencimento;
	private JLabel lblCodBarras;
	public JTextField textCodBarras;
	private JLabel lblValor;
	public JTextField textValor;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblDataVencimento() {
		return lblDataVencimento;
	}

	public void setLblDataVencimento(JLabel lblDataVencimento) {
		this.lblDataVencimento = lblDataVencimento;
	}

	public JTextField getTextDataVencimento() {
		return textDataVencimento;
	}

	public void setTextDataVencimento(JTextField textDataVencimento) {
		this.textDataVencimento = textDataVencimento;
	}

	public JLabel getLblCodBarras() {
		return lblCodBarras;
	}

	public void setLblCodBarras(JLabel lblCodBarras) {
		this.lblCodBarras = lblCodBarras;
	}

	public JTextField getTextCodBarras() {
		return textCodBarras;
	}

	public void setTextCodBarras(JTextField textCodBarras) {
		this.textCodBarras = textCodBarras;
	}

	public JLabel getLblValor() {
		return lblValor;
	}

	public void setLblValor(JLabel lblValor) {
		this.lblValor = lblValor;
	}

	public JTextField getTextValor() {
		return textValor;
	}

	public void setTextValor(JTextField textValor) {
		this.textValor = textValor;
	}
	
	/**
	 * Create the application.
	 */
	public Pagamentos() {
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
		
		lblTitulo = new JLabel("Pagamentos");
		lblTitulo.setBounds(10, 117, 515, 17);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setForeground(new Color(0, 128, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setVisible(false);
		panel.add(lblTitulo);
		
		lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setBounds(64, 155, 105, 14);
		panel.add(lblDataVencimento);
		
		textDataVencimento = new JTextField();
		textDataVencimento.setEditable(false);
		textDataVencimento.setToolTipText("");
		textDataVencimento.setColumns(10);
		textDataVencimento.setBounds(64, 176, 132, 33);
		panel.add(textDataVencimento);
		
		lblCodBarras = new JLabel("C\u00F3digo de Barras");
		lblCodBarras.setBounds(252, 157, 120, 14);
		panel.add(lblCodBarras);
		
		textCodBarras = new JTextField();
		textCodBarras.setEditable(false);
		textCodBarras.setToolTipText("");
		textCodBarras.setColumns(10);
		textCodBarras.setBounds(251, 176, 217, 33);
		panel.add(textCodBarras);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(150, 249, 31, 14);
		panel.add(lblValor);
		
		textValor = new JTextField();
		textValor.setToolTipText("");
		textValor.setEditable(false);
		textValor.setColumns(10);
		textValor.setBounds(191, 240, 168, 33);
		panel.add(textValor);
		
	}
}
