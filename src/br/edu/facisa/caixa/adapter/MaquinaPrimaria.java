package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstadoInicial;

public class MaquinaPrimaria extends MaquinaAdapter implements EstadoListener{

	//private static final String PARADO = null;
	public static MaquinaPrimaria instance = new MaquinaPrimaria();
	private ProcessadorEstado processadorEstado;
	
	private MaquinaPrimaria(){
		processadorEstado = new ProcessadorEstadoInicial();
		processadorEstado.addEstadoListener(this);
	}

	public void iniciar() {
		/*MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Escolha uma opção:\n1) Realizar Deposito\n2) Escolher Banco\n3) Inserir Cartão");
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);*/
		configurarEvento(exibirTela1(), ESTADO_INICIAL, null);
	}

	/*public void para() {
		this.estado = PARADO;
	}*/	

	public void teclaNum01Digitada() {
		processadorEstado.teclaNum01Digitada();
		/*if (this.estado.equals(ESCOLHENDO_TRANSACAO)) {
			this.estado = REALIZANDO_DEPOSITO;
			this.setEvent("Santander", this.estado, null);			
		}*/
	}
	
	public void teclaNum02Digitada() {
		processadorEstado.teclaNum02Digitada();
//		if (estado.equals(ESTADO_INICIAL)) {
//			/*MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
//			e.setNovaTela("Escolha uma opcao: \n1) Banco do Brasil \n2) Santander \n3) Caixa Economica \n4) Bradesco \n5) Itau ");
//			this.estado = ESCOLHENDO_BANCO;
//			notificaMudanca(e);*/
//			configurarEvento(exibirTela2(), ESCOLHENDO_BANCO, null);
//		} else if (this.estado == ESCOLHENDO_BANCO) {
//			/*MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
//			e.setTrocaMaquinaDeEstados("Santander");
//			notificaMudanca(e);*/
//			configurarEvento("Santander", this.estado, Operacao.TROCA_DE_MAQUINA);
//		}
	}

	@Override
	public void teclaNum03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaNum04Digitada() {
		// TODO Auto-generated method stub
		
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
	public void estadoAcabou(ProcessadorEstado novoEstado) {
		processadorEstado = novoEstado;
		processadorEstado.addEstadoListener(this);
	}

}
