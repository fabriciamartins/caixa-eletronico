package br.edu.facisa.caixa.facade;

public interface ITransacaoBancaria {

	public void depositar();
	
	public boolean sacar();
	
	public boolean tranferir();
	
	public String consultarExtrato();
	
	public boolean pagarConta();
	
	public boolean recarregarCelular();
	
	public boolean obterEmprestimo();
	
	public void bloquearCartao();
	
}
