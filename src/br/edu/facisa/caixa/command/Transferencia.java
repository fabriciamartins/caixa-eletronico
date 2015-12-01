package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.SaldoInsuficienteException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class Transferencia implements TransacaoCommand {

	private Date data;
	private Conta contaOrigem;
	private Conta contaDestino;
	private double valor;
	private String mensagem;
	private boolean isValido = false;
	
	public Transferencia(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.contaOrigem = transacaoBancaria.getContaOrigem();
		this.contaDestino = transacaoBancaria.getContaDestino();
		this.valor = transacaoBancaria.getValor();
	}
	
	@Override
	public void executar() {
		try {
			contaOrigem.decrementar(valor);
			contaDestino.incrementar(valor);
			this.contaOrigem.addTransacao(this);
			this.contaDestino.addTransacao(this);
			this.setValido(true);
		} catch (SaldoInsuficienteException e) {
			this.setValido(false);
			this.setMensagem(e.getMessage());
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Transferência    " + valor + "\n";
	}

	public boolean isValido() {
		return isValido;
	}

	public void setValido(boolean isValido) {
		this.isValido = isValido;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
