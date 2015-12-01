package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class BBProcessadorEscolhendoTransacao extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	
	public BBProcessadorEscolhendoTransacao() {
		listeners = new ArrayList<EstadoListener>();
	}
	
	public void confirmaSenha(int operacaoEscolhida) {

		BBProcessadorDigitandoSenha opcao = new BBProcessadorDigitandoSenha();
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(opcao);
		}
		opcao.setOperacaoEscolhida(operacaoEscolhida);
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Senha().getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
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
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new ProcessadorEstadoInicial());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}	

	@Override
	public void teclaEsquerda01Digitada() {
		confirmaSenha(1);
	}

	@Override
	public void teclaEsquerda02Digitada() {
		confirmaSenha(2);
	}

	@Override
	public void teclaEsquerda03Digitada() {
		confirmaSenha(3);
	}

	@Override
	public void teclaEsquerda04Digitada() {
		confirmaSenha(4);
	}

	@Override
	public void teclaDireita01Digitada() {
		confirmaSenha(5);
	}

	@Override
	public void teclaDireita02Digitada() {
		confirmaSenha(6);
	}

	@Override
	public void teclaDireita03Digitada() {
		confirmaSenha(7);
	}

	@Override
	public void teclaDireita04Digitada() {
		confirmaSenha(8);
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
