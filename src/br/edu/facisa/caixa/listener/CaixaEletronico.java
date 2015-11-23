package br.edu.facisa.caixa.listener;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;
import br.edu.facisa.caixa.gui.Tela;

public class CaixaEletronico implements MaquinaDeEstadosListener {
	
	private List<IMaquinaDeEstados> maquinasDeEstados;
	private IMaquinaDeEstados maquinaPadrao;
	private IMaquinaDeEstados maquinaAtual;
	
	public void iniciaOperacoes() {
		this.maquinasDeEstados = new ArrayList<IMaquinaDeEstados>();
		this.maquinaPadrao = MaquinaDeEstadosFactory.criaMaquinaPrimaria();
		this.maquinaPadrao.adicionaMaquinaDeEstadosListener(this);
		this.maquinaAtual = maquinaPadrao;
		this.maquinaAtual.iniciar();
	}

	public void adicionaMaquinaDeEstados(IMaquinaDeEstados maquina) {
		this.maquinasDeEstados.add(maquina);
	}

	public void houveMudanca(MaquinaDeEstadosEvent mudanca) {
		if (mudanca.getNovaTela() != null) {
			Tela.instance.setTelaAtual(mudanca.getNovaTela(), mudanca.getPathLogoBanco());
		}
		
		if (mudanca.getTrocaMaquinaDeEstados() != null) {
			switch (mudanca.getTrocaMaquinaDeEstados()) {
				case "Maquina Primaria":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaPrimaria();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					Tela.instance.setMaquinaAtual(maquinaAtual);
					this.maquinaAtual.iniciar();
					break;
				case "Santander" :
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaSatander();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					Tela.instance.setMaquinaAtual(maquinaAtual);
					this.maquinaAtual.iniciar();
					break;
				case "Banco do Brasil":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaBancoBrasil();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					Tela.instance.setMaquinaAtual(maquinaAtual);
					this.maquinaAtual.iniciar();
					break;
				default:
					break;
			}
		}

	}

}
