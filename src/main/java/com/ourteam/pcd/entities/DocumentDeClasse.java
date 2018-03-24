package com.ourteam.pcd.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.ourteam.pcd.entities.Enseignant;



@Entity
@Table(name="DocumentDeClasse")

public class DocumentDeClasse extends Document {
	
	public DocumentDeClasse () {}
	
	@ManyToOne
	@JoinColumn(name="idEnseignant",nullable=false,unique=true)
	Enseignant enseignant; 
}