package br.edu.facisa.caixa.facade;

import br.edu.facisa.caixa.command.BloqueioCartao;
import br.edu.facisa.caixa.command.ConsultaExtrato;
import br.edu.facisa.caixa.command.Deposito;
import br.edu.facisa.caixa.command.Emprestimo;
import br.edu.facisa.caixa.command.PagamentoTitulo;
import br.edu.facisa.caixa.command.RecargaCelular;
import br.edu.facisa.caixa.command.Saque;
import br.edu.facisa.caixa.command.Transferencia;
import br.edu.facisa.caixa.modelo.Celular;
import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Titulo;

public class TransacaoBancariaFacade implements ITransacaoBancaria {
	
	private Conta contaOrigem;
	private Conta contaDestino;
	private double valor;
	private Titulo titulo;
	private Celular celular;
	
	public void depositar() {
		new Deposito(this).executar();	
	}
	
	public void sacar() {
		new Saque(this).executar();
	}
	
	public void tranferir() {
		new Transferencia(this).executar();
	}
	
	public String consultarExtrato() {
		ConsultaExtrato consultaExtrato = new ConsultaExtrato(this);
		consultaExtrato.executar();
		return consultaExtrato.toString();
	}
	
	public void pagarConta() {
		new PagamentoTitulo(this).executar();
	}
	
	public void recarregarCelular() {
		new RecargaCelular(this).executar();
	}
	
	public void obterEmprestimo() {
		new Emprestimo(this).executar();
	}
	
	public void bloquearCartao() {
		new BloqueioCartao(this).executar();
	}
	
	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}
			
}
