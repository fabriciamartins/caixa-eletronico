package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Timeout;
import br.edu.facisa.caixa.modelo.estado.bancobrasil.BBProcessadorDigitandoSenha;

public class MaquinaBancoBrasil extends MaquinaGenericaDeBancos {
	
	private static MaquinaBancoBrasil instance;
	public static String PATH_IMG_BB = "/br/edu/facisa/caixa/resource/banco_brasil.jpg";
	

	private MaquinaBancoBrasil() {
		super.processadorEstado = new BBProcessadorDigitandoSenha();
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
		evento.setNovaTela(new Senha().getPanel(), PATH_IMG_BB);
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);
	}
	
	@Override
	public void parar(){
		instance = null;
	}

}
