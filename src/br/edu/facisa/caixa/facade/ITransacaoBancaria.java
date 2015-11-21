package br.edu.facisa.caixa.facade;

public interface ITransacaoBancaria {

	public void depositar();
	
	public void sacar();
	
	public void tranferir();
	
	public String consultarExtrato();
	
	public void pagarConta();
	
	public void recarregarCelular();
	
	public void obterEmprestimo();
	
	public void bloquearCartao();
	
}
