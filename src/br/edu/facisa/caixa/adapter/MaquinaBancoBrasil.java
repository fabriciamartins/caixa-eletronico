package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.modelo.estado.bancobrasil.BBProcessadorDigitandoConta;

public class MaquinaBancoBrasil extends MaquinaGenericaDeBancos {
	
	public static MaquinaBancoBrasil instance = new MaquinaBancoBrasil();
	
	private MaquinaBancoBrasil() {
		super.telaInicial = "BEM-VINDO AO BANCO DO BRASIL S/A\n - Informe a sua conta: ";
		super.processadorEstado = new BBProcessadorDigitandoConta();
		super.processadorEstado.addEstadoListener(this);
	}

}
