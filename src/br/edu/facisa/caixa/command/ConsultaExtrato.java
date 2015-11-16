package br.edu.facisa.caixa.command;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class ConsultaExtrato implements TransacaoCommand{

	private Conta conta;
	private List<String> extrato;
	
	public ConsultaExtrato(TransacaoBancariaFacade transacaoBancaria) {
		this.conta = transacaoBancaria.getContaOrigem();
		extrato = new ArrayList<String>();
	}
	
	@Override
	public void executar() {
		for (TransacaoCommand transacao : this.conta.getExtrato()) {
			this.extrato.add(transacao.toString());
		}
		System.out.println(this.toString());
	}
	
	public String toString() {
		String texto = "Extrato da Conta Nº " + conta.getNumero() + "\n";
		for (String string : extrato) {
			texto += string;
		}
		texto += "Saldo: " + conta.getSaldo();
		return texto;
	}

}
