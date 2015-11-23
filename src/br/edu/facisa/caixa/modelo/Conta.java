package br.edu.facisa.caixa.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.command.TransacaoCommand;
import br.edu.facisa.caixa.exception.LimiteDeCreditoExcedidoException;
import br.edu.facisa.caixa.exception.SaldoInsuficienteException;

public class Conta {

	private Banco banco;
	private int numero;
	private int senha;
	private double saldo;
	private double limiteDeCredito;
	private double emprestimoObtido;
	private Cartao cartao;
	private List<TransacaoCommand> extrato;
	
	public Conta() {
		this.extrato = new ArrayList<TransacaoCommand>();
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void incrementar(double valor) {
		this.saldo += valor;				
	}
	
	public void decrementar(double valor) throws SaldoInsuficienteException {
		if (this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException();
		}		
	}

	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public double getEmprestimoObtido() {
		return emprestimoObtido;
	}

	public void obterEmprestimo(double valor) throws LimiteDeCreditoExcedidoException {
		if(this.emprestimoObtido <= this.limiteDeCredito){
			this.emprestimoObtido = valor;
		} else {
			throw new LimiteDeCreditoExcedidoException();
		}		
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public List<TransacaoCommand> getExtrato() {
		return extrato;
	}

	public void addTransacao(TransacaoCommand transacao) {
		this.extrato.add(transacao);
	}

}
