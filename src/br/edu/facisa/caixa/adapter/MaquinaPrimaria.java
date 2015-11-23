package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.gui.Home;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class MaquinaPrimaria extends MaquinaGenericaDeBancos implements EstadoListener{

	private static MaquinaPrimaria instance;
	private ProcessadorEstado processadorEstado;
	
	private MaquinaPrimaria(){
		processadorEstado = new ProcessadorEstadoInicial();
		processadorEstado.addEstadoListener(this);
	}
	
	public static MaquinaPrimaria getInstance(){
		if(instance == null){
			instance = new MaquinaPrimaria();
		}
		return instance;
	}

	public void iniciar() {
		super.setContaDigitada(0);
		super.setSenhaDigitada(0);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);
	}

	public void teclaNum01Digitada() {
		processadorEstado.teclaNum01Digitada();
	}
	
	public void teclaNum02Digitada() {
		processadorEstado.teclaNum02Digitada();
	}

	@Override
	public void teclaNum03Digitada() {
		processadorEstado.teclaNum03Digitada();
	}

	@Override
	public void teclaNum04Digitada() {
		processadorEstado.teclaNum04Digitada();
	}

	@Override
	public void teclaNum05Digitada() {
		processadorEstado.teclaNum05Digitada();
	}

	@Override
	public void teclaNum06Digitada() {
		processadorEstado.teclaNum06Digitada();
	}

	@Override
	public void teclaNum07Digitada() {
		processadorEstado.teclaNum07Digitada();
	}

	@Override
	public void teclaNum08Digitada() {
		processadorEstado.teclaNum08Digitada();
	}

	@Override
	public void teclaNum09Digitada() {
		processadorEstado.teclaNum09Digitada();
	}

	@Override
	public void teclaNum00Digitada() {
		processadorEstado.teclaNum00Digitada();
	}

	@Override
	public void teclaConfirmaDigitada() {
		processadorEstado.teclaConfirmaDigitada();
	}

	@Override
	public void teclaCorrigeDigitada() {
		processadorEstado.teclaCorrigeDigitada();
	}

	@Override
	public void teclaCancelarDigitada() {
		processadorEstado.teclaCancelarDigitada();
	}

	@Override
	public void estadoAcabou(ProcessadorEstado novoEstado) {
		processadorEstado = novoEstado;
		processadorEstado.addEstadoListener(this);
	}

}
