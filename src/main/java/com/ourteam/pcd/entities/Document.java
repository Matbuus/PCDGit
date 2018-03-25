package com.ourteam.pcd.entities;

import javax.persistence.*;

@MappedSuperclass
@Table(name="Document")
public class Document {
	
	public Document () {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idDocument;
	
	@Column(name="nom",nullable=false,unique=false)
	protected String nom;
	
	public Long getIdDocument() {
		return idDocument;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public Document(Long idDocument, String nom) {
		super();
		this.idDocument = idDocument;
		this.nom = nom;
	}

}