package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Classe;


public interface ClasseService {
	
	public List<Classe> findAll();

	public Classe findOne(String arg0);

	public Classe getOne(String arg0);

	public Classe saveAndFlush(Classe arg0);

	public void delete(String arg0);

	public void delete(Classe arg0);

}
