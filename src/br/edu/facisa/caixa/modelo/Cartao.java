package br.edu.facisa.caixa.modelo;

public class Cartao{

	private int numero;
	private boolean bloqueado;
	private Conta conta;
	
	public Cartao(Conta conta) {
		this.setConta(conta);
		this.setBloqueado(false);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
