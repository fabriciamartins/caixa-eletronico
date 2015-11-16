package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("Operação Cancelada!\n Saldo da conta insuficiente.");
	}
}
