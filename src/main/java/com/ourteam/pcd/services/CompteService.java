package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Utilisateur;


public interface CompteService {
	
	public List<Compte> findAll();

	public Compte findOne(String arg0);

	public Compte getOne(String arg0);

	public Compte saveAndFlush(Compte arg0);

	public void delete(String arg0);

	public void delete(Compte arg0);
	
	public Utilisateur connexion(Compte arg0);

}
