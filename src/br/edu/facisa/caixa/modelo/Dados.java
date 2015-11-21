package br.edu.facisa.caixa.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dados {
	
	private static Dados instance;
	private Map<String, Banco> bancos;
	
	private Dados() {
		bancos = new HashMap<String, Banco>();
		setBancos();
	}
	
	public static Dados getInstance() {
		if (instance == null) {
			instance = new Dados();
		}
		return instance;
	}
	
	public static void setInstance(Dados instance) {
		Dados.instance = instance;
	}

	public Banco getBanco(String key) {
		return bancos.get(key);
	}
	
	public Conta getConta(String key, int num) {
		Conta aux = null;
		List<Conta> contas = bancos.get(key).getContas();
		for (Conta conta : contas) {
			if (conta.getNumero() == num) {
				aux = conta;
			}
		}
		return aux;
	}
	
	public boolean isContaValida(String key, int conta, int senha){
		boolean ok = false;
		Conta aux = getConta(key, conta);
		if((aux != null)&&(aux.getSenha() == senha)) {
			ok = true;
		}
		return ok;
	}
	
	public String validarConta(int numeroCartao){
		for(Banco banco : bancos.values()){
			for(Conta conta : banco.getContas()){
				if(conta.getNumero() == numeroCartao){
					return banco.getNome();
				}
			}
		}
		return null;
	}

	public void setBancos() {
		Banco santander = new Banco("Santander");
		Conta conta1 = new Conta();
		conta1.setBanco(santander);
		conta1.setNumero(1);
		conta1.setSenha(1);
		conta1.incrementar(500.00);
		santander.addContas(conta1);
		Conta conta2 = new Conta();
		conta2.setBanco(santander);
		conta2.setNumero(2);
		conta2.setSenha(2);
		conta2.incrementar(1500.00);
		santander.addContas(conta2);
		this.bancos.put(santander.getNome(), santander);
		
		Banco bradesco = new Banco("Bradesco");
		Conta conta3 = new Conta();
		conta3.setBanco(santander);
		conta3.setNumero(3);
		conta3.setSenha(3);
		conta3.incrementar(1000.00);
		bradesco.addContas(conta3);
		this.bancos.put(bradesco.getNome(), bradesco);
		
		Banco bb = new Banco("Banco do Brasil");
		Conta conta4 = new Conta();
		conta4.setBanco(bb);
		conta4.setNumero(4);
		conta4.setSenha(4);
		conta4.incrementar(500.00);
		bb.addContas(conta4);
		this.bancos.put(bb.getNome(), bb);
	}	

}
