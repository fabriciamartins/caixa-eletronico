package br.edu.facisa.caixa.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosListener;
public class TelaInicial extends JFrame implements MaquinaDeEstadosListener{

	/**
	 * 
	 */
	
	private static TelaInicial instance;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel telaAtual = new JPanel();
	private IMaquinaDeEstados maquinaAtual;

	/**
	 * Launch the application.
	 */
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton tecla01;
	private JButton tecla02;
	private JButton tecla03;
	private JButton tecla04;
	private JButton tecla05;
	private JButton tecla06;
	private JButton tecla07;
	private JButton tecla08;
	private JButton tecla09;
	private JButton tecla00;
	private JButton teclaCancelar;
	private JButton teclaCorrigir;
	private JButton teclaConfirmar;

	public static TelaInicial getInstance(){
		if(instance == null){
			instance = new TelaInicial();
		}
		return instance;
	}
	
	JButton button;
	private JPanel panel;
	private JLabel labelLogoBancos;
	private JLabel lblNewLabel_1;
	/**
	 * Create the frame.
	 */
	private TelaInicial() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		getContentPane().setBackground(SystemColor.control);
		
		MaquinaPrimaria.instance.adicionaMaquinaDeEstadosListener(this);
		maquinaAtual = MaquinaPrimaria.instance;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 650);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_1.setBorder(null);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBorder(null);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setBorder(null);
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		/*Altera a tela do caixa*/
		panel = new Deposito().getPanelDeposito();
		getContentPane().setLayout(getLayout(panel));
		
		labelLogoBancos = new JLabel("");
		labelLogoBancos.setBounds(233, 12, 75, 75);
		labelLogoBancos.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/banco_brasil.jpg")));
		panel.add(labelLogoBancos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	
	public GroupLayout getLayout(JPanel telaAtual){
		
		JPanel panel_teclas = new JPanel();
		panel_teclas.setForeground(Color.WHITE);
		panel_teclas.setBackground(SystemColor.control);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/header.jpg")));
		
		button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_4.setBorder(null);
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBorder(null);
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBorder(null);
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setBorder(null);
		button_7.setFocusPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5)
						.addComponent(button_7))
					.addContainerGap(42, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(335, Short.MAX_VALUE)
					.addComponent(panel_teclas, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addGap(299))
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(145)
							.addComponent(button_3)
							.addGap(11)
							.addComponent(button_4)
							.addGap(8)
							.addComponent(button_5)
							.addGap(13)
							.addComponent(button_7)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_teclas, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_teclas.setLayout(null);
		
		tecla01 = new JButton("1");
		tecla01.setBackground(Color.LIGHT_GRAY);
		tecla01.setForeground(Color.DARK_GRAY);
		tecla01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla01.setBounds(6, 5, 40, 35);
		panel_teclas.add(tecla01);
		
		tecla02 = new JButton("2");
		tecla02.setBackground(Color.LIGHT_GRAY);
		tecla02.setForeground(Color.DARK_GRAY);
		tecla02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla02.setBounds(50, 5, 40, 35);
		panel_teclas.add(tecla02);
		
		tecla03 = new JButton("3");
		tecla03.setBackground(Color.LIGHT_GRAY);
		tecla03.setForeground(Color.DARK_GRAY);
		tecla03.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla03.setBounds(94, 5, 40, 35);
		panel_teclas.add(tecla03);
		
		tecla05 = new JButton("5");
		tecla05.setBackground(Color.LIGHT_GRAY);
		tecla05.setForeground(Color.DARK_GRAY);
		tecla05.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla05.setBounds(49, 45, 40, 35);
		panel_teclas.add(tecla05);
		
		tecla06 = new JButton("6");
		tecla06.setBackground(Color.LIGHT_GRAY);
		tecla06.setForeground(Color.DARK_GRAY);
		tecla06.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla06.setBounds(93, 45, 40, 35);
		panel_teclas.add(tecla06);
		
		tecla07 = new JButton("7");
		tecla07.setBackground(Color.LIGHT_GRAY);
		tecla07.setForeground(Color.DARK_GRAY);
		tecla07.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla07.setBounds(6, 84, 40, 35);
		panel_teclas.add(tecla07);
		
		tecla04 = new JButton("4");
		tecla04.setBackground(Color.LIGHT_GRAY);
		tecla04.setForeground(Color.DARK_GRAY);
		tecla04.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla04.setBounds(5, 45, 40, 35);
		panel_teclas.add(tecla04);
		tecla04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum04Digitada();
			}
		});
		
		tecla00 = new JButton("0");
		tecla00.setBackground(Color.LIGHT_GRAY);
		tecla00.setForeground(Color.DARK_GRAY);
		tecla00.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla00.setBounds(50, 122, 40, 35);
		panel_teclas.add(tecla00);
		
		tecla08 = new JButton("8");
		tecla08.setBackground(Color.LIGHT_GRAY);
		tecla08.setForeground(Color.DARK_GRAY);
		tecla08.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla08.setBounds(50, 84, 40, 35);
		panel_teclas.add(tecla08);
		
		tecla09 = new JButton("9");
		tecla09.setBackground(Color.LIGHT_GRAY);
		tecla09.setForeground(Color.DARK_GRAY);
		tecla09.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla09.setBounds(94, 84, 40, 35);
		panel_teclas.add(tecla09);
		
		teclaConfirmar = new JButton("");
		teclaConfirmar.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-confirma.png")));
		teclaConfirmar.setBackground(Color.LIGHT_GRAY);
		teclaConfirmar.setForeground(Color.DARK_GRAY);
		teclaConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaConfirmar.setBounds(144, 84, 101, 35);
		teclaConfirmar.setBorder(null);
		teclaConfirmar.setFocusPainted(false);
		teclaConfirmar.setContentAreaFilled(false);
		teclaConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_teclas.add(teclaConfirmar);
		
		teclaCorrigir = new JButton("");
		teclaCorrigir.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-amarelo.png")));
		teclaCorrigir.setBackground(Color.LIGHT_GRAY);
		teclaCorrigir.setForeground(Color.DARK_GRAY);
		teclaCorrigir.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaCorrigir.setBounds(144, 45, 101, 35);
		teclaCorrigir.setBorder(null);
		teclaCorrigir.setFocusPainted(false);
		teclaCorrigir.setContentAreaFilled(false);
		teclaCorrigir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_teclas.add(teclaCorrigir);
		
		teclaCancelar = new JButton("");
		teclaCancelar.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/edu/facisa/caixa/resource/bt-vermelho.png")));
		teclaCancelar.setBackground(Color.LIGHT_GRAY);
		teclaCancelar.setForeground(Color.DARK_GRAY);
		teclaCancelar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaCancelar.setBounds(144, 5, 101, 35);
		teclaCancelar.setBorder(null);
		teclaCancelar.setFocusPainted(false);
		teclaCancelar.setContentAreaFilled(false);
		teclaCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_teclas.add(teclaCancelar);
		teclaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaCancelarDigitada();
			}
		});
		teclaCorrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaCorrigeDigitada();
			}
		});
		teclaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaConfirmaDigitada();
			}
		});
		tecla09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum09Digitada();
			}
		});
		tecla08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum08Digitada();
			}
		});
		tecla00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum00Digitada();
			}
		});
		tecla07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum07Digitada();
			}
		});
		tecla06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum06Digitada();
			}
		});
		tecla05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum05Digitada();
			}
		});
		tecla03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum03Digitada();
			}
		});
		tecla02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum02Digitada();
			}
		});
		tecla01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum01Digitada();
			}
		});
		
		return groupLayout;
	}
	
	public void setTelaAtual(JPanel tela){
		getContentPane().removeAll();
		getContentPane().setLayout(getLayout(tela));
		
	}
	
	public JPanel getTelaAtual(){
		return this.telaAtual;
	}

	@Override
	public void houveMudanca(MaquinaDeEstadosEvent mudanca) {
		if (mudanca.getTrocaMaquinaDeEstados() != null) {
			switch (mudanca.getTrocaMaquinaDeEstados()) {
			case "Santander" :
				this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaSatander();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
			case "Banco do Brasil" :
				
			}
		}
	}

	public IMaquinaDeEstados getMaquinaAtual() {
		return maquinaAtual;
	}

	public void setMaquinaAtual(IMaquinaDeEstados maquinaAtual) {
		this.maquinaAtual = maquinaAtual;
	}
}
