package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosListener;

public interface IMaquinaDeEstados {

	/* Metodos observer */
	public boolean adicionaMaquinaDeEstadosListener(MaquinaDeEstadosListener listener);
	public boolean removeMaquinaDeEstadosListener(MaquinaDeEstadosListener listener);
	public void notificaMudanca(MaquinaDeEstadosEvent evento);

	/* Metodos da maquina */
	public void iniciar();	
	public void parar();	
	public void teclaNum01Digitada();
	public void teclaNum02Digitada();	
	public void teclaNum03Digitada();	
	public void teclaNum04Digitada();	
	public void teclaNum05Digitada();	
	public void teclaNum06Digitada();	
	public void teclaNum07Digitada();	
	public void teclaNum08Digitada();	
	public void teclaNum09Digitada();
	public void teclaNum00Digitada();
	public void teclaConfirmaDigitada();
	public void teclaCorrigeDigitada();
	public void teclaCancelarDigitada();
	
}
