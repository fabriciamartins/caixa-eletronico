package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class LimiteDeCreditoExcedidoException extends Exception {

	public LimiteDeCreditoExcedidoException() {
		super("Opera��o Cancelada! Limite de cr�dito para emprestimos excedido.");
	}
}
