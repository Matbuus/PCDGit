package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.DocumentAdministratif;


public interface DocumentAdministratifService {
	
	public List<DocumentAdministratif> findAll();

	public DocumentAdministratif findOne(Long arg0);

	public DocumentAdministratif getOne(Long arg0);

	public DocumentAdministratif saveAndFlush(DocumentAdministratif arg0);

	public void delete(Long arg0);

	public void delete(DocumentAdministratif arg0);

}
