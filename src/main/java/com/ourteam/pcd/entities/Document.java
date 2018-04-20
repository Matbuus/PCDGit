package com.ourteam.pcd.entities;

import javax.persistence.*;

import java.sql.Timestamp;

@MappedSuperclass
@Table(name="Document")
public class Document {
	
	public Document () {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idDocument;
	
	@Column(name="nom",nullable=false,unique=false)
	protected String nom;
	
	@Column(name="nomOriginal",nullable=false,unique=false)
	protected String nomOriginal;
	
	@Column(name="dateDePublication", nullable=false, unique= false)
	protected Timestamp dateDePublication;
	
	@Column(name="titre", nullable=false, unique=false)
	protected String titre;
	

	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Timestamp getDateDePublication() {
		return dateDePublication;
	}


	public void setDateDePublication(Timestamp dateDePublication) {
		this.dateDePublication = dateDePublication;
	}


	public String getNomOriginal() {
		return nomOriginal;
	}


	public void setNomOriginal(String nomOriginal) {
		this.nomOriginal = nomOriginal;
	}


	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}


	public Long getIdDocument() {
		return idDocument;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public Document(Long idDocument, String nom,String nomOriginal) {
		super();
		this.idDocument = idDocument;
		this.nom = nom;
		this.nomOriginal = nomOriginal;
	}

}