package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorEscolhendoTransacao extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	
	public SantanderProcessadorEscolhendoTransacao() {
		listeners = new ArrayList<EstadoListener>();
	}
	

	@Override
	public void teclaNum01Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorRealizandoDeposito());
		}
		MaquinaSantander.instance.configurarEvento(" - Digite o valor de Dep�sito - Valor: ", REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum02Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum04Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum05Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum06Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum07Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum08Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum09Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum00Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaConfirmaDigitada() {
		// TODO Auto-generated method stub
		
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
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

}
