package br.com.tmsfasdom.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QRCodes")
public class QRCodes {
	@Id
	@Column
	private
	int Id;
	
	@Column
	private
	String valor;
	
	@Column
	private
	String dados;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}
}
