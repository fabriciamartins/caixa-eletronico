package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class TimeoutExcedido extends Exception{

	public TimeoutExcedido() {
		super("Tempo limite Excedido!");
	}

}
