package br.com.tmsfasdom.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for autonumber
	private int roleId;

	@Column
	private String name;

	public Role() {
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
