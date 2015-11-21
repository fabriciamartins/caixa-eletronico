package br.edu.facisa.caixa;

import br.edu.facisa.caixa.gui.Tela;
import br.edu.facisa.caixa.listener.CaixaEletronico;

public class Main {
	
	public static void main(String[] args) {
		Tela home = Tela.instance;
		CaixaEletronico caixa = new CaixaEletronico();
		home.setVisible(true);
		caixa.iniciaOperacoes();
		
	}
	
}
