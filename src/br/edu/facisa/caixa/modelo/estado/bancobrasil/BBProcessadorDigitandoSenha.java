package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.BloquearCartao;
import br.edu.facisa.caixa.gui.Deposito;
import br.edu.facisa.caixa.gui.Emprestimo;
import br.edu.facisa.caixa.gui.Extrato;
import br.edu.facisa.caixa.gui.Pagamentos;
import br.edu.facisa.caixa.gui.Recarga;
import br.edu.facisa.caixa.gui.Saque;
import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.gui.Transferencia;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorDigitandoSenha extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	private int senhaDigitada;
	private String asteriscos = "";
	private Senha telaSenha = new Senha();
	private int operacaoEscolhida;
	
	public BBProcessadorDigitandoSenha(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
	}
	
	@Override
	public void teclaConfirmaDigitada() {
		if(Dados.getInstance().isContaValida("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada(), senhaDigitada)){
			MaquinaBancoBrasil.getInstance().setSenhaDigitada(senhaDigitada);
			this.senhaDigitada = 0;
			this.asteriscos = "";
			
			
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			switch (getOperacaoEscolhida()) {
				case 1:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorRealizandoEmprestimo());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Emprestimo().getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 2:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorRealizandoPagamento());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Pagamentos().getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 3:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorRecarga());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Recarga().getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 4:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorTransferencia());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Transferencia().getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 5:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou( new BBProcessadorSaque());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Saque().getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 6:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorExtrato());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					
					MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance().getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada()));
					
					Extrato telaExtrato = new Extrato();
					telaExtrato.txtpnLoremIpsum.setText(MaquinaBancoBrasil.getInstance().getTransacaoBancaria().consultarExtrato());
					
					evento.setNovaTela(telaExtrato.getPanel(), new Images().getPATH_IMG_BB());
					break;
				case 7:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorRealizandoDeposito());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new Deposito().getPanel(), new Images().getPATH_IMG_BB());
					break;
					
				case 8:
					for (EstadoListener listener : this.listeners) {
						listener.estadoAcabou(new BBProcessadorBloquearCartao());
					}
					this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
					evento.setNovaTela(new BloquearCartao().getPanel(), new Images().getPATH_IMG_BB());
					break;
			default:
				break;
			}
			
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}
		else {
			this.senhaDigitada = 0;
			this.asteriscos = "";
			telaSenha.textField.setText(asteriscos);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_BB());
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaCancelarDigitada() {
		//TO DO - voltar a tela anterior
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
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		processaSenha(Integer.valueOf(numTecla));
		telaSenha.textField.setText(asteriscos);
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(telaSenha.getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	public int getOperacaoEscolhida() {
		return operacaoEscolhida;
	}

	public void setOperacaoEscolhida(int operacaoEscolhida) {
		this.operacaoEscolhida = operacaoEscolhida;
	}

}
