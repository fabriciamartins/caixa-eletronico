package br.edu.facisa.caixa.exception;

@SuppressWarnings("serial")
public class TituloVencidoException extends Exception {

	public TituloVencidoException() {
		super("Opera��o Cancelada! T�tulo vencido para pagamento nesta data.");
	}
}
