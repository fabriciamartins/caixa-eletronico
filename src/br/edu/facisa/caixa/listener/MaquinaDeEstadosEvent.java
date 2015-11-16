package br.edu.facisa.caixa.listener;

import br.edu.facisa.caixa.enumerador.Operacao;

public class MaquinaDeEstadosEvent {

	private String novaTela;
	private Operacao operacaoDeHardware;
	private String novaMaquina;

	public void setNovaTela(String string) {
		this.novaTela = string;
	}

	public String getNovaTela() {
		return novaTela;
	}

	public void setOperacaoHardware(Operacao operacao) {
		this.operacaoDeHardware = operacao;
	}

	public Operacao getOperacaoHardware() {
		return this.operacaoDeHardware;
	}

	public void setTrocaMaquinaDeEstados(String string) {
		this.novaMaquina = string;
	}

	public String getTrocaMaquinaDeEstados() {
		return this.novaMaquina;
	}

}
