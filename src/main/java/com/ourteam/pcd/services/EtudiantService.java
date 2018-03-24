package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Etudiant;


public interface EtudiantService {
	
	public List<Etudiant> findAll();

	public Etudiant findOne(String arg0);

	public Etudiant getOne(String arg0);

	public Etudiant saveAndFlush(Etudiant arg0);

	public void delete(String arg0);

	public void delete(Etudiant arg0);

}
