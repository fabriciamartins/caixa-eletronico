package br.edu.facisa.caixa.modelo.estado;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.enumerador.Operacao;
import br.edu.facisa.caixa.modelo.estado.bancobrasil.BBProcessadorDigitandoConta;
import br.edu.facisa.caixa.modelo.estado.santander.SandanderProcessadorDigitandoConta;

public class ProcessadorEstadoEscolhendoBanco extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;

	public ProcessadorEstadoEscolhendoBanco() {
		listeners = new ArrayList<EstadoListener>();
	}

	@Override
	public void teclaNum01Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorDigitandoConta());
		}
		MaquinaPrimaria.instance.configurarEvento("Banco do Brasil", this.estado, Operacao.TROCA_DE_MAQUINA);
	}

	@Override
	public void teclaNum02Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SandanderProcessadorDigitandoConta());
		}
		MaquinaPrimaria.instance.configurarEvento("Santander", this.estado, Operacao.TROCA_DE_MAQUINA);
	}

	@Override
	public void teclaNum03Digitada() {
		MaquinaPrimaria.instance.configurarEvento("Caixa Economica", this.estado, Operacao.TROCA_DE_MAQUINA);
	}

	@Override
	public void teclaNum04Digitada() {
		MaquinaPrimaria.instance.configurarEvento("Bradesco", this.estado, Operacao.TROCA_DE_MAQUINA);
	}

	@Override
	public void teclaNum05Digitada() {
		MaquinaPrimaria.instance.configurarEvento("Itau", this.estado, Operacao.TROCA_DE_MAQUINA);
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
