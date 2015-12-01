package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.Timeout;
import br.edu.facisa.caixa.modelo.estado.bancobrasil.BBProcessadorEscolhendoTransacao;

public class MaquinaBancoBrasil extends MaquinaGenericaDeBancos {
	
	private static MaquinaBancoBrasil instance;
	public static String PATH_IMG_BB = "/br/edu/facisa/caixa/resource/banco_brasil.jpg";
	
	private MaquinaBancoBrasil() {
		super.processadorEstado = new BBProcessadorEscolhendoTransacao();
		super.processadorEstado.addEstadoListener(this);
	}
	
	public static MaquinaBancoBrasil getInstance(){
		if(instance == null){
			instance = new MaquinaBancoBrasil();
		}
		return instance;
	}

	public  String getPathImgBb() {
		return PATH_IMG_BB;
	}

	@Override
	public void iniciar(){
		new Timeout(this, 100000L, new Runnable(){
			@Override
			public void run() {
				try {					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}).start();
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		setContaDigitada(MaquinaPrimaria.getInstance().getContaDigitada());
		evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_BB());
		this.estado = ESCOLHENDO_TRANSACAO;
		notificaMudanca(evento);
	}
	
	@Override
	public void parar(){
		instance = null;
	}

}
