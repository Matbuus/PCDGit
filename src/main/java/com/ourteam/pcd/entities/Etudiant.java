package com.ourteam.pcd.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Etudiant")
public class Etudiant extends Utilisateur {
	
	public Etudiant() {}
	
	@Id
	@Column(name="numinscription", nullable=false,length=8)
	private String numInscription;

	public String getNumInscription() {
		return numInscription;
	}

	public void setNumInscription(String numInscription) {
		this.numInscription = numInscription;
	}

	public Etudiant(String numInscription, Compte compte, String nom, String prenom, String telephone) {
		super(compte, nom, prenom, telephone);
		this.numInscription=numInscription;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idClasse",nullable=false,unique=true)
	private Set<Classe> classes;

	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}
	

	
	
	
}
