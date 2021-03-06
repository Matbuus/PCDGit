package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Matiere;


public interface DocumentDeClasseService {
	
	public List<DocumentDeClasse> findAll();

	public DocumentDeClasse findOne(Long arg0);

	public DocumentDeClasse getOne(Long arg0);

	public DocumentDeClasse saveAndFlush(DocumentDeClasse arg0);

	public void delete(Long arg0);

	public void delete(DocumentDeClasse arg0);
	
	public List<DocumentDeClasse> chercherParNom(String arg0);
	
	public List<DocumentDeClasse> findByMatiereConcernee(Matiere matiere);
	
	public List<DocumentDeClasse> findByEnseignant(Enseignant enseignant);
}
