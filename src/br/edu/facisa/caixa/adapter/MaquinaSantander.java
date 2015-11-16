package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.modelo.estado.santander.SandanderProcessadorDigitandoConta;

public class MaquinaSantander extends MaquinaGenericaDeBancos{

	public static MaquinaSantander instance = new MaquinaSantander();
	
	private MaquinaSantander() {
		super.telaInicial = "BEM-VINDO AO SANTANDER S/A\n - Informe a sua conta: ";
		super.processadorEstado = new SandanderProcessadorDigitandoConta();
		super.processadorEstado.addEstadoListener(this);
	}

}
