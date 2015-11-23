package br.edu.facisa.caixa.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teclas extends JPanel implements MaquinaDeEstadosListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMaquinaDeEstados maquinaAtual = MaquinaPrimaria.getInstance();
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
	
	/**
	 * Create the panel.
	 */
	public Teclas() {
		
		setForeground(Color.LIGHT_GRAY);
		setBackground(SystemColor.control);

		MaquinaPrimaria.getInstance().adicionaMaquinaDeEstadosListener(this);
		
		tecla00 = new JButton("0");
		tecla00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum00Digitada();
			}
		});
		tecla00.setBackground(Color.LIGHT_GRAY);
		tecla00.setForeground(Color.DARK_GRAY);
		tecla00.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla00.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla00.setBounds(50, 122, 40, 35);
		
		tecla01 = new JButton("1");
		tecla01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maquinaAtual.teclaNum01Digitada();
			}
		});
		tecla01.setBackground(Color.LIGHT_GRAY);
		tecla01.setForeground(Color.DARK_GRAY);
		tecla01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla01.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla01.setBounds(6, 5, 40, 35);
		
		tecla02 = new JButton("2");
		tecla02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum02Digitada();
			}
		});
		tecla02.setBackground(Color.LIGHT_GRAY);
		tecla02.setForeground(Color.DARK_GRAY);
		tecla02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla02.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla02.setBounds(50, 5, 40, 35);
		
		tecla03 = new JButton("3");
		tecla03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum03Digitada();
			}
		});
		tecla03.setBackground(Color.LIGHT_GRAY);
		tecla03.setForeground(Color.DARK_GRAY);
		tecla03.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla03.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla03.setBounds(94, 5, 40, 35);
		
		tecla04 = new JButton("4");
		tecla04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum04Digitada();
			}
		});
		tecla04.setBackground(Color.LIGHT_GRAY);
		tecla04.setForeground(Color.DARK_GRAY);
		tecla04.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla04.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla04.setBounds(5, 45, 40, 35);
		
		tecla05 = new JButton("5");
		tecla05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum05Digitada();
			}
		});
		tecla05.setBackground(Color.LIGHT_GRAY);
		tecla05.setForeground(Color.DARK_GRAY);
		tecla05.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla05.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla05.setBounds(49, 45, 40, 35);
		
		tecla06 = new JButton("6");
		tecla06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum06Digitada();
			}
		});
		tecla06.setBackground(Color.LIGHT_GRAY);
		tecla06.setForeground(Color.DARK_GRAY);
		tecla06.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla06.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla06.setBounds(93, 45, 40, 35);
		
		tecla07 = new JButton("7");
		tecla07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum07Digitada();
			}
		});
		tecla07.setBackground(Color.LIGHT_GRAY);
		tecla07.setForeground(Color.DARK_GRAY);
		tecla07.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla07.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla07.setBounds(6, 84, 40, 35);
		
		tecla08 = new JButton("8");
		tecla08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum08Digitada();
			}
		});
		tecla08.setBackground(Color.LIGHT_GRAY);
		tecla08.setForeground(Color.DARK_GRAY);
		tecla08.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla00.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla08.setBounds(50, 84, 40, 35);
		
		tecla09 = new JButton("9");
		tecla09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaNum09Digitada();
			}
		});
		tecla09.setBackground(Color.LIGHT_GRAY);
		tecla09.setForeground(Color.DARK_GRAY);
		tecla09.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tecla09.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tecla09.setBounds(94, 84, 40, 35);
		
		teclaCancelar = new JButton("");
		teclaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaCancelarDigitada();
			}
		});
		teclaCancelar
		.setIcon(new ImageIcon(Teclas.class.getResource("/br/edu/facisa/caixa/resource/bt-vermelho.png")));
		teclaCancelar.setBackground(Color.LIGHT_GRAY);
		teclaCancelar.setForeground(Color.DARK_GRAY);
		teclaCancelar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaCancelar.setBounds(144, 5, 101, 35);
		teclaCancelar.setBorder(null);
		teclaCancelar.setFocusPainted(false);
		teclaCancelar.setContentAreaFilled(false);
		teclaCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		teclaConfirmar = new JButton("");
		teclaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaConfirmaDigitada();
			}
		});
		teclaConfirmar
		.setIcon(new ImageIcon(Teclas.class.getResource("/br/edu/facisa/caixa/resource/bt-confirma.png")));
		teclaConfirmar.setBackground(Color.LIGHT_GRAY);
		teclaConfirmar.setForeground(Color.DARK_GRAY);
		teclaConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaConfirmar.setBounds(144, 84, 101, 35);
		teclaConfirmar.setBorder(null);
		teclaConfirmar.setFocusPainted(false);
		teclaConfirmar.setContentAreaFilled(false);
		teclaConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		teclaCorrigir = new JButton("");
		teclaCorrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinaAtual.teclaCorrigeDigitada();
			}
		});
		teclaCorrigir
		.setIcon(new ImageIcon(Teclas.class.getResource("/br/edu/facisa/caixa/resource/bt-amarelo.png")));
		teclaCorrigir.setBackground(Color.LIGHT_GRAY);
		teclaCorrigir.setForeground(Color.DARK_GRAY);
		teclaCorrigir.setFont(new Font("Tahoma", Font.PLAIN, 10));
		teclaCorrigir.setBounds(144, 45, 101, 35);
		teclaCorrigir.setBorder(null);
		teclaCorrigir.setFocusPainted(false);
		teclaCorrigir.setContentAreaFilled(false);
		teclaCorrigir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tecla01)
						.addComponent(tecla04)
						.addComponent(tecla07))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tecla00)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tecla02)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tecla03))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tecla05)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tecla06)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tecla08)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tecla09)))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(teclaCancelar)
						.addComponent(teclaConfirmar)
						.addComponent(teclaCorrigir))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tecla01)
								.addComponent(tecla02)
								.addComponent(tecla03))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tecla04)
								.addComponent(tecla05)
								.addComponent(tecla06))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tecla07)
								.addComponent(tecla08)
								.addComponent(tecla09))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tecla00)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(teclaCancelar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(teclaConfirmar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teclaCorrigir)
							.addContainerGap(26, Short.MAX_VALUE))))
		);
		
		setLayout(groupLayout);

	}

	@Override
	public void houveMudanca(MaquinaDeEstadosEvent mudanca) {
		// TODO Auto-generated method stub
		
	}
	
	public IMaquinaDeEstados getMaquinaAtual() {
		return maquinaAtual;
	}

	public void setMaquinaAtual(IMaquinaDeEstados maquinaAtual) {
		this.maquinaAtual = maquinaAtual;
	}
	
	
}
