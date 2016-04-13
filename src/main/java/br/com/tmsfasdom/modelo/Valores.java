package br.com.tmsfasdom.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Valores")
public class Valores implements Serializable {

	public static final String tableName = "Valores";
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for autonumber
	private int valorID;
	@Column
	private String valor;
	@ManyToOne(cascade = CascadeType.ALL)
	private Processo processo;
	@ManyToOne(cascade = CascadeType.ALL)
	private Chaves chaves;

	public Valores(String valor) {
		super();
		this.valor = valor;
	}

	public int getValorID() {
		return valorID;
	}

	public void setValorID(int valorID) {
		this.valorID = valorID;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Chaves getChaves() {
		return chaves;
	}

	public void setChaves(Chaves chaves) {
		this.chaves = chaves;
	}

}
