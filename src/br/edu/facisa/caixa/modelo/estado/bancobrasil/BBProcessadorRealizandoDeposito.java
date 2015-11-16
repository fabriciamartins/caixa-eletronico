package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.enumerador.Operacao;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorRealizandoDeposito extends MaquinaAdapter implements ProcessadorEstado {

	private double valorDigitado;
	private List<EstadoListener> listeners;
	
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
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum02Digitada() {
		processaValor(2);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum03Digitada() {
		processaValor(3);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum04Digitada() {
		processaValor(4);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum05Digitada() {
		processaValor(5);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum06Digitada() {
		processaValor(6);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum07Digitada() {
		processaValor(7);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum08Digitada() {
		processaValor(8);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum09Digitada() {
		processaValor(9);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaNum00Digitada() {
		processaValor(0);
		String msg = " - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado;
		MaquinaBancoBrasil.instance.configurarEvento(msg, REALIZANDO_DEPOSITO, null);
	}

	@Override
	public void teclaConfirmaDigitada() {
		MaquinaBancoBrasil.instance.configurarEvento(" - Digite CONFIRMA quando Inserir o envelope na bandeja", FINALIZANDO_TRANSACAO, Operacao.ABRE_BANDEJA_DEPOSITO);
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
