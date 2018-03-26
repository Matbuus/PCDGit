package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Enseignant;


@Repository("enseignantDao")
public interface EnseignantRepository extends JpaRepository<Enseignant, String>  {
	public Enseignant findByCompte(Compte compte);
}