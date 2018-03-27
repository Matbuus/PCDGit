package com.ourteam.pcd.entities;


import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="DocumentAdministratif")

public class DocumentAdministratif extends Document {
	

	public DocumentAdministratif(Long id, String nom, String nomOriginal) {
		super(id, nom, nomOriginal);
	}

	public DocumentAdministratif () {}
	
	
	
}