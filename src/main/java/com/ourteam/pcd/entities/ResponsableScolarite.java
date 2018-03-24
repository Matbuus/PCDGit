package com.ourteam.pcd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ResponsableScolarite")

public class ResponsableScolarite extends Utilisateur {
	
	public ResponsableScolarite() {}
	
	@Id
	@Column(name="idResponsable", nullable=false,length=8)
	private String idResponsable;

	public String getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(String idResponsable) {
		this.idResponsable = idResponsable;
	}
	
}
