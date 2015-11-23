package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.OperacaoCancelada;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorBloquearCartao implements ProcessadorEstado {
	
	private List<EstadoListener> listeners;
	
	public SantanderProcessadorBloquearCartao(){
		this.listeners = new ArrayList<>();
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		MaquinaSantander.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Santander", MaquinaSantander.getInstance().getContaDigitada()));
		MaquinaSantander.getInstance().getTransacaoBancaria().setBloqueado(true);
		MaquinaSantander.getInstance().getTransacaoBancaria().bloquearCartao();
		setEventoDeEstadoFinal(new SantanderProcessadorTransacaoFinalizada(), new OperacaoSucesso().getPanel());
	}

	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaCancelarDigitada() {
		setEventoDeEstadoFinal(new SantanderProcessadorTransacaoFinalizada(), new OperacaoCancelada("Operação cancelada pelo usuario!").getPanel());
		
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
	
	private void setEventoDeEstadoFinal(ProcessadorEstado processadorestado, JPanel operacao) {		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(processadorestado);
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(operacao, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		// TODO Auto-generated method stub
		
	}

}
