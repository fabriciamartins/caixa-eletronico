package br.edu.facisa.caixa.adapter;

public class MaquinaBradesco extends MaquinaGenericaDeBancos {
	
	public static MaquinaBradesco instance = new MaquinaBradesco();
	
	private MaquinaBradesco() {
		super.telaInicial = "BEM-VINDO AO BRADESCO S/A\n - Informe a sua conta: ";
		
	}
}
