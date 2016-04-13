/*package br.com.tmsfasdom.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Chaves")
public class Chaves implements Serializable {

	public static final String tableName = "Chaves";
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for autonumber
	private int chaveID;
	@Column
	private String nomeChave;
	@Column
	private String tipoChave;
	@OneToMany(cascade = CascadeType.ALL ,  mappedBy  = "chaves") 
	private List<Valores> valores;

	public String getNomeChave() {
		return nomeChave;
	}

	public void setNomeChave(String nomeChave) {
		this.nomeChave = nomeChave;
	}

	public String getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(String tipoChave) {
		this.tipoChave = tipoChave;
	}

	public List<Valores> getValores() {
		return valores;
	}

	public void setValores(List<Valores> valores) {
		this.valores = valores;
	}

	public Chaves(String nomeChave, String tipoChave) {
		super();
		this.nomeChave = nomeChave;
		this.tipoChave = tipoChave;
	}

}
*/