package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.ResponsableScolarite;


@Repository("responsableScolariteDao")
public interface ResponsableScolariteRepository extends JpaRepository<ResponsableScolarite, String>  {
	public ResponsableScolarite findByCompte(Compte compte);
}