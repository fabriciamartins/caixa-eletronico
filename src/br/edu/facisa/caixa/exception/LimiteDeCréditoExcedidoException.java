package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class LimiteDeCr�ditoExcedidoException extends Exception {

	public LimiteDeCr�ditoExcedidoException() {
		super("Opera��o Cancelada! Limite de cr�dito para emprestimos excedido.");
	}
}
