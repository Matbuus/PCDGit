package com.ourteam.pcd.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Autorisation;
import com.ourteam.pcd.entities.Classe;
import com.ourteam.pcd.entities.DocumentDeClasse;


@Repository("autorisationDao")
public interface AutorisationRepository extends JpaRepository<Autorisation,Long>  {
	public List<Autorisation> findByClasseConcernee(Classe classeConcernee);
	public List<Autorisation> findByDocumentConcerne(DocumentDeClasse documentConcerne);
}