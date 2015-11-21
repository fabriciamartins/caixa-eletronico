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
	public void teclaNum01Digitada() {
		teclaDigitada("1");
	}

	@Override
	public void teclaNum02Digitada() {
		teclaDigitada("2");
	}

	@Override
	public void teclaNum03Digitada() {
		teclaDigitada("3");
	}

	@Override
	public void teclaNum04Digitada() {
		teclaDigitada("4");
	}

	@Override
	public void teclaNum05Digitada() {
		teclaDigitada("5");
	}

	@Override
	public void teclaNum06Digitada() {
		teclaDigitada("6");
	}

	@Override
	public void teclaNum07Digitada() {
		teclaDigitada("7");
	}

	@Override
	public void teclaNum08Digitada() {
		teclaDigitada("8");
	}

	@Override
	public void teclaNum09Digitada() {
		teclaDigitada("9");
	}

	@Override
	public void teclaNum00Digitada() {
		teclaDigitada("0");
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
			
			this.removeEstadoListener(MaquinaSantander.instance);
			
			MaquinaSantander.instance.getTransacaoBancaria().setContaOrigem(Dados.getInstance()
					.getConta("Santander", MaquinaSantander.instance.getContaDigitada()));
			MaquinaSantander.instance.getTransacaoBancaria().setContaDestino(Dados.getInstance()
					.getConta("Santander", Integer.valueOf(contaDestino)));
			MaquinaSantander.instance.getTransacaoBancaria().setValor(valorDigitado);
			MaquinaSantander.instance.getTransacaoBancaria().tranferir();
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(new OperacaoSucesso().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		if(estado.equals(DIGITANDO_CONTA_DESTINO)){
			this.contaDestino = "";
			telaTransferencia.setTextContaDestino("");
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}else{
			this.valorDigitado = 0;
			telaTransferencia.setTextValor("");
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCancelarDigitada() {
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new SantanderProcessadorEscolhendoTransacao());
		}
		
		this.removeEstadoListener(MaquinaSantander.instance);
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		MaquinaSantander.instance.notificaMudanca(evento);
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
	
	public void teclaDigitada(String tecla) {
		if(estado.equals(DIGITANDO_CONTA_DESTINO)){
			contaDestino += tecla;
			telaTransferencia.setTextContaDestino(contaDestino);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}else{
			processaValor(Double.valueOf(tecla));
			telaTransferencia.setTextValor(String.valueOf(valorDigitado));
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaTransferencia.getPanel(),"/br/edu/facisa/caixa/resource/banco_santander.jpg");
			MaquinaSantander.instance.notificaMudanca(evento);
		}
	}

}
