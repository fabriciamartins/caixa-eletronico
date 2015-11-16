package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.SaldoInsuficienteException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class Saque implements TransacaoCommand {

	private Date data;
	private Conta conta;
	private double valor;
	
	public Saque(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.conta = transacaoBancaria.getContaOrigem();
		this.valor = transacaoBancaria.getValor();
	}
	
	@Override
	public void executar() {
		try {
			conta.decrementar(valor);;
			this.conta.addTransacao(this); 
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}			
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Saque            " + valor + "\n";
	}

}
