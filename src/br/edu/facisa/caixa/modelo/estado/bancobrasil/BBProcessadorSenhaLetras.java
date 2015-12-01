package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.BloquearCartaoFinalizado;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.SenhaLetras;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class BBProcessadorSenhaLetras extends MaquinaAdapter implements ProcessadorEstado{
	
	private List<EstadoListener> listeners;
	private SenhaLetras telaSenhaLetras = new SenhaLetras();
	private List<String> letrasEscolhidas;
	private String astericos = "";
	private String letrasSenha = "";
	
	public BBProcessadorSenhaLetras(){
		this.listeners = new ArrayList<EstadoListener>();
		this.letrasEscolhidas = new ArrayList<String>();
	}
	
	private void processaSenha(String letras) {
		this.letrasEscolhidas.add(letras);
		this.astericos += "*";
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaConfirmaDigitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaCancelarDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new ProcessadorEstadoInicial());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaEsquerda01Digitada() {
		String letras = this.telaSenhaLetras.esquerda01.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}

	}

	@Override
	public void teclaEsquerda02Digitada() {
		String letras = this.telaSenhaLetras.esquerda02.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
	}

	@Override
	public void teclaEsquerda03Digitada() {
		String letras = this.telaSenhaLetras.esquerda03.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
		
	}

	@Override
	public void teclaEsquerda04Digitada() {
		String letras = this.telaSenhaLetras.esquerda04.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
	}

	@Override
	public void teclaDireita01Digitada() {
		String letras = this.telaSenhaLetras.direita01.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
	}

	@Override
	public void teclaDireita02Digitada() {
		String letras = this.telaSenhaLetras.direita02.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
	}

	@Override
	public void teclaDireita03Digitada() {
		String letras = this.telaSenhaLetras.direita03.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
	}

	@Override
	public void teclaDireita04Digitada() {
		String letras = this.telaSenhaLetras.direita04.getText();
		Dados.getInstance().addSenhaLetras(letras);
		processaSenha(letras);
		telaSenhaLetras.textField.setText(this.astericos);
		if(this.letrasEscolhidas.size() == 3){
			confirmarSenha();
		}
		
	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

	public SenhaLetras getTelaSenhaLetras() {
		return telaSenhaLetras;
	}

	public void setTelaSenhaLetras(SenhaLetras telaSenhaLetras) {
		this.telaSenhaLetras = telaSenhaLetras;
	}
	
	public void confirmarSenha(){
		int contSenhaCorreta = 0;
		@SuppressWarnings("unused")
		boolean senhaValida = true;
		
		String[] letrasSenha = Dados.getInstance()
				.getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance()
						.getSenhaDigitada()).getSenhaLetras().split("");
		
		for(String letra : this.letrasEscolhidas){
			String[] letras = letra.split("-");

			for(int i=0; i < 3; i++){
				if(letrasSenha[contSenhaCorreta].equals(letras[i])){
					senhaValida = true;
					this.letrasSenha+=letras[i];
					break;
				}else{
					senhaValida = false;
				}
			}
			
			contSenhaCorreta += 1;
			
		}
		
		if(Dados.getInstance().isContaValida("Banco do Brasil", MaquinaBancoBrasil.getInstance()
				.getContaDigitada(), MaquinaBancoBrasil.getInstance().getSenhaDigitada(), this.letrasSenha)){
			telaSucesso();
		}else{
			telaFracasso();
		}
	}

	public void telaSucesso(){
		
			this.astericos = "";
			this.letrasEscolhidas.clear();
			this.letrasSenha = "";
			
			for(EstadoListener listener : this.listeners){
				listener.estadoAcabou(new BBProcessadorEscolhendoTransacao());
			}
			
			this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_BB());
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);

	}
	
	public void telaFracasso(){
		this.astericos = "";
		this.letrasEscolhidas.clear();
		this.letrasSenha = "";
		
		for(EstadoListener listener : this.listeners){
			listener.estadoAcabou(new BBProcessadorCartaoBloqueado());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new BloquearCartaoFinalizado("Senha Inválida").getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}
	
}
