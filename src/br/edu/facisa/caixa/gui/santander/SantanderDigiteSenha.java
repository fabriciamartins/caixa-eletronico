package br.edu.facisa.caixa.gui.santander;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SantanderDigiteSenha extends JPanel {

	/**
	 * 
	 */
	private static SantanderDigiteSenha instance;
	private static final long serialVersionUID = 1L;
	public JTextField textField;

	/**
	 * Create the panel.
	 */
	
	public static SantanderDigiteSenha getInstance(){
		if(instance == null){
			instance = new SantanderDigiteSenha();
		}
		return instance;
	}
	
	private SantanderDigiteSenha() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.RED);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SantanderDigiteSenha.class.getResource("/resource/santander-logo.jpg")));
		
		JLabel lblBemvindoAo = new JLabel("BEM-VINDO AO SANTANDER");
		lblBemvindoAo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBemvindoAo.setForeground(Color.BLACK);
		
		JLabel lblDigiteSuaSenha = new JLabel("DIGITE SUA SENHA:");
		lblDigiteSuaSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(lblBemvindoAo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDigiteSuaSenha))))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblBemvindoAo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDigiteSuaSenha, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
