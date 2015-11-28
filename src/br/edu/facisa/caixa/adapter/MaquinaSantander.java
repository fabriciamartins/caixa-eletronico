package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.Timeout;
import br.edu.facisa.caixa.modelo.estado.santander.SantanderProcessadorDigitandoSenha;

public class MaquinaSantander extends MaquinaGenericaDeBancos{

	private static MaquinaSantander instance;
	
	private MaquinaSantander() {
		super.processadorEstado = new SantanderProcessadorDigitandoSenha();
		super.processadorEstado.addEstadoListener(this);
	}
	
	public static MaquinaSantander getInstance(){
		if(instance == null){
			instance = new MaquinaSantander();
		}
		return instance;
	}

	@Override
	public void iniciar(){
		new Timeout(this, 100000L, new Runnable(){
			@Override
			public void run() {
				try {					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					//TODO VERIFICAR
				}
			}
		}).start();
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		setContaDigitada(MaquinaPrimaria.getInstance().getContaDigitada());
		evento.setNovaTela(new Senha().getPanel(), new Images().getPATH_IMG_SANTANDER());
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);
	}
	
	@Override
	public void parar(){
		instance = null;
	}

}
