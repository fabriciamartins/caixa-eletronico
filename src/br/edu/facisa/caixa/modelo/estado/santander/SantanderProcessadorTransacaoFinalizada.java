package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorTransacaoFinalizada extends MaquinaAdapter implements ProcessadorEstado {

	private List<EstadoListener> listeners;
	
	public SantanderProcessadorTransacaoFinalizada(){
		listeners = new ArrayList<EstadoListener>();
	}

	@Override
	public void teclaConfirmaDigitada() {
		
	}

	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaCancelarDigitada() {
		// TODO Auto-generated method stub
		
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

		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaSantander.getInstance().notificaMudanca(evento);
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
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		// TODO Auto-generated method stub
		
	}

}
