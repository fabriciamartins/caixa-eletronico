package br.edu.facisa.caixa.listener;

import javax.swing.JPanel;

import br.edu.facisa.caixa.enumerador.Operacao;

public class MaquinaDeEstadosEvent {

	private JPanel novaTela;
	private String pathLogoBando;
	private Operacao operacaoDeHardware;
	private String novaMaquina;

	public void setNovaTela(JPanel tela) {
		this.novaTela = tela;
	}

	public JPanel getNovaTela() {
		return novaTela;
	}

	public void setNovaTela(JPanel tela, String pathLogoBanco) {
		this.novaTela = tela;
		this.pathLogoBando = pathLogoBanco;
	}
	
	public void setPathLogoBanco(String path){
		this.pathLogoBando = path;
	}
	
	public String getPathLogoBanco(){
		return this.pathLogoBando;
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
