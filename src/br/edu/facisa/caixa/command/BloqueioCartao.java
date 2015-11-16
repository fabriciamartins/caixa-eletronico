package br.edu.facisa.caixa.command;

import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Conta;

public class BloqueioCartao implements TransacaoCommand {

	private Conta conta;

	public BloqueioCartao(TransacaoBancariaFacade transacaoBancaria) {
		conta = transacaoBancaria.getContaOrigem();
	}

	@Override
	public void executar() {
		conta.getCartao().setBloqueado(true);
	}

}
