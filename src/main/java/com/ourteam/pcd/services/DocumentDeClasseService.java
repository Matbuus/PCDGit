package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.DocumentDeClasse;


public interface DocumentDeClasseService {
	
	public List<DocumentDeClasse> findAll();

	public DocumentDeClasse findOne(Long arg0);

	public DocumentDeClasse getOne(Long arg0);

	public DocumentDeClasse saveAndFlush(DocumentDeClasse arg0);

	public void delete(Long arg0);

	public void delete(DocumentDeClasse arg0);

}
