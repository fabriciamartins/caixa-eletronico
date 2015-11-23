package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.Deposito;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorRealizandoDeposito extends MaquinaAdapter implements ProcessadorEstado {

	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Deposito telaDeposito = new Deposito();
	
	public BBProcessadorRealizandoDeposito(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaValor(1);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum02Digitada() {
		processaValor(2);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum03Digitada() {
		processaValor(3);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum04Digitada() {
		processaValor(4);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum05Digitada() {
		processaValor(5);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum06Digitada() {
		processaValor(6);telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum07Digitada() {
		processaValor(7);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum08Digitada() {
		processaValor(8);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum09Digitada() {
		processaValor(9);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaNum00Digitada() {
		processaValor(0);
		telaDeposito.textField.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaDeposito.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaConfirmaDigitada() {
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada()));
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setValor(valorDigitado);
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().depositar();
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorTransacaoFinalizada());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new OperacaoSucesso().getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		
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

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

}
