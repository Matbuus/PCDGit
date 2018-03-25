package com.ourteam.pcd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Autorisation")
public class Autorisation {
	public Autorisation() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idAutorisation;
	
	@ManyToOne
	@JoinColumn(name="idEnseignant",nullable=false,unique=false)
	private Enseignant enseignantResponsable;
	
	
	@ManyToOne
	@JoinColumn(name="idDocument",nullable=false,unique=false)
	private DocumentDeClasse documentConcerne;
	
	@ManyToOne
	@JoinColumn(name="nomClasse", nullable = false, unique=false)
	private Classe classeConcernee;

	public Long getIdAutorisation() {
		return idAutorisation;
	}

	public void setIdAutorisation(Long idAutorisation) {
		this.idAutorisation = idAutorisation;
	}

	public Enseignant getEnseignantResponsable() {
		return enseignantResponsable;
	}

	public void setEnseignantResponsable(Enseignant enseignantResponsable) {
		this.enseignantResponsable = enseignantResponsable;
	}

	public DocumentDeClasse getDocumentConcerne() {
		return documentConcerne;
	}

	public void setDocumentConcerne(DocumentDeClasse documentConcerne) {
		this.documentConcerne = documentConcerne;
	}

	public Classe getClasseConcernee() {
		return classeConcernee;
	}

	public void setClasseConcernee(Classe classeConcernee) {
		this.classeConcernee = classeConcernee;
	}

	
}
