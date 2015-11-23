package br.edu.facisa.caixa.factory;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.adapter.MaquinaSantander;

public class MaquinaDeEstadosFactory {

	public static IMaquinaDeEstados criaMaquinaPrimaria() {
		return MaquinaPrimaria.getInstance();
	}
	
	public static IMaquinaDeEstados criaMaquinaSatander() {
		return MaquinaSantander.getInstance();
	}
	
	public static IMaquinaDeEstados criaMaquinaBancoBrasil(){
		return MaquinaBancoBrasil.getInstance();
	}

}
