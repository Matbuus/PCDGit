package com.ourteam.pcd.services;

import java.util.List;
import com.ourteam.pcd.entities.Enseignant;


public interface EnseignantService {
	
	public List<Enseignant> findAll();

	public Enseignant findOne(String arg0);

	public Enseignant getOne(String arg0);

	public Enseignant saveAndFlush(Enseignant arg0);

	public void delete(String arg0);

	public void delete(Enseignant arg0);
	
	public List<Enseignant> chercherParNom(String arg0);
}
