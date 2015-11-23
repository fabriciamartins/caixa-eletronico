package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.OperacaoCancelada;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Saque;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorSaque implements ProcessadorEstado {
	
	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Saque telaSaque = new Saque();

	public SantanderProcessadorSaque(){
		this.listeners = new ArrayList<>();
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaValor(1);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum02Digitada() {
		processaValor(2);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum03Digitada() {
		processaValor(3);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum04Digitada() {
		processaValor(4);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum05Digitada() {
		processaValor(5);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum06Digitada() {
		processaValor(6);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum07Digitada() {
		processaValor(7);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum08Digitada() {
		processaValor(8);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum09Digitada() {
		processaValor(9);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaNum00Digitada() {
		processaValor(0);
		setEventoDeTeclaNumDigitada();
	}

	@Override
	public void teclaConfirmaDigitada() {
		MaquinaSantander.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Santander", MaquinaSantander.getInstance().getContaDigitada()));
		MaquinaSantander.getInstance().getTransacaoBancaria().setValor(valorDigitado);
		MaquinaSantander.getInstance().getTransacaoBancaria().sacar();
		String msg = MaquinaSantander.getInstance().getTransacaoBancaria().getMensagem();
		if (msg != null) {
			setEventoDeEstadoFinal(new SantanderProcessadorTransacaoFinalizada(), new OperacaoCancelada(msg).getPanel());
		} else {
			setEventoDeEstadoFinal(new SantanderProcessadorTransacaoFinalizada(), new OperacaoSucesso().getPanel());
		}
				
	}

	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaCancelarDigitada() {
		setEventoDeEstadoFinal(new SantanderProcessadorEscolhendoTransacao(), new Operacoes().getPanel());
	}

	@Override
	public void teclaEsquerda01Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaEsquerda02Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaEsquerda03Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaEsquerda04Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaDireita01Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaDireita02Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaDireita03Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaDireita04Digitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}
	
	private void setEventoDeTeclaNumDigitada() {
		telaSaque.getTextField().setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSaque.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}
	
	private void setEventoDeEstadoFinal(ProcessadorEstado processadorestado, JPanel operacao) {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(processadorestado);
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(operacao, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

}
