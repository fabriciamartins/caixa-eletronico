package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public abstract class MaquinaGenericaDeBancos extends MaquinaAdapter implements EstadoListener{
	
	private int contaDigitada;
	private int senhaDigitada;
	private double valorDigitado;
	private String asteriscos = "";
	private TransacaoBancariaFacade transacaoBancaria = new TransacaoBancariaFacade();
	public ProcessadorEstado processadorEstado;
	
	protected String telaInicial;
	
	@Override
	public void estadoAcabou(ProcessadorEstado novoEstado) {
		processadorEstado = novoEstado;
		processadorEstado.addEstadoListener(this);
	}

	public void iniciar() {
		
	}
	
	public void teclaNumericaDigitada(String numTecla){
		processadorEstado.teclaNumericaDigitada(numTecla);
	}

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

	public void teclaEsquerda01Digitada(){
		processadorEstado.teclaEsquerda01Digitada();
	}

	public void teclaEsquerda02Digitada(){
		processadorEstado.teclaEsquerda02Digitada();
	}

	public void teclaEsquerda03Digitada(){
		processadorEstado.teclaEsquerda03Digitada();
	}

	public void teclaEsquerda04Digitada(){
		processadorEstado.teclaEsquerda04Digitada();
	}

	public void teclaDireita01Digitada(){
		processadorEstado.teclaDireita01Digitada();
	}

	public void teclaDireita02Digitada(){
		processadorEstado.teclaDireita02Digitada();
	}
	
	public void teclaDireita03Digitada(){
		processadorEstado.teclaDireita03Digitada();
	}
	
	public void teclaDireita04Digitada(){
		processadorEstado.teclaDireita04Digitada();
	}
	
	public int getContaDigitada() {
		return contaDigitada;
	}

	public void setContaDigitada(int contaDigitada) {
		this.contaDigitada = contaDigitada;
	}

	public int getSenhaDigitada() {
		return senhaDigitada;
	}

	public void setSenhaDigitada(int senhaDigitada) {
		this.senhaDigitada = senhaDigitada;
	}

	public double getValorDigitado() {
		return valorDigitado;
	}

	public void setValorDigitado(double valorDigitado) {
		this.valorDigitado = valorDigitado;
	}

	public String getAsteriscos() {
		return asteriscos;
	}

	public void setAsteriscos(String asteriscos) {
		this.asteriscos = asteriscos;
	}

	public TransacaoBancariaFacade getTransacaoBancaria() {
		return transacaoBancaria;
	}

	public void setTransacaoBancaria(TransacaoBancariaFacade transacaoBancaria) {
		this.transacaoBancaria = transacaoBancaria;
	}

}
