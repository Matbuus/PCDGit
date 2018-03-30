package com.ourteam.pcd.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Matiere")
public class Matiere {
	
	public Matiere() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idMatiere;
	
	
	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}
	@Column(name="nom", unique=true)
	private String nom;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name="duree")
	private int duree;

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idEnseignant",nullable=false,unique=false)
	Set<Enseignant> enseignants;

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idClasse",nullable=false,unique=false)
	Set<Classe> classes;


	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}


	
	
}
