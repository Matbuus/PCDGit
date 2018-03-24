package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Etudiant;

@Repository("etudiantDao")
public interface EtudiantRepository extends JpaRepository<Etudiant, String>  {

}
