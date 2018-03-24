package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Matiere;


public interface MatiereService {
	
	public List<Matiere> findAll();

	public Matiere findOne(String arg0);

	public Matiere getOne(String arg0);

	public Matiere saveAndFlush(Matiere arg0);

	public void delete(String arg0);

	public void delete(Matiere arg0);

}
