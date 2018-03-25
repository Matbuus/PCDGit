package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Autorisation;


@Repository("autorisationDao")
public interface AutorisationRepository extends JpaRepository<Autorisation,Long>  {
	
}