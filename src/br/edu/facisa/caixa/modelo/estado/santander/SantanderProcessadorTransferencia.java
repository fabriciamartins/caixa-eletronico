package br.edu.facisa.caixa.modelo.estado.santander;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaSantander;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Transferencia;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class SantanderProcessadorTransferencia implements ProcessadorEstado {
	
	private final String DIGITANDO_CONTA_DESTINO = "Digitando Conta Destino";
	private final String DIGITANDO_VALOR = "Digitando Valor";
	
	private List<EstadoListener> listeners;
	private String estado;
	private String contaDestino;
	private double valorDigitado;
	private Transferencia telaTransferencia = new Transferencia();

	public SantanderProcessadorTransferencia(){
		this.listeners = new ArrayList<>();
		this.estado = DIGITANDO_CONTA_DESTINO;
		this.contaDestino = "";
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		if(estado.equals(DIGITANDO_CONTA_DESTINO)){
			estado = DIGITANDO_VALOR;
		}
		else if((estado.equals(DIGITANDO_VALOR)) && (this.valorDigitado!=0)){
			
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new SantanderProcessadorTransacaoFinalizada());
			}
			
			this.removeEstadoListener(MaquinaSantander.getInstance());
			
			MaquinaSantander.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance()
					.getConta("Santander", MaquinaSantander.getInstance().getContaDigitada()));
			MaquinaSantander.getInstance().getTransacaoBancaria().setContaDestino(Dados.getInstance()
					.getConta("Santander", Integer.valueOf(contaDestino)));
			MaquinaSantander.getInstance().getTransacaoBancaria().setValor(valorDigitado);
			MaquinaSantander.getInstance().getTransacaoBancaria().tranferir();
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new OperacaoSucesso().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		if(estado.equals(DIGITANDO_CONTA_DESTINO)){
			this.contaDestino = "";
			telaTransferencia.setTextContaDestino("");
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}else{
			this.valorDigitado = 0;
			telaTransferencia.setTextValor("");
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCancelarDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
		}
		
		this.removeEstadoListener(MaquinaSantander.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.getInstance().notificaMudanca(evento);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void teclaDireita03Digitada() {
		// TODO Auto-generated method stub

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
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		if(estado.equals(DIGITANDO_CONTA_DESTINO)){
			contaDestino += numTecla;
			telaTransferencia.setTextContaDestino(contaDestino);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}else{
			processaValor(Double.valueOf(numTecla));
			telaTransferencia.setTextValor(String.valueOf(valorDigitado));
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.getInstance().notificaMudanca(evento);
		}
	}

}
