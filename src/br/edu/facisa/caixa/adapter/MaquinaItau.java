package br.edu.facisa.caixa.adapter;

public class MaquinaItau extends MaquinaGenericaDeBancos {
	
	public static MaquinaItau instance = new MaquinaItau();
	
	private MaquinaItau() {
		super.telaInicial = "BEM-VINDO AO ITAU UNIBANCO S/A\n - Informe a sua conta: ";
	}
}
