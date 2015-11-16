package br.edu.facisa.caixa.adapter;

public class MaquinaCaixaEconomica extends MaquinaGenericaDeBancos {
	
	public static MaquinaCaixaEconomica instance = new MaquinaCaixaEconomica();
	
	private MaquinaCaixaEconomica() {
		super.telaInicial = "BEM-VINDO A CAIXA ECON�MICA FEDERAL\n - Informe a sua conta: ";
	}
}
