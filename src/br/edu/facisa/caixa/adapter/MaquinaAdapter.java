package br.edu.facisa.caixa.adapter;

import java.util.LinkedList;
import java.util.List;

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
	
	}
	
	
}
