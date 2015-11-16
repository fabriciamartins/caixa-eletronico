package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class LimiteDeCréditoExcedidoException extends Exception {

	public LimiteDeCréditoExcedidoException() {
		super("Operação Cancelada! Limite de crédito para emprestimos excedido.");
	}
}
