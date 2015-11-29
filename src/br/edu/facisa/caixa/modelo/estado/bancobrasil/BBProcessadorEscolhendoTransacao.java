package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.BloquearCartao;
import br.edu.facisa.caixa.gui.Deposito;
import br.edu.facisa.caixa.gui.Emprestimo;
import br.edu.facisa.caixa.gui.Extrato;
import br.edu.facisa.caixa.gui.Pagamentos;
import br.edu.facisa.caixa.gui.Saque;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;
import br.edu.facisa.caixa.modelo.estado.bancobrasil.BBProcessadorSaque;

public class BBProcessadorEscolhendoTransacao extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	
	public BBProcessadorEscolhendoTransacao() {
		listeners = new ArrayList<EstadoListener>();
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
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorRealizandoEmprestimo());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Emprestimo().getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaEsquerda02Digitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorRealizandoPagamento());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Pagamentos().getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		
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
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorSaque());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		JPanel telaSaque = new Saque().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSaque, new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
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
		evento.setNovaTela(telaExtrato.getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita03Digitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorRealizandoDeposito());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Deposito().getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaDireita04Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorBloquearCartao());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		JPanel telaBloquearCartao = new BloquearCartao().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaBloquearCartao, new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
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

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		// TODO Auto-generated method stub
		
	}

}
