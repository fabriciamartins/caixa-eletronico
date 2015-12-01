package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.SaldoInsuficienteException;
import br.edu.facisa.caixa.exception.TituloVencidoException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Titulo;

public class PagamentoTitulo implements TransacaoCommand {

	private Date data;
	private Titulo titulo;
	private Conta conta;
	private double valor;
	
	public PagamentoTitulo(TransacaoBancariaFacade transacaoBancaria) {
		this.data = new Date();
		this.titulo = transacaoBancaria.getTitulo();
		this.conta = transacaoBancaria.getContaOrigem();
		this.valor = transacaoBancaria.getValor();
	}
	
	@Override
	public void executar() {
		try {
			if (!isVencido()) {
				conta.decrementar(valor);
				conta.addTransacao(this);
			}			
		} catch (SaldoInsuficienteException | TituloVencidoException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private boolean isVencido() throws TituloVencidoException {

		if (data.before(titulo.getVencimento())) {
			return false;
		} else {
			throw new TituloVencidoException();
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Pagamento Título " + valor + "\n";
	}

}
