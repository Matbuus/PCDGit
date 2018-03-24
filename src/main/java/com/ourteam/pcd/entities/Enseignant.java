package com.ourteam.pcd.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Enseignant")
public class Enseignant extends Utilisateur {
	
	public Enseignant() {}
	
	@Id
	@Column(name="idenseignant", nullable=false,length=8)
	private String idEnseignant;

	public String getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(String idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

}
