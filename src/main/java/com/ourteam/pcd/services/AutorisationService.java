package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Autorisation;
import com.ourteam.pcd.entities.Enseignant;


public interface AutorisationService {
	
	public List<Autorisation> findAll();

	public Autorisation findOne(Long arg0);

	public Autorisation getOne(Long arg0);

	public Autorisation saveAndFlush(Autorisation arg0);

	public void delete(Long arg0);

	public void delete(Autorisation arg0);
	
	public Autorisation donnerAutorisation(Long idClasse, Long idDocument, Enseignant enseignant);

}

