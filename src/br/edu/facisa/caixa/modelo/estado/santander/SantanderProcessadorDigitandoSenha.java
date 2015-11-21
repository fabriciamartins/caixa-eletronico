package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class SantanderProcessadorDigitandoSenha extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	private int senhaDigitada;	
	private String asteriscos = "";
	private Senha telaSenha = new Senha();
	
	public SantanderProcessadorDigitandoSenha(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
	}
	
	@Override
	public void teclaNum01Digitada() {
		teclaDigitada(1);
	}

	@Override
	public void teclaNum02Digitada() {
		teclaDigitada(2);
	}

	@Override
	public void teclaNum03Digitada() {
		teclaDigitada(3);
	}

	@Override
	public void teclaNum04Digitada() {
		teclaDigitada(4);
	}

	@Override
	public void teclaNum05Digitada() {
		teclaDigitada(5);
	}

	@Override
	public void teclaNum06Digitada() {
		teclaDigitada(6);
	}

	@Override
	public void teclaNum07Digitada() {
		teclaDigitada(7);
	}

	@Override
	public void teclaNum08Digitada() {
		teclaDigitada(8);
	}

	@Override
	public void teclaNum09Digitada() {
		teclaDigitada(9);
	}

	@Override
	public void teclaNum00Digitada() {
		teclaDigitada(0);
	}

	@Override
	public void teclaConfirmaDigitada() {

		if(Dados.getInstance().isContaValida("Santander", MaquinaSantander.instance.getContaDigitada(), senhaDigitada)){
			MaquinaSantander.instance.setSenhaDigitada(senhaDigitada);
			this.senhaDigitada = 0;
			this.asteriscos = "";
			
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
			}
			
			this.removeEstadoListener(MaquinaSantander.instance);
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}
		else {
			this.senhaDigitada = 0;
			this.asteriscos = "";
			telaSenha.textField.setText(asteriscos);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaSenha.getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaCancelarDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new ProcessadorEstadoInicial());
		}
		
		this.removeEstadoListener(MaquinaSantander.instance);
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaSantander.instance.notificaMudanca(evento);
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

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

	public void teclaDigitada(int tecla){
		processaSenha(tecla);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.instance.notificaMudanca(evento);
	}
	
}
