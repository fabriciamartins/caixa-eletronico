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
	private boolean bloqueado;
	private String mensagem;
	
	public void depositar() {
		new Deposito(this).executar();	
	}
	
	public boolean sacar() {
		Saque saque = new Saque(this);
		saque.executar();
		return saque.isValorValido();
	}
	
	public boolean tranferir() {
		Transferencia transferencia = new Transferencia(this);
		transferencia.executar();
		this.mensagem = transferencia.getMensagem();
		return transferencia.isValido();
	}
	
	public String consultarExtrato() {
		ConsultaExtrato consultaExtrato = new ConsultaExtrato(this);
		consultaExtrato.executar();
		return consultaExtrato.toString();
	}
	
	public boolean pagarConta() {
		PagamentoTitulo pagamento = new PagamentoTitulo(this);
		pagamento.executar();
		this.mensagem = pagamento.getMensagem();
		return pagamento.isValido();
	}
	
	public boolean recarregarCelular() {
		RecargaCelular recarga = new RecargaCelular(this);
		recarga.executar();
		this.mensagem = recarga.getMensagem();
		return recarga.isValido();
	}
	
	public boolean obterEmprestimo() {
		Emprestimo emprestimo = new Emprestimo(this);
		emprestimo.executar();
		this.mensagem = emprestimo.getMensagem();
		return emprestimo.isValido();
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
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
			
}
