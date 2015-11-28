package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
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
	public void teclaConfirmaDigitada() {

		if(Dados.getInstance().isContaValida("Santander", MaquinaSantander.getInstance().getContaDigitada(), senhaDigitada)){
			MaquinaSantander.getInstance().setSenhaDigitada(senhaDigitada);
			this.senhaDigitada = 0;
			this.asteriscos = "";
			
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
			}
			
			this.removeEstadoListener(MaquinaSantander.getInstance());
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_SANTANDER());
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
		else {
			this.senhaDigitada = 0;
			this.asteriscos = "";
			telaSenha.textField.setText(asteriscos);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_SANTANDER());
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_SANTANDER());
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaCancelarDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new ProcessadorEstadoInicial());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaSantander.getInstance().notificaMudanca(evento);
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

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		processaSenha(Integer.valueOf(numTecla));
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_SANTANDER());
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}
	
}
