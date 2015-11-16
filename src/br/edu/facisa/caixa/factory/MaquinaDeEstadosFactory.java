package br.edu.facisa.caixa.factory;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.adapter.MaquinaBradesco;
import br.edu.facisa.caixa.adapter.MaquinaCaixaEconomica;
import br.edu.facisa.caixa.adapter.MaquinaItau;
import br.edu.facisa.caixa.adapter.MaquinaPrimaria;
import br.edu.facisa.caixa.adapter.MaquinaSantander;

public class MaquinaDeEstadosFactory {

	public static IMaquinaDeEstados criaMaquinaPrimaria() {
		return MaquinaPrimaria.instance;
	}
	
	public static IMaquinaDeEstados criaMaquinaSatander() {
		return MaquinaSantander.instance;
	}
	
	public static IMaquinaDeEstados criaMaquinaBancoBrasil(){
		return MaquinaBancoBrasil.instance;
	}
	
	public static IMaquinaDeEstados criaMaquinaBradesco(){
		return MaquinaBradesco.instance;
	}
	
	public static IMaquinaDeEstados criaMaquinaCaixaEconomica(){
		return MaquinaCaixaEconomica.instance;
	}
	
	public static IMaquinaDeEstados criaMaquinaItau(){
		return MaquinaItau.instance;
	}
}
