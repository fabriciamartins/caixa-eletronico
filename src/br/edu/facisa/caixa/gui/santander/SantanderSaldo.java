package br.edu.facisa.caixa.gui.santander;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SantanderSaldo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SantanderSaldo() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		
		JLabel lblSaldoNaTela = new JLabel("SALDO NA TELA");
		
		JLabel lblConta = new JLabel("Conta:");
		
		JLabel lblSaldoDisponvel = new JLabel("Saldo Dispon\u00EDvel:");
		
		JLabel lblCrdito = new JLabel("Cr\u00E9dito:");
		
		JLabel lblSaldoTotal = new JLabel("Saldo Total:");
		
		JLabel lblPressioneCancelarPara = new JLabel("PRESSIONE CANCELAR PARA VOLTAR AO MENU PRINCIPAL");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCrdito, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblConta)
							.addComponent(lblSaldoNaTela, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSaldoDisponvel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSaldoTotal, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(315, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(383, Short.MAX_VALUE)
					.addComponent(lblPressioneCancelarPara)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblSaldoNaTela)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblConta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSaldoDisponvel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCrdito)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSaldoTotal)
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(lblPressioneCancelarPara)
					.addGap(29))
		);
		setLayout(groupLayout);

	}

}
