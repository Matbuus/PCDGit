package com.ourteam.pcd.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.ourteam.pcd.entities.Enseignant;



@Entity
@Table(name="DocumentDeClasse")

public class DocumentDeClasse extends Document {
	
	public DocumentDeClasse () {}
	
	@ManyToOne
	@JoinColumn(name="idEnseignant",nullable=false,unique=true)
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
	
	@OneToMany(mappedBy="documentConcerne")
	private Set<Autorisation> autorisations;

	public Set<Autorisation> getAutorisations() {
		return autorisations;
	}

	public void setAutorisations(Set<Autorisation> autorisations) {
		this.autorisations = autorisations;
	}
	
	
}