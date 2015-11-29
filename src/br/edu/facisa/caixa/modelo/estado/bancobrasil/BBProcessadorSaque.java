package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.OperacaoCancelada;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Saque;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorSaque implements ProcessadorEstado {
	
	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Saque telaSaque = new Saque();

	public BBProcessadorSaque(){
		this.listeners = new ArrayList<>();
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada()));
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setValor(valorDigitado);
		
		if (MaquinaBancoBrasil.getInstance().getTransacaoBancaria().sacar()) {
			setEventoDeEstadoFinal(new BBProcessadorTransacaoFinalizada(), new OperacaoSucesso().getPanel());
		} else {
			setEventoDeEstadoFinal(new BBProcessadorTransacaoFinalizada(), new OperacaoCancelada("Operação Cancelada!\n Saldo da conta insuficiente.").getPanel());
		}
				
	}

	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaCancelarDigitada() {
		setEventoDeEstadoFinal(new BBProcessadorEscolhendoTransacao(), new Operacoes().getPanel());
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
		evento.setNovaTela(telaSaque.getPanel(),new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}
	
	private void setEventoDeEstadoFinal(ProcessadorEstado processadorestado, JPanel operacao) {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(processadorestado);
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(operacao, new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		processaValor(Integer.valueOf(numTecla));
		setEventoDeTeclaNumDigitada();
	}

}
