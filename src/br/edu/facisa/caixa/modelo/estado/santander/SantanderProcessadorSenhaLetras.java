package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.BloquearCartaoFinalizado;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.SenhaLetras;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class SantanderProcessadorSenhaLetras extends MaquinaAdapter implements ProcessadorEstado{
	
	private List<EstadoListener> listeners;
	private SenhaLetras telaSenhaLetras = new SenhaLetras();
	private List<String> letrasEscolhidas;
	private String astericos = "";
	private String senha = "";
	
	public SantanderProcessadorSenhaLetras(){
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
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaSantander.getInstance().notificaMudanca(evento);
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
		
		char[] letrasSenha = Dados.getInstance()
				.getConta("Santander", MaquinaSantander.getInstance()
						.getSenhaDigitada()).getSenhaLetras().toCharArray();
		
		for(String letra : this.letrasEscolhidas){
			String[] letras = letra.split("-");

			for(int i=0; i < 3; i++){
				if(letrasSenha[contSenhaCorreta]==(letras[i].charAt(0))){
					senhaValida = true;
					this.senha+=letras[i];
					break;
				}else{
					senhaValida = false;
				}
			}
			
			contSenhaCorreta += 1;
			
		}
		
		if(Dados.getInstance().isContaValida("Santander", MaquinaSantander.getInstance()
				.getContaDigitada(), MaquinaSantander.getInstance().getSenhaDigitada(), this.senha)){
			telaSucesso();
		}else{
			telaFracasso();
		}
	}

	public void telaSucesso(){
		
			this.astericos = "";
			this.letrasEscolhidas.clear();
			this.senha = "";
			
			for(EstadoListener listener : this.listeners){
				listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
			}
			
			this.removeEstadoListener(MaquinaSantander.getInstance());
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_SANTANDER());
			MaquinaSantander.getInstance().notificaMudanca(evento);

	}
	
	public void telaFracasso(){
		this.astericos = "";
		this.letrasEscolhidas.clear();
		this.senha = "";
		
		for(EstadoListener listener : this.listeners){
			listener.estadoAcabou(new SantanderProcessadorCartaoBloqueado());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new BloquearCartaoFinalizado("Senha Inv�lida").getPanel(), new Images().getPATH_IMG_SANTANDER());
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}
	
}
