package br.edu.facisa.caixa.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.facisa.caixa.adapter.IMaquinaDeEstados;
import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;

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
			System.out.println(mudanca.getNovaTela());
		}
		/*else if (mudanca.getOperacaoHardware() != null) {
			if (mudanca.getOperacaoHardware() == Operacao.ABRE_BANDEJA_DEPOSITO) {
				System.out.println("Bandeja aberta.");
			}
		} else*/
		if (mudanca.getTrocaMaquinaDeEstados() != null) {
			switch (mudanca.getTrocaMaquinaDeEstados()) {
				case "Maquina Primaria":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaPrimaria();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				case "Santander" :
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaSatander();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				case "Banco do Brasil":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaBancoBrasil();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				case "Bradesco":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaBradesco();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				case "Itau":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaItau();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				case "Caixa Economica":
					this.maquinaAtual.parar();
					this.maquinaAtual = MaquinaDeEstadosFactory.criaMaquinaCaixaEconomica();
					this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
					this.maquinaAtual.iniciar();
					break;
				default:
					break;
			}
		}
		exibeTeclado();
	}

	private void exibeTeclado() {
		System.out.println(" - Digite: 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, CONFIRMA, CANCELA, CORRIGE e Pressione Enter");
		Scanner teclado = new Scanner(System.in);
		String resposta = teclado.nextLine();
		processaInteracao(resposta.toUpperCase());
	}

	private void processaInteracao(String resposta) {
		if (resposta.equals("1")) {
			this.maquinaAtual.teclaNum01Digitada();
		} else if (resposta.equals("2")) {
			this.maquinaAtual.teclaNum02Digitada();
		} else if (resposta.equals("3")) {
			this.maquinaAtual.teclaNum03Digitada();
		} else if (resposta.equals("4")) {
			this.maquinaAtual.teclaNum04Digitada();
		} else if (resposta.equals("5")) {
			this.maquinaAtual.teclaNum05Digitada();
		} else if (resposta.equals("6")) {
			this.maquinaAtual.teclaNum06Digitada();
		} else if (resposta.equals("7")) {
			this.maquinaAtual.teclaNum07Digitada();
		} else if (resposta.equals("8")) {
			this.maquinaAtual.teclaNum08Digitada();
		} else if (resposta.equals("9")) {
			this.maquinaAtual.teclaNum09Digitada();
		} else if (resposta.equals("0")) {
			this.maquinaAtual.teclaNum00Digitada();
		} else if (resposta.equals("CONFIRMA")) {
			this.maquinaAtual.teclaConfirmaDigitada();
		}
	}

}
