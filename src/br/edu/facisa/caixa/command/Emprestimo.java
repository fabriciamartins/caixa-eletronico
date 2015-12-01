package br.edu.facisa.caixa.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.facisa.caixa.exception.LimiteDeCreditoExcedidoException;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class Emprestimo implements TransacaoCommand {

	private Date data;
	private Conta conta;
	private double valor;
	private String mensagem;
	private boolean isValido = false;
	
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
			this.isValido = true;
		} catch (LimiteDeCreditoExcedidoException e) {
			this.isValido = false;
			this.setMensagem(e.getMessage());
		}
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Emprestimo       " + valor + "\n";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isValido() {
		return isValido;
	}

	public void setValido(boolean isValido) {
		this.isValido = isValido;
	}
	
}
