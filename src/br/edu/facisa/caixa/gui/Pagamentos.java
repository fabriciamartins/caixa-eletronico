package br.edu.facisa.caixa.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Pagamentos {

	private JPanel panel;
	private JLabel lbl;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLblDeposito(JLabel lbl) {
		this.lbl = lbl;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagamentos window = new Pagamentos();
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
		
		lbl = new JLabel("Pagamentos");
		lbl.setBounds(10, 117, 515, 17);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(false);
		panel.add(lbl);
		
		lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(93, 157, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(88, 176, 132, 33);
		panel.add(textField_1);
		
		lblNewLabel_2 = new JLabel("C\u00F3digo de Barras");
		lblNewLabel_2.setBounds(252, 157, 120, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(251, 176, 217, 33);
		panel.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Valor");
		lblNewLabel_3.setBounds(150, 249, 31, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(191, 240, 168, 33);
		panel.add(textField_3);
		
	}
}
