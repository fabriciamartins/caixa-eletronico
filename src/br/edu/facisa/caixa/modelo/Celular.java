package br.edu.facisa.caixa.modelo;

public class Celular {

	private String operadora;
	private long numero;
	private boolean recarregado;
	
	public Celular() {
		this.setRecarregado(false);
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public boolean isRecarregado() {
		return recarregado;
	}

	public void setRecarregado(boolean recarregado) {
		this.recarregado = recarregado;
	}

}
