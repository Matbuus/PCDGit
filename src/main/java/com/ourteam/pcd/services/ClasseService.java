package com.ourteam.pcd.services;

import java.util.List;

import com.ourteam.pcd.entities.Classe;


public interface ClasseService {
	
	public List<Classe> findAll();

	public Classe findOne(Long arg0);

	public Classe getOne(Long arg0);

	public Classe saveAndFlush(Classe arg0);

	public void delete(Long arg0);

	public void delete(Classe arg0);
	
	public Classe findByNomClasse(String nomClasse);
	
	public void addEtudiantsToClasse(Classe classe, String[] idEtudiants);

	public void addMatieresToClasse(Classe c, String[] idMatieres);

}
