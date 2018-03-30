package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Matiere;


public interface MatiereService {
	
	public List<Matiere> findAll();

	public Matiere findOne(Long arg0);

	public Matiere getOne(Long arg0);

	public Matiere saveAndFlush(Matiere arg0);

	public void delete(Long arg0);

	public void delete(Matiere arg0);
	
	public Matiere findByNom(String nom);

}
