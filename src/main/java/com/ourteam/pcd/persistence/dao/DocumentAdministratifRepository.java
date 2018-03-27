package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.DocumentAdministratif;


@Repository("documentAdministratifDao")
public interface DocumentAdministratifRepository extends JpaRepository<DocumentAdministratif, Long>  {
	public DocumentAdministratif findByNomOriginal(String NomOriginal);
}