package br.edu.facisa.caixa.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	
	public Banco(String arg) {
		this.contas = new ArrayList<Conta>();
		setNome(arg);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void addContas(Conta conta) {
		this.contas.add(conta);
	}
	
}
