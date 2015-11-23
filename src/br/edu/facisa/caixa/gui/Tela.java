package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame implements MaquinaDeEstadosListener{

	/**
	 * 
	 */
	public static Tela instance = new Tela();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IMaquinaDeEstados maquinaAtual;
	JPanel panel;
	
	private JButton button_esquerdo_2;
	private JButton button_esquerdo_3;
	private JButton button_esquerdo_4;
	private JButton button_direito_1;
	private JButton button_direito_2;
	private JButton button_direito_3;
	private JButton button_direito_4;
	private JButton button_esquerdo_1;
	private JLabel lblNewLabel_1;
	private Teclas teclas = new Teclas();
	private JLabel labelLogoBancos;



	/**
	 * Create the frame.
	 */
	private Tela() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		getContentPane().setBackground(SystemColor.control);

		MaquinaPrimaria.instance.adicionaMaquinaDeEstadosListener(this);
		maquinaAtual = MaquinaPrimaria.instance;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		button_esquerdo_2 = new JButton("");
		button_esquerdo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaEsquerda02Digitada();
			}
		});
		button_esquerdo_2.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_esquerdo_2.setBorder(null);
		button_esquerdo_2.setFocusPainted(false);
		button_esquerdo_2.setContentAreaFilled(false);
		button_esquerdo_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_esquerdo_3 = new JButton("");
		button_esquerdo_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaEsquerda03Digitada();
			}
		});
		button_esquerdo_3.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_esquerdo_3.setBorder(null);
		button_esquerdo_3.setFocusPainted(false);
		button_esquerdo_3.setContentAreaFilled(false);
		button_esquerdo_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_esquerdo_4 = new JButton("");
		button_esquerdo_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaEsquerda04Digitada();
			}
		});
		button_esquerdo_4.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_esquerdo_4.setBackground(Color.LIGHT_GRAY);
		button_esquerdo_4.setBorder(null);
		button_esquerdo_4.setFocusPainted(false);
		button_esquerdo_4.setContentAreaFilled(false);
		button_esquerdo_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_direito_1 = new JButton("");
		button_direito_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaDireita01Digitada();
			}
		});
		button_direito_1.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_direito_1.setBackground(Color.LIGHT_GRAY);
		button_direito_1.setBorder(null);
		button_direito_1.setFocusPainted(false);
		button_direito_1.setContentAreaFilled(false);
		button_direito_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_direito_2 = new JButton("");
		button_direito_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaDireita02Digitada();
			}
		});
		button_direito_2.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_direito_2.setBorder(null);
		button_direito_2.setBackground(Color.LIGHT_GRAY);
		button_direito_2.setFocusPainted(false);
		button_direito_2.setContentAreaFilled(false);
		button_direito_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_direito_3 = new JButton("");
		button_direito_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaDireita03Digitada();
			}
		});
		button_direito_3.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_direito_3.setBackground(Color.LIGHT_GRAY);
		button_direito_3.setBorder(null);
		button_direito_3.setFocusPainted(false);
		button_direito_3.setContentAreaFilled(false);
		button_direito_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		button_direito_4 = new JButton("");
		button_direito_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaDireita04Digitada();
			}
		});
		button_direito_4.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_direito_4.setBackground(Color.LIGHT_GRAY);
		button_direito_4.setBorder(null);
		button_direito_4.setFocusPainted(false);
		button_direito_4.setContentAreaFilled(false);
		button_direito_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		button_esquerdo_1 = new JButton("");
		button_esquerdo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaEsquerda01Digitada();
			}
		});
		button_esquerdo_1.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/bt-laterais.png")));
		button_esquerdo_1.setBackground(Color.LIGHT_GRAY);
		button_esquerdo_1.setBorder(null);
		button_esquerdo_1.setFocusPainted(false);
		button_esquerdo_1.setContentAreaFilled(false);
		button_esquerdo_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		labelLogoBancos = new JLabel("");
		labelLogoBancos.setBounds(233, 12, 75, 75);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Tela.class.getResource("/br/edu/facisa/caixa/resource/header.jpg")));
				contentPane.setLayout(getLayout());
		

	}
	
	public GroupLayout getLayout(){
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 889, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_esquerdo_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_esquerdo_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_esquerdo_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_esquerdo_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_direito_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_direito_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_direito_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_direito_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(282)
					.addComponent(teclas, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(teclas, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(button_direito_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(button_direito_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_direito_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_direito_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(button_esquerdo_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(button_esquerdo_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_esquerdo_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_esquerdo_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
		);

		return gl_contentPane;
	}

	@Override
	public void houveMudanca(MaquinaDeEstadosEvent mudanca) {
		if (mudanca.getTrocaMaquinaDeEstados() != null) {
			switch (mudanca.getTrocaMaquinaDeEstados()) {
			case "Santander":
				this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaSatander();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
			case "Banco do Brasil":

			}
		}
	}
	
	public IMaquinaDeEstados getMaquinaAtual() {
		return maquinaAtual;
	}

	public void setMaquinaAtual(IMaquinaDeEstados maquinaAtual) {
		this.maquinaAtual = maquinaAtual;
		teclas.setMaquinaAtual(maquinaAtual);
	}
	
	public void setTelaAtual(JPanel tela, String pathLogoBanco) {
		panel = tela;
		if(pathLogoBanco != null){
			this.labelLogoBancos.setIcon(new ImageIcon(Tela.class.getResource(pathLogoBanco)));
			panel.add(labelLogoBancos);
		}
		getContentPane().removeAll();
		getContentPane().setLayout(getLayout());
		getContentPane().repaint();
	}

	public JPanel getTelaAtual() {
		return this.panel;
	}
	
}
