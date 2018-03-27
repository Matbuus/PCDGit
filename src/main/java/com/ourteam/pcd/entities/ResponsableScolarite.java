package com.ourteam.pcd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ResponsableScolarite")

public class ResponsableScolarite extends Utilisateur {
	
	public ResponsableScolarite(String idResponsable,Compte compte, String nom, String prenom, String telephone) {
		super(compte, nom, prenom, telephone);
		this.idResponsable = idResponsable;
	}

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
