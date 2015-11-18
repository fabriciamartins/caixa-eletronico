package br.edu.facisa.caixa.gui.santander;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class SantanderEscolhaFuncionalidade extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SantanderEscolhaFuncionalidade() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.RED);
		
		JLabel lblSaldoNaTela = new JLabel("SALDO NA TELA");
		lblSaldoNaTela.setForeground(Color.WHITE);
		lblSaldoNaTela.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblConsultarExtrato = new JLabel("CONSULTAR EXTRATO");
		lblConsultarExtrato.setForeground(Color.WHITE);
		lblConsultarExtrato.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDeposito = new JLabel("DEPOSITO");
		lblDeposito.setForeground(Color.WHITE);
		lblDeposito.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("SAQUE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblConsultarExtrato)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(lblSaldoNaTela))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDeposito, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSaldoNaTela)
						.addComponent(lblConsultarExtrato))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblDeposito))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
