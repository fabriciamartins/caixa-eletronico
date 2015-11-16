package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.LimiteDeCréditoExcedidoException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class Emprestimo implements TransacaoCommand {

	private Date data;
	private Conta conta;
	private double valor;
	
	public Emprestimo(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.conta = transacaoBancaria.getContaOrigem();
		this.valor = transacaoBancaria.getValor();
	}
	
	@Override
	public void executar() {
		try {
			conta.obterEmprestimo(valor);
			conta.incrementar(valor);
			conta.addTransacao(this);
		} catch (LimiteDeCréditoExcedidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Emprestimo       " + valor + "\n";
	}
	
}
