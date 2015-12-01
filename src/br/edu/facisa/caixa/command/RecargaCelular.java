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
	private String mensagem;
	private boolean isValido =false;
	
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
			this.isValido = true;
		} catch (SaldoInsuficienteException e) {
			this.isValido = false;
			this.mensagem = e.getMessage();
		}	
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		return formato.format(data) + " Recarga Celular  " + valor + "\n";
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
