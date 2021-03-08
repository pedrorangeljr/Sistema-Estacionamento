package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanVeiculo {

	private String veiculo;
	private String placa;
	private Long id;
	
	/*Data direto do sistema usando o codigo java*/
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date dataAtual = new Date();
	String dataFormatada = sdf.format(dataAtual);
	
	/*Horário direto no sistema usando codigo java*/
	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	Date hora = new Date();
	String horaAtual = dateFormat.format(hora);
	
	
	
	public String getHoraAtual() {
		return horaAtual;
	}
	public void setHoraAtual(String horaAtual) {
		this.horaAtual = horaAtual;
	}
	public String getDataFormatada() {
		return dataFormatada;
	}
	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
}
