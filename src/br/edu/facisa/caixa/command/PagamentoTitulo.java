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
	private boolean isValido = false;
	private String mensagem;
	
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
				this.isValido = true;
			}			
		} catch (SaldoInsuficienteException | TituloVencidoException e) {
			this.setMensagem(e.getMessage());
		}	
	}
	
	@SuppressWarnings("deprecation")
	private boolean isVencido() throws TituloVencidoException {
		this.data.setDate((this.data.getDate())-1);

		if (this.data.before(titulo.getVencimento())) {
			return false;
		} else {
			throw new TituloVencidoException();
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Pagamento Título " + valor + "\n";
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
