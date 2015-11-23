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
	public void teclaNumericaDigitada(String numTecla);
	public void teclaConfirmaDigitada();
	public void teclaCorrigeDigitada();
	public void teclaCancelarDigitada();
	public void teclaEsquerda01Digitada();
	public void teclaEsquerda02Digitada();
	public void teclaEsquerda03Digitada();
	public void teclaEsquerda04Digitada();
	public void teclaDireita01Digitada();
	public void teclaDireita02Digitada();
	public void teclaDireita03Digitada();
	public void teclaDireita04Digitada();
}
