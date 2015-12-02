package br.edu.facisa.caixa.modelo.estado;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.gui.Home;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Dados;


public class ProcessadorEstadoInicial extends MaquinaAdapter implements ProcessadorEstado {

	private List<EstadoListener> listeners;
	private String numeroCartao = "";

	public ProcessadorEstadoInicial(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	@Override
	public void teclaNumericaDigitada(String numTecla) {
		numeroCartao += numTecla;
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.getInstance().notificaMudanca(evento);
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		if(!(numeroCartao.equals(""))){
			
			this.removeEstadoListener(MaquinaPrimaria.getInstance());
			
			int numeroConta = Integer.valueOf(numeroCartao);
			Conta conta = Dados.getInstance().validarConta(numeroConta);
			MaquinaPrimaria.getInstance().setContaDigitada(numeroConta);
			
			this.numeroCartao = "";
			Home.getInstance().textField.setText(numeroCartao);
			
			if((conta != null) && (conta.getCartao().isBloqueado())){
				JOptionPane.showMessageDialog(null, "Cartão Bloqueado");
				teclaCorrigeDigitada();
			}
			else if(conta == null){
				JOptionPane.showMessageDialog(null,"Numero de cartão inválido");
				teclaCorrigeDigitada();
			}
			else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados(conta.getBanco().getNome());
				MaquinaPrimaria.getInstance().notificaMudanca(evento);
			}
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
	public void teclaCorrigeDigitada() {
		numeroCartao = "";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaCancelarDigitada() {
		numeroCartao = "";
		Home.getInstance().textField.setText(numeroCartao);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(Home.getInstance());
		MaquinaPrimaria.getInstance().notificaMudanca(evento);
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
