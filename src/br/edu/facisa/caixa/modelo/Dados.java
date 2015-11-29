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
		if((aux != null)&&(aux.getSenha() == senha && aux.getCartao().isBloqueado() == false)) {
			ok = true;
		}
		return ok;
	}
	
	public Conta validarConta(int numeroCartao){
		for(Banco banco : bancos.values()){
			for(Conta conta : banco.getContas()){
				if(conta.getNumero() == numeroCartao){
					return conta;
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
		Cartao cartao1 = new Cartao(conta1);
		conta1.setCartao(cartao1);
		santander.addContas(conta1);
		Conta conta2 = new Conta();
		conta2.setBanco(santander);
		conta2.setNumero(2);
		conta2.setSenha(2);
		conta2.incrementar(1500.00);
		Cartao cartao2 = new Cartao(conta2);
		conta2.setCartao(cartao2);
		santander.addContas(conta2);
		this.bancos.put(santander.getNome(), santander);
		
		Banco bb = new Banco("Banco do Brasil");
		Conta conta3 = new Conta();
		conta3.setBanco(bb);
		conta3.setNumero(4);
		conta3.setSenha(4);
		Cartao cartao3 = new Cartao(conta3);
		conta3.setCartao(cartao3);
		conta3.incrementar(500.00);
		bb.addContas(conta3);
		Conta conta4 = new Conta();
		conta4.setBanco(bb);
		conta4.setNumero(5);
		conta4.setSenha(5);
		conta4.incrementar(500.00);
		Cartao cartao4 = new Cartao(conta4);
		conta4.setCartao(cartao4);
		bb.addContas(conta4);
		this.bancos.put(bb.getNome(), bb);
	}	

}
