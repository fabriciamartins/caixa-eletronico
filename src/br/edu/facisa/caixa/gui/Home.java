package br.edu.facisa.caixa.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static Home instance;
	private static final long serialVersionUID = 1L;
	public JTextField textField;

	public static Home getInstance(){
		if(instance == null){
			instance = new Home();
		}
		return instance;
	}
	
	/**
	 * Create the panel.
	 */
	private Home() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/br/edu/facisa/caixa/resource/logo-banco24horas.jpg")));
		
		JLabel lblInsiraONumero = new JLabel("INSIRA O NUMERO DO SEU CART\u00C3O:");
		lblInsiraONumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsiraONumero.setForeground(new Color(0, 0, 0));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(lblInsiraONumero, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(26)
					.addComponent(lblInsiraONumero)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
