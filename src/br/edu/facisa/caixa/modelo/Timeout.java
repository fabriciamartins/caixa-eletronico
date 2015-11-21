package br.edu.facisa.caixa.modelo;

import javax.swing.JOptionPane;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;

public class Timeout extends Thread {

	private final long milliSegundos;
	private Runnable runnable;
	private IMaquinaDeEstados maquinaAtual;

	public Timeout(IMaquinaDeEstados maquinaAtual, long milliSegundos, Runnable runnable) {
		this.milliSegundos = milliSegundos;
		this.runnable = runnable;
		this.maquinaAtual = maquinaAtual;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < (start + milliSegundos)) {
			runnable.run();
		}
		JOptionPane.showMessageDialog(null,"Tempo limite excedido!");
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		maquinaAtual.notificaMudanca(evento);
	}

}
