package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.SaldoInsuficienteException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Celular;
import br.edu.facisa.caixa.modelo.Conta;

public class RecargaCelular implements TransacaoCommand {

	private Date data;
	private Celular celular;
	private Conta conta;
	private double valor;
	
	public RecargaCelular(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.celular = transacaoBancaria.getCelular();
		this.conta = transacaoBancaria.getContaOrigem();
		this.valor = transacaoBancaria.getValor();
	}
	
	@Override
	public void executar() {
		try {
			conta.decrementar(valor);
			celular.setRecarregado(true);
			this.conta.addTransacao(this);			
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Recarga Celular  " + valor + "\n";
	}

}
