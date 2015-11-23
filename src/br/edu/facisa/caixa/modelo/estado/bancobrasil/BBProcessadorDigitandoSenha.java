package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;


import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorDigitandoSenha extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	private int senhaDigitada;
	private String asteriscos = "";
	private Senha telaSenha = new Senha();
	
	public BBProcessadorDigitandoSenha(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaSenha(1);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum02Digitada() {
		processaSenha(2);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum03Digitada() {
		processaSenha(3);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum04Digitada() {
		processaSenha(4);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum05Digitada() {
		processaSenha(5);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum06Digitada() {
		processaSenha(6);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum07Digitada() {
		processaSenha(7);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum08Digitada() {
		processaSenha(8);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum09Digitada() {
		processaSenha(9);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum00Digitada() {
		processaSenha(0);
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaConfirmaDigitada() {
		if(Dados.getInstance().isContaValida("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada(), senhaDigitada)){
			MaquinaBancoBrasil.getInstance().setSenhaDigitada(senhaDigitada);
			this.senhaDigitada = 0;
			this.asteriscos = "";
			
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new BBProcessadorEscolhendoTransacao());
			}
			
			this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}
		else {
			this.senhaDigitada = 0;
			this.asteriscos = "";
			telaSenha.textField.setText(asteriscos);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaSenha.getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: ";
		MaquinaBancoBrasil.getInstance().configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaCancelarDigitada() {
		//TO DO - voltar a tela anterior
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

}
