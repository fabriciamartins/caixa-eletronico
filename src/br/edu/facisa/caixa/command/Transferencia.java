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
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Transferência    " + valor + "\n";
	}

}
