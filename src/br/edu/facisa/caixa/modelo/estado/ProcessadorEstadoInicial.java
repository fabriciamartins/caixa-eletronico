package br.edu.facisa.caixa.modelo.estado;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.gui.Home;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;


public class ProcessadorEstadoInicial extends MaquinaAdapter implements ProcessadorEstado {

	private List<EstadoListener> listeners;
	private String numeroCartao = "";

	public ProcessadorEstadoInicial(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		if(!(numeroCartao.equals(""))){
			
			this.removeEstadoListener(MaquinaPrimaria.instance);
			
			int numeroConta = Integer.valueOf(numeroCartao);
			String banco = Dados.getInstance().validarConta(numeroConta);
			MaquinaPrimaria.instance.setContaDigitada(numeroConta);
			
			this.numeroCartao = "";
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados(banco);
			MaquinaPrimaria.instance.notificaMudanca(evento);
		}
		else{
			teclaCorrigeDigitada();
		}
	}
	
	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void teclaNum01Digitada() {
		numeroCartao += "1";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum02Digitada() {
		numeroCartao += "2";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum03Digitada() {
		numeroCartao += "3";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum04Digitada() {
		numeroCartao += "4";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum05Digitada() {
		numeroCartao += "5";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum06Digitada() {
		numeroCartao += "6";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum07Digitada() {
		numeroCartao += "7";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum08Digitada() {
		numeroCartao += "8";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum09Digitada() {
		numeroCartao += "9";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum00Digitada() {
		numeroCartao += "0";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaCorrigeDigitada() {
		numeroCartao = "";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaCancelarDigitada() {
		numeroCartao = "";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.instance.notificaMudanca(evento);
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
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		listeners.remove(listener);
	}

	
}
