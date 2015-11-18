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
		setBackground(Color.WHITE);
		
		JLabel lblInsiraONumero = new JLabel("INSIRA O NUMERO DO SEU CART\u00C3O:");
		lblInsiraONumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsiraONumero.setForeground(Color.DARK_GRAY);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(lblInsiraONumero, Alignment.LEADING))
					.addGap(131))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(lblInsiraONumero)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		setLayout(groupLayout);

	}
}
