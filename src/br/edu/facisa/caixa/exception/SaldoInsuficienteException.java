package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("Opera��o Cancelada!\n Saldo da conta insuficiente.");
	}
}
