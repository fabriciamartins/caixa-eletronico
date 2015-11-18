package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorRealizandoDeposito extends MaquinaAdapter implements ProcessadorEstado {

	private double valorDigitado;
	private List<EstadoListener> listeners;
	
	public SantanderProcessadorRealizandoDeposito(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaValor(1);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum02Digitada() {
		processaValor(2);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum03Digitada() {
		processaValor(3);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum04Digitada() {
		processaValor(4);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum05Digitada() {
		processaValor(5);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum06Digitada() {
		processaValor(6);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum07Digitada() {
		processaValor(7);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum08Digitada() {
		processaValor(8);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum09Digitada() {
		processaValor(9);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum00Digitada() {
		processaValor(0);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaSantander.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaConfirmaDigitada() {
		MaquinaSantander.instance.getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Santander", MaquinaSantander.instance.getContaDigitada()));
		MaquinaSantander.instance.getTransacaoBancaria().setValor(valorDigitado);
		MaquinaSantander.instance.getTransacaoBancaria().depositar();
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorTransacaoFinalizada());
		}
		MaquinaSantander.instance.configurarEvento(" - Deposito realizado com Sucesso!\n" + exibirTela4(), ESCOLHENDO_OPCAO, null);
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
