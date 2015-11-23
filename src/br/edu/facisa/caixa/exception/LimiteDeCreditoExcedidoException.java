package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class LimiteDeCreditoExcedidoException extends Exception {

	public LimiteDeCreditoExcedidoException() {
		super("Operação Cancelada! Limite de crédito para emprestimos excedido.");
	}
}
