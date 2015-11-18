package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.enumerador.Operacao;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorDigitandoSenha extends MaquinaAdapter implements ProcessadorEstado{

	private List<EstadoListener> listeners;
	private int senhaDigitada;
	private String asteriscos = "";
	
	public BBProcessadorDigitandoSenha(){
		listeners = new ArrayList<EstadoListener>();
	}
	
	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
	}
	
	@Override
	public void teclaNum01Digitada() {
		processaSenha(1);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
//		processaSenha(1);
//		SantanderDigiteSenha.getInstance().textField.setText(asteriscos);
//		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
//		evento.setNovaTela(SantanderDigiteSenha.getInstance());
//		notificaMudanca(evento);
	}

	@Override
	public void teclaNum02Digitada() {
		processaSenha(2);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum03Digitada() {
		processaSenha(3);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum04Digitada() {
		processaSenha(4);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum05Digitada() {
		processaSenha(5);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum06Digitada() {
		processaSenha(6);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum07Digitada() {
		processaSenha(7);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum08Digitada() {
		processaSenha(8);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum09Digitada() {
		processaSenha(9);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaNum00Digitada() {
		processaSenha(0);
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: " + asteriscos;
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
	}

	@Override
	public void teclaConfirmaDigitada() {
		System.out.println("senha: "+senhaDigitada);
		if (Dados.getInstance().isContaValida("Banco do Brasil", MaquinaBancoBrasil.instance.getContaDigitada(), senhaDigitada)){
			this.senhaDigitada = 0;
			this.asteriscos = "";
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new BBProcessadorEscolhendoTransacao());
			}
			MaquinaBancoBrasil.instance.configurarEvento(exibirTela3(), ESCOLHENDO_TRANSACAO, null);
		} else {
			this.senhaDigitada = 0;
			this.asteriscos = "";
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new BBProcessadorDigitandoConta());
			}
			MaquinaBancoBrasil.instance.configurarEvento("Banco do Brasil", null, Operacao.TROCA_DE_MAQUINA);
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		String msg = " - Continue a digitar a senha ou digite CONFIRMA\n - Senha: ";
		MaquinaBancoBrasil.instance.configurarEvento(msg, DIGITANDO_SENHA, null);
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

}
