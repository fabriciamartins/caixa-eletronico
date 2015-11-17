package br.edu.facisa.caixa;

import br.edu.facisa.caixa.gui.TelaInicial;

public class Main {
	
	public static void main(String[] args) {
//		CaixaEletronico caixa = new CaixaEletronico();
//		caixa.iniciaOperacoes();
		TelaInicial home = TelaInicial.getInstance();
		home.setVisible(true);
	}
	
}
