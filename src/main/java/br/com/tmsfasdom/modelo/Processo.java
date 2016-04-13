package br.com.tmsfasdom.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Processo")
public class Processo implements Serializable {

	public static final String tableName = "Processo";
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int numeroSisPEC;

	public int getNumeroSisPEC() {
		return numeroSisPEC;
	}

	public void setNumeroSisPEC(int numeroSisPEC) {
		this.numeroSisPEC = numeroSisPEC;
	}

	public String getReInteressado() {
		return reInteressado;
	}

	public void setReInteressado(String reInteressado) {
		this.reInteressado = reInteressado;
	}

	public String getNomeInteressado() {
		return nomeInteressado;
	}

	public void setNomeInteressado(String nomeInteressado) {
		this.nomeInteressado = nomeInteressado;
	}

	public List<Valores> getValores() {
		return valores;
	}

	public void setValores(List<Valores> valores) {
		this.valores = valores;
	}

	public Processo(int numeroSisPEC, String reInteressado, String nomeInteressado) {
		super();
		this.numeroSisPEC = numeroSisPEC;
		this.reInteressado = reInteressado;
		this.nomeInteressado = nomeInteressado;
	}

	@Column
	private String reInteressado;
	@Column
	private String nomeInteressado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
	private List<Valores> valores;

}
