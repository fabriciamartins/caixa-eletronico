package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class Deposito implements TransacaoCommand {

	private Date data;
	private Conta conta;
	private double valor;
	
	public Deposito(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.conta = transacaoBancaria.getContaOrigem();
		this.valor = transacaoBancaria.getValor();		
	}

	@Override
	public void executar() {
		conta.incrementar(valor);
		this.conta.addTransacao(this);
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Deposito         " + valor + "\n";
	}

}
