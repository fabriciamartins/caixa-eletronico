package br.edu.facisa.caixa.adapter;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import br.edu.facisa.caixa.enumerador.Operacao;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosListener;

public abstract class MaquinaAdapter implements IMaquinaDeEstados {

	protected static final String BLOQUEANDO_CARTAO = "Bloqueio Cartao";
	protected static final String CONSULTANDO_EXTRATO = "Extrato";
	protected static final String DIGITANDO_CONTA = "Digitando Conta";
	protected static final String DIGITANDO_SENHA = "Digitando Senha";
	protected static final String ESCOLHENDO_BANCO = "Escolhendo Banco";
	protected static final String ESCOLHENDO_OPCAO = "Escolhendo Opcao";
	protected static final String ESCOLHENDO_TRANSACAO = "Escolhendo Transacao";
	protected static final String ESTADO_INICIAL = "Inicial";
	protected static final String FINALIZANDO_TRANSACAO = "Finalizando Transacao";
	protected static final String REALIZANDO_DEPOSITO = "Deposito";
	protected static final String REALIZANDO_EMPRESTIMO = "Emprestimo";
	protected static final String REALIZANDO_PAGAMENTO = "Pagamento";
	protected static final String REALIZANDO_REGARGA = "Recarga";
	protected static final String REALIZANDO_SAQUE = "Saque";
	protected static final String REALIZANDO_TRANSFERENCIA = "Transferencia";
	
	protected List<MaquinaDeEstadosListener> listeners = new LinkedList<MaquinaDeEstadosListener>();	
	protected String estado;	

	public boolean adicionaMaquinaDeEstadosListener(
			MaquinaDeEstadosListener listener) {
		return this.listeners.add(listener);
	}

	public boolean removeMaquinaDeEstadosListener(
			MaquinaDeEstadosListener listener) {
		return this.listeners.remove(listener);
	}

	public void notificaMudanca(MaquinaDeEstadosEvent evento) {
		for (MaquinaDeEstadosListener listener : listeners) {
			listener.houveMudanca(evento);
		}
	}
	
	public void parar() {
		this.estado = null;
	}
	
	public void configurarEvento(String tela, String estado, Operacao operacao) {
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		this.estado = estado;				
		if (operacao == Operacao.TROCA_DE_MAQUINA) {
			evento.setTrocaMaquinaDeEstados(tela);
		} else {
			evento.setNovaTela(new JPanel());
			evento.setOperacaoHardware(operacao);
		}
		notificaMudanca(evento);
	}
	
	protected String exibirTela1() {
		return "Escolha uma opção:\n"
				+ "1) Inserir Cartão (Em construção)\n"
				+ "2) Escolher Banco";
	}
	
	protected String exibirTela2() {
		return "Escolha uma opcao:\n"
				+ "1) Banco do Brasil\n"
				+ "2) Santander\n"
				+ "3) Caixa Economica\n"
				+ "4) Bradesco\n"
				+ "5) Itau";
	}
	
	protected String exibirTela3() {
		return "Escolha uma das operações:\n"
				+ "1) Deposito\n"
				+ "2) Saque\n"
				+ "3) Transferência\n"
				+ "4) Extrato\n"
				+ "5) Pagamentos\n"
				+ "6) Recarga\n"
				+ "7) Emprestimos\n"
				+ "8) Bloquear Cartão";
	}
	
	protected String exibirTela4() {
		return "Escolha uma opção:\n"
				+ "1) Retorne a tela de seleção de operações\n"
				+ "2) Finalizar sessão";
	}
	
}
