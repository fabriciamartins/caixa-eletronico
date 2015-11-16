package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorDigitandoConta extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	private int contaDigitada;
	
	public BBProcessadorDigitandoConta(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaConta(int i) {
		this.contaDigitada *= 10;
		this.contaDigitada += i;
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaConta(1);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum02Digitada() {
		processaConta(2);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum03Digitada() {
		processaConta(3);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum04Digitada() {
		processaConta(4);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum05Digitada() {
		processaConta(5);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum06Digitada() {
		processaConta(6);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum07Digitada() {
		processaConta(7);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum08Digitada() {
		processaConta(8);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum09Digitada() {
		processaConta(9);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaNum00Digitada() {
		processaConta(0);
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaConfirmaDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorDigitandoSenha());
		}
		MaquinaBancoBrasil.instance.setContaDigitada(contaDigitada);
		String msg = " - Digite a senha ou digite CONFIRMA";
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.contaDigitada = 0;
		String msg = " - Continue a digitar a conta ou digite CONFIRMA\n - Conta: ";
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_CONTA, null);
	}

	@Override
	public void teclaCancelarDigitada() {
		//TO DO - voltar a tela inicial
	}

	@Override
	public void teclaEsquerda01Digitada() {
	
	}

	@Override
	public void teclaEsquerda02Digitada() {
		
	}

	@Override
	public void teclaEsquerda03Digitada() {
		
	}

	@Override
	public void teclaEsquerda04Digitada() {

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
