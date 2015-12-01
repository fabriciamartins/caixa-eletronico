package br.edu.facisa.caixa.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSenhaLetras {
	
	List<String> listaLetras;
	Random random = new Random();
	
	public RandomSenhaLetras(){
		this.listaLetras = new ArrayList<String>();
		this.listaLetras.add("Y-C-G-Q");
		this.listaLetras.add("H-M-B-V");
		this.listaLetras.add("A-D-I");
		this.listaLetras.add("E-F-K");
		this.listaLetras.add("U-R-X");
		this.listaLetras.add("J-W-Z");
		this.listaLetras.add("O-P-T");
		this.listaLetras.add("S-N-L");
	}

	public List<String> getListaLetras() {
		return listaLetras;
	}

	public void setListaLetras(List<String> listaLetras) {
		this.listaLetras = listaLetras;
	}
	
	public String getRandomLetra() {
		int index = random.nextInt(this.listaLetras.size());
		return this.listaLetras.remove(index);
	}

}
