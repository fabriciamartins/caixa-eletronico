package br.edu.facisa.caixa.adapter;

import br.edu.facisa.caixa.gui.Senha;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Timeout;
import br.edu.facisa.caixa.modelo.estado.santander.SantanderProcessadorDigitandoSenha;

public class MaquinaSantander extends MaquinaGenericaDeBancos{

	public static MaquinaSantander instance = new MaquinaSantander();
	
	private MaquinaSantander() {
		super.processadorEstado = new SantanderProcessadorDigitandoSenha();
		super.processadorEstado.addEstadoListener(this);
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
		setContaDigitada(MaquinaPrimaria.instance.getContaDigitada());
		evento.setNovaTela(new Senha().getPanel(), "/br/edu/facisa/caixa/resource/banco_santander.jpg");
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);
	}
}
