package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.BloquearCartao;
import br.edu.facisa.caixa.gui.Deposito;
import br.edu.facisa.caixa.gui.Emprestimo;
import br.edu.facisa.caixa.gui.Extrato;
import br.edu.facisa.caixa.gui.Pagamentos;
import br.edu.facisa.caixa.gui.Recarga;
import br.edu.facisa.caixa.gui.Saque;
import br.edu.facisa.caixa.gui.Transferencia;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class SantanderProcessadorEscolhendoTransacao extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	
	public SantanderProcessadorEscolhendoTransacao() {
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
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setTrocaMaquinaDeEstados("Maquina Primaria");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaEsquerda01Digitada() {
		// empréstimo
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorEmprestimo());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaEmprestimo = new Emprestimo().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaEsquerda02Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorPagamentos());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaPagamentos = new Pagamentos().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaPagamentos, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaEsquerda03Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorRecarga());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaRecarga = new Recarga().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaRecarga, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaEsquerda04Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorTransferencia());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaTransferencia = new Transferencia().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaTransferencia, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita01Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorSaque());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaSaque = new Saque().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSaque, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita02Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorExtrato());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaSantander.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Santander", MaquinaSantander.getInstance().getContaDigitada()));
		
		Extrato telaExtrato = new Extrato();
		telaExtrato.txtpnLoremIpsum.setText(MaquinaSantander.getInstance().getTransacaoBancaria().consultarExtrato());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaExtrato.getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita03Digitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorRealizandoDeposito());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Deposito().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaDireita04Digitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorBloquearCartao());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		JPanel telaBloquearCartao = new BloquearCartao().getPanel();
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaBloquearCartao, "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
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
