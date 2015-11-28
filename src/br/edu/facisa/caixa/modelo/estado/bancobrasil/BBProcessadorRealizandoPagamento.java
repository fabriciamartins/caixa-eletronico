package br.edu.facisa.caixa.modelo.estado.bancobrasil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.facisa.caixa.adapter.MaquinaAdapter;
import br.edu.facisa.caixa.adapter.MaquinaBancoBrasil;
import br.edu.facisa.caixa.gui.OperacaoSucesso;
import br.edu.facisa.caixa.gui.Operacoes;
import br.edu.facisa.caixa.gui.Pagamentos;
import br.edu.facisa.caixa.listener.MaquinaDeEstadosEvent;
import br.edu.facisa.caixa.modelo.Dados;
import br.edu.facisa.caixa.modelo.Images;
import br.edu.facisa.caixa.modelo.Titulo;
import br.edu.facisa.caixa.modelo.estado.EstadoListener;
import br.edu.facisa.caixa.modelo.estado.ProcessadorEstado;

public class BBProcessadorRealizandoPagamento extends MaquinaAdapter implements ProcessadorEstado{
	
	private final String DIGITANDO_DATA_VENCIMENTO = "Digitando Data Vencimento";
	private final String DIGITANDO_COD_BARRAS = "Digitando Código de Barras";
	private final String DIGITANDO_VALOR = "Digitando Valor";
	
	private Titulo titulo;
	private String dataVencimento;
	private String codigoDeBarras;
	private double valorDigitado;
	private List<EstadoListener> listeners;
	private Pagamentos telaPagamentos = new Pagamentos();
	
	public BBProcessadorRealizandoPagamento(){
		this.listeners = new ArrayList<EstadoListener>();
		this.estado = DIGITANDO_DATA_VENCIMENTO;
		this.telaPagamentos = new Pagamentos();
		this.titulo = new Titulo();
		this.dataVencimento = "";
		this.codigoDeBarras = "";
		
	}	
	
	public Titulo getTitulo() {
		return titulo;
	}


	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}


	public String getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}


	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}


	public double getValorDigitado() {
		return valorDigitado;
	}


	public void setValorDigitado(double valorDigitado) {
		this.valorDigitado = valorDigitado;
	}


	public List<EstadoListener> getListeners() {
		return listeners;
	}


	public void setListeners(List<EstadoListener> listeners) {
		this.listeners = listeners;
	}


	public Pagamentos getTelaPagamentos() {
		return telaPagamentos;
	}


	public void setTelaPagamentos(Pagamentos telaPagamentos) {
		this.telaPagamentos = telaPagamentos;
	}


	public String getDIGITANDO_DATA_VENCIMENTO() {
		return DIGITANDO_DATA_VENCIMENTO;
	}


	public String getDIGITANDO_COD_BARRAS() {
		return DIGITANDO_COD_BARRAS;
	}


	public String getDIGITANDO_VALOR() {
		return DIGITANDO_VALOR;
	}


	
	
	private void processaValor(double d) {
		this.valorDigitado *= 10;
		this.valorDigitado += d;
	}

	@Override
	public void iniciar() {
		
	}

	@Override
	public void teclaConfirmaDigitada() {

		if(estado.equals(DIGITANDO_DATA_VENCIMENTO) && (this.dataVencimento!="")){
			estado = DIGITANDO_COD_BARRAS;
			setDataVencimento(dataVencimento);
		}
		else if((estado.equals(DIGITANDO_COD_BARRAS)) && (this.codigoDeBarras!="")){
			
			estado = DIGITANDO_VALOR;
			setCodigoDeBarras(codigoDeBarras);
		}else if((estado.equals(DIGITANDO_VALOR)) && (this.valorDigitado!=0)){
			
			for (EstadoListener listener : this.listeners) {
				listener.estadoAcabou(new BBProcessadorTransacaoFinalizada());
			}
			
			this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
			
			MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setContaOrigem(Dados.getInstance()
					.getConta("Banco do Brasil", MaquinaBancoBrasil.getInstance().getContaDigitada()));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dataFormatada;
			
			try {
				String dt = dataVencimento.substring(0,2) + "/" + dataVencimento.substring(2,4) + "/" + dataVencimento.substring(4);
				dataFormatada = formatter.parse(dt);
				titulo.setCodigoDeBarras(codigoDeBarras);
				titulo.setPago(true);
				titulo.setValor(valorDigitado);			
				titulo.setVencimento(dataFormatada);
				Double novoValor = MaquinaBancoBrasil.getInstance().getTransacaoBancaria().getValor() - valorDigitado;
				MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setValor(novoValor);
				MaquinaBancoBrasil.getInstance().getTransacaoBancaria().setTitulo(titulo);
				MaquinaBancoBrasil.getInstance().getTransacaoBancaria().pagarConta();
				/*ATE AQUI*/
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(new OperacaoSucesso().getPanel(), new Images().getPATH_IMG_BB());
				MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void teclaCorrigeDigitada() {
	}

	@Override
	public void teclaCancelarDigitada() {
		
		for (EstadoListener listener : this.listeners) {
			listener.estadoAcabou(new BBProcessadorTransacaoFinalizada());
		}
		
		this.removeEstadoListener(MaquinaBancoBrasil.getInstance());
		
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(new Operacoes().getPanel(), new Images().getPATH_IMG_BB());
		MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
	}

	@Override
	public void teclaEsquerda01Digitada() {
	}

	@Override
	public void teclaEsquerda02Digitada() {
	}

	@Override
	public void teclaEsquerda03Digitada() {
	}

	@Override
	public void teclaEsquerda04Digitada() {
	}

	@Override
	public void teclaDireita01Digitada() {
	}

	@Override
	public void teclaDireita02Digitada() {
		
	}

	@Override
	public void teclaDireita03Digitada() {
		
	}

	@Override
	public void teclaDireita04Digitada() {
		
	}

	@Override
	public void addEstadoListener(EstadoListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeEstadoListener(EstadoListener listener) {
		this.listeners.remove(listener);
		
	}
	

	@Override
	public void teclaNumericaDigitada(String numTecla) {
		if(estado.equals(DIGITANDO_DATA_VENCIMENTO)){
			dataVencimento += numTecla;
			telaPagamentos.textDataVencimento.setText(dataVencimento);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaPagamentos.getPanel(),new Images().getPATH_IMG_BB());
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}else if(estado.equals(DIGITANDO_COD_BARRAS)){
			codigoDeBarras += numTecla;
			telaPagamentos.textCodBarras.setText(codigoDeBarras);
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaPagamentos.getPanel(),new Images().getPATH_IMG_BB());
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}else{
			processaValor(Double.valueOf(numTecla));
			telaPagamentos.textValor.setText((String.valueOf(valorDigitado)));
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(telaPagamentos.getPanel(),new Images().getPATH_IMG_BB());
			MaquinaBancoBrasil.getInstance().notificaMudanca(evento);
		}
	}

}
