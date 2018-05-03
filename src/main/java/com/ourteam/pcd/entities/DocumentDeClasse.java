package com.ourteam.pcd.entities;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ourteam.pcd.entities.Enseignant;



@Entity
@Table(name="DocumentDeClasse")

public class DocumentDeClasse extends Document {
	
	public DocumentDeClasse () {}
	@Column(name="description", nullable = true)
	String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEnseignant",nullable=false,unique=false)
	Enseignant enseignant;

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public DocumentDeClasse(Long id, String nom,Enseignant enseignant, String nomOriginal) {
		super(id, nom, nomOriginal);
		this.enseignant = enseignant;
	} 
	@JsonIgnore
	@OneToMany(mappedBy="documentConcerne", fetch=FetchType.EAGER)
	private Set<Autorisation> autorisations;

	public Set<Autorisation> getAutorisations() {
		return autorisations;
	}

	public void setAutorisations(Set<Autorisation> autorisations) {
		this.autorisations = autorisations;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMatiere",nullable=false,unique=false)
	private Matiere matiereConcernee;

	public Matiere getMatiereConcernee() {
		return matiereConcernee;
	}

	public void setMatiereConcernee(Matiere matiereConcernee) {
		this.matiereConcernee = matiereConcernee;
	}
	
}