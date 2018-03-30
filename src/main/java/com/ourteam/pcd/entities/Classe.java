package com.ourteam.pcd.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Classe")
public class Classe {
	
	
	public Classe() {}
	
	// Id
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idClasse;
	
	
	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}
	
	// Nom de la classe
	
	@Column(name="nomClasse",unique=true)
	private String nomClasse;

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	// Ensemble des autorisations reçues par la classe 
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="classeConcernee")
	private Set<Autorisation> autorisationsRecues;

	public Set<Autorisation> getAutorisationsRecues() {
		return autorisationsRecues;
	}

	public void setAutorisationsRecues(Set<Autorisation> autorisationsRecues) {
		this.autorisationsRecues = autorisationsRecues;
	}

	// Ensemble des etudiants formant la classe
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "classes")
	private Set<Etudiant> etudiants;


	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "classes")
	private Set<Matiere> matieres;

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	
}
