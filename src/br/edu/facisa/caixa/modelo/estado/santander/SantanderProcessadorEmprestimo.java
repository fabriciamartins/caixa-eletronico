package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.Emprestimo;
import br.edu.facisa.caixa.gui.OperacaoCancelada;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorEmprestimo extends MaquinaAdapter implements ProcessadorEstado {
	
	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Emprestimo telaEmprestimo = new Emprestimo();
	
	public SantanderProcessadorEmprestimo() {
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}
	
	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void teclaConfirmaDigitada() {

		MaquinaSantander.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Santander", MaquinaSantander.getInstance().getContaDigitada()));
		MaquinaSantander.getInstance().getTransacaoBancaria().setValor(valorDigitado);
		
		if(MaquinaSantander.getInstance().getTransacaoBancaria().obterEmprestimo()){
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new SantanderProcessadorTransacaoFinalizada());
			}
			
			this.removeEstadoListener(MaquinaSantander.getInstance());
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new OperacaoSucesso().getPanel(), new Images().getPATH_IMG_SANTANDER());
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}else{
			for(EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new SantanderProcessadorTransacaoFinalizada());
			}
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new OperacaoCancelada(MaquinaSantander.getInstance().getTransacaoBancaria().getMensagem()).getPanel(), new Images().getPATH_IMG_SANTANDER());
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
		
//		for (EstadoListener listener : this.listeners) {
//			listener.estadoAcabou(new SantanderProcessadorTransacaoFinalizada());
//		}
//		
//		this.removeEstadoListener(MaquinaSantander.getInstance());
//		
//		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
//		evento.setNovaTela(new OperacaoSucesso().getPanel(), new Images().getPATH_IMG_SANTANDER());
//		MaquinaSantander.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaCorrigeDigitada() {
	}

	@Override
	public void teclaCancelarDigitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_SANTANDER());
		MaquinaSantander.getInstance().notificaMudanca(evento);
		
	}

	@Override
	public void teclaEsquerda01Digitada() {
	}

	@Override
	public void teclaEsquerda02Digitada() {
	}

	@Override
	public void teclaEsquerda03Digitada() {
	}

	@Override
	public void teclaEsquerda04Digitada() {
	}

	@Override
	public void teclaDireita01Digitada() {
	}

	@Override
	public void teclaDireita02Digitada() {
		
	}

	@Override
	public void teclaDireita03Digitada() {
		
	}

	@Override
	public void teclaDireita04Digitada() {
		
	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
		
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		processaValor(Integer.valueOf(numTecla));
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(), new Images().getPATH_IMG_SANTANDER());
		MaquinaSantander.getInstance().notificaMudanca(evento);
	}

	

}
