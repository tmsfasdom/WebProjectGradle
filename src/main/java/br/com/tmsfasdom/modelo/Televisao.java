package br.com.tmsfasdom.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Televisao")

public class Televisao implements Serializable {

	public Televisao() {
	}

	public Televisao(int numeroSerie, String descricao) {
		super();
		this.numeroSerie = numeroSerie;
		Descricao = descricao;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	@Id
	@Column(name = "idTelevisao")
	int numeroSerie;
	
	@Column
	String Descricao;

}
