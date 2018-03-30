package com.ourteam.pcd.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEnseignant",nullable=false,unique=false)
	private Enseignant enseignantResponsable;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDocument",nullable=false,unique=false)
	private DocumentDeClasse documentConcerne;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idClasse", nullable = false, unique=false)
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
