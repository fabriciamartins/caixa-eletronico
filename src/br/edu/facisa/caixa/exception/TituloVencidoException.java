package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class TituloVencidoException extends Exception {

	public TituloVencidoException() {
		super("Operação Cancelada! Título vencido para pagamento nesta data.");
	}
}
