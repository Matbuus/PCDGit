package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.DocumentAdministratif;
import com.ourteam.pcd.entities.DocumentDeClasse;


@Repository("documentDeClasseDao")
public interface DocumentDeClasseRepository extends JpaRepository<DocumentDeClasse, Long>  {
	public DocumentAdministratif findByNomOriginal(String NomOriginal);
}