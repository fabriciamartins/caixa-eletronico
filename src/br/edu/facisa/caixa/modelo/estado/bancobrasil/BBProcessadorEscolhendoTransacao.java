package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.Deposito;
import br.edu.facisa.caixa.gui.Extrato;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorEscolhendoTransacao extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	
	public BBProcessadorEscolhendoTransacao() {
		listeners = new ArrayList<EstadoListener>();
	}

	@Override
	public void teclaNum01Digitada() {

	}

	@Override
	public void teclaNum02Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum04Digitada() {

	}

	@Override
	public void teclaNum05Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum06Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum07Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum08Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum09Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum00Digitada() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda01Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda02Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda04Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita01Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita02Digitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorExtrato());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada()));
		
		Extrato telaExtrato = new Extrato();
		telaExtrato.txtpnLoremIpsum.setText(MaquinaBancoBrasil.getInstance().getTransacaoBancaria().consultarExtrato());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaExtrato.getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita03Digitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorRealizandoDeposito());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Deposito().getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaDireita04Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}


	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

}
