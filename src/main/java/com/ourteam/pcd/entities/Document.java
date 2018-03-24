package com.ourteam.pcd.entities;

import javax.persistence.*;

@MappedSuperclass
@Table(name="Document")
public class Document {
	
	public Document () {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name="nom",nullable=false,unique=false)
		protected String nom;
	
	public Long getId() {
		return id;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}