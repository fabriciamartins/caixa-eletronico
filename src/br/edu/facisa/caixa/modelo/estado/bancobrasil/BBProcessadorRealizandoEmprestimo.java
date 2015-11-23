package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.Emprestimo;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorRealizandoEmprestimo extends MaquinaAdapter implements ProcessadorEstado{
	
	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Emprestimo telaEmprestimo = new Emprestimo();
	
	public BBProcessadorRealizandoEmprestimo() {
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}

	@Override
	public void iniciar() {
		
	}

	@Override
	public void teclaNum01Digitada() {
		processaValor(1);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum02Digitada() {
		processaValor(2);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum03Digitada() {
		processaValor(3);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum04Digitada() {
		processaValor(4);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum05Digitada() {
		processaValor(5);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum06Digitada() {
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum07Digitada() {
		processaValor(7);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum08Digitada() {
		processaValor(8);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum09Digitada() {
		processaValor(9);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaNum00Digitada() {
		processaValor(0);
		telaEmprestimo.textValorEmprestimo.setText(String.valueOf(valorDigitado));
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaEmprestimo.getPanel(),"/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
	}

	@Override
	public void teclaConfirmaDigitada() {

		MaquinaBancoBrasil.instance.getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Banco do Brasil", MaquinaBancoBrasil.instance.getContaDigitada()));
		MaquinaBancoBrasil.instance.getTransacaoBancaria().setValor(valorDigitado);
		MaquinaBancoBrasil.instance.getTransacaoBancaria().obterEmprestimo();
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorTransacaoFinalizada());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.instance);
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new OperacaoSucesso().getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
		
	}

	@Override
	public void teclaCorrigeDigitada() {
	}

	@Override
	public void teclaCancelarDigitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorTransacaoFinalizada());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.instance);
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_brasil.jpg");
		MaquinaBancoBrasil.instance.notificaMudanca(evento);
		
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

}
