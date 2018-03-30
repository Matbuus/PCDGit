package com.ourteam.pcd.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Matiere;


@Repository("documentDeClasseDao")
public interface DocumentDeClasseRepository extends JpaRepository<DocumentDeClasse, Long>  {
	public DocumentDeClasse findByNomOriginal(String nomOriginal);
	public List<DocumentDeClasse> findByMatiereConcernee(Matiere matiereConcernee);
	public List<DocumentDeClasse> findByEnseignant(Enseignant enseignant);
}