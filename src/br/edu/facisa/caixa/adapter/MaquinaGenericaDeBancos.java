package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.enumerador.Operacao;
import br.edu.facisa.caixa.facade.TransacaoBancariaFacade;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public abstract class MaquinaGenericaDeBancos extends MaquinaAdapter implements EstadoListener{
	
	private int contaDigitada;
	private int senhaDigitada;
	private double valorDigitado;
	private String asteriscos = "";
	private TransacaoBancariaFacade transacaoBancaria;
	public ProcessadorEstado processadorEstado;
	
	protected String telaInicial;
	
	@Override
	public void estadoAcabou(ProcessadorEstado novoEstado) {
		processadorEstado = novoEstado;
		processadorEstado.addEstadoListener(this);
	}

	public void iniciar() {
		/*this.estado = DIGITANDO_CONTA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("BEM-VINDO AO SANTANDER\n - Informe a sua conta:");
		notificaMudanca(evento);*/
		this.transacaoBancaria = new TransacaoBancariaFacade();
		configurarEvento(telaInicial, DIGITANDO_CONTA, null);
	}
	
	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
		/*MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos);
		notificaMudanca(evento);*/
		configurarEvento(" - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos, this.estado, null);
	}

	private void processaConta(int i) {
		this.contaDigitada *= 10;
		this.contaDigitada += i;
		/*MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada);
		notificaMudanca(evento);*/
		configurarEvento(" - Continue a digitar a conta ou digite CONFIRMA\n - Conta: " + this.contaDigitada, this.estado, null);
	}
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
		/*MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado);
		notificaMudanca(evento);*/
		configurarEvento(" - Continue a digitar o valor ou digite CONFIRMA\n - Valor: " + this.valorDigitado, this.estado, null);
	}

	public void teclaNum01Digitada() {
		processadorEstado.teclaNum01Digitada();
		/*if (this.estado == DIGITANDO_CONTA) {
			processaConta(1);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(1);
		}*/
//		switch (this.estado) {
//		case DIGITANDO_CONTA:
//			processaConta(1);
//			break;
//		case DIGITANDO_SENHA:
//			processaSenha(1);
//			break;
//		case ESCOLHENDO_OPCAO:
//			configurarEvento(exibirTela3(), ESCOLHENDO_TRANSACAO, null);
//			break;
//		case ESCOLHENDO_TRANSACAO:
//			configurarEvento(" - Digite o valor de Depósito - Valor: " + this.valorDigitado, REALIZANDO_DEPOSITO, null);
//			break;
//		case REALIZANDO_DEPOSITO:
//			processaValor(1);
//			break;
//		default:			
//			break;
//		}
	}

	public void teclaNum02Digitada() {
		processadorEstado.teclaNum02Digitada();
//		switch (this.estado) {
//		case DIGITANDO_CONTA:
//			processaConta(2);
//			break;
//		case DIGITANDO_SENHA:
//			processaSenha(2);
//			break;
//		case ESCOLHENDO_OPCAO:
//			this.configurarEvento(exibirTela1(), ESTADO_INICIAL, null);
//			break;
//		}
	}

	public void teclaNum03Digitada() {
		processadorEstado.teclaNum03Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(3);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(3);
//		}
	}

	public void teclaNum04Digitada() {
		processadorEstado.teclaNum04Digitada();
//		switch (this.estado) {
//		case DIGITANDO_CONTA:
//			processaConta(4);
//			break;
//		case DIGITANDO_SENHA:
//			processaSenha(4);
//			break;
//		case ESCOLHENDO_OPCAO:
//			configurarEvento(exibirTela3(), ESCOLHENDO_TRANSACAO, null);
//			break;
//		case ESCOLHENDO_TRANSACAO:
//			transacaoBancaria.setContaOrigem(Dados.getInstance().getConta("Santander", contaDigitada));
//			transacaoBancaria.consultarExtrato();
//			configurarEvento(exibirTela4(), ESCOLHENDO_OPCAO, null);
//			break;
//		}
	}

	public void teclaNum05Digitada() {
		processadorEstado.teclaNum05Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(5);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(5);
//		}
	}

	public void teclaNum06Digitada() {
		processadorEstado.teclaNum06Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(6);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(6);
//		}
	}

	public void teclaNum07Digitada() {
		processadorEstado.teclaNum07Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(7);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(7);
//		}
	}

	public void teclaNum08Digitada() {
		processadorEstado.teclaNum08Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(8);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(8);
//		}
	}

	public void teclaNum09Digitada() {
		processadorEstado.teclaNum09Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(9);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(9);
//		}
	}

	public void teclaNum00Digitada() {
		processadorEstado.teclaNum00Digitada();
//		if (this.estado == DIGITANDO_CONTA) {
//			processaConta(0);
//		} else if (this.estado == DIGITANDO_SENHA) {
//			processaSenha(0);
//		}
	}

	public void teclaConfirmaDigitada() {
		System.out.println(processadorEstado.toString());
		processadorEstado.teclaConfirmaDigitada();
		/*if (this.estado == DIGITANDO_CONTA) {
			this.estado = DIGITANDO_SENHA;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite a senha ou digite CONFIRMA");
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_SENHA) {
			if (DadosFacade.getInstance().validaConta("Santander", contaDigitada, senhaDigitada)) {
				this.estado = ESTADO_INICIAL;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(exibirTela3());
				notificaMudanca(evento);
			} else {
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Santander");
				notificaMudanca(evento);
			}
		}*/		
//		switch (this.estado) {
//		case DIGITANDO_CONTA:
//			this.configurarEvento(" - Digite a senha ou digite CONFIRMA", DIGITANDO_SENHA, null);
//			break;
//		case DIGITANDO_SENHA:
//			if (Dados.getInstance().isContaValida("Santander", contaDigitada, senhaDigitada)) {
//				configurarEvento(exibirTela3(), ESCOLHENDO_TRANSACAO, null);
//			} else {
//				configurarEvento("Santander", null, Operacao.TROCA_DE_MAQUINA);
//			}
//			break;
//		case REALIZANDO_DEPOSITO:
//			configurarEvento(" - Bandeja aberta! Insira o envelope de deposito\n - Digite CONFIRMA para finalizar a transacao", FINALIZANDO_TRANSACAO, Operacao.ABRE_BANDEJA_DEPOSITO);
//			break;
//		case FINALIZANDO_TRANSACAO:
//			transacaoBancaria.setContaOrigem(Dados.getInstance().getConta("Santander", contaDigitada));
//			transacaoBancaria.setValor(valorDigitado);
//			transacaoBancaria.depositar();
//			configurarEvento(" - Deposito realizado com Sucesso!\n" + exibirTela4(), ESCOLHENDO_OPCAO, null);
//			break;
//		case ESCOLHENDO_TRANSACAO:
//			this.configurarEvento(exibirTela3(), this.estado, null);
//			break;
//		default:
//			break;
//		}		
	}
	
	@Override
	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaCancelarDigitada() {
		// TODO Auto-generated method stub
		
	}

	public int getContaDigitada() {
		return contaDigitada;
	}

	public void setContaDigitada(int contaDigitada) {
		this.contaDigitada = contaDigitada;
	}

	public int getSenhaDigitada() {
		return senhaDigitada;
	}

	public void setSenhaDigitada(int senhaDigitada) {
		this.senhaDigitada = senhaDigitada;
	}

	public double getValorDigitado() {
		return valorDigitado;
	}

	public void setValorDigitado(double valorDigitado) {
		this.valorDigitado = valorDigitado;
	}

	public String getAsteriscos() {
		return asteriscos;
	}

	public void setAsteriscos(String asteriscos) {
		this.asteriscos = asteriscos;
	}

	public TransacaoBancariaFacade getTransacaoBancaria() {
		return transacaoBancaria;
	}

	public void setTransacaoBancaria(TransacaoBancariaFacade transacaoBancaria) {
		this.transacaoBancaria = transacaoBancaria;
	}

}
