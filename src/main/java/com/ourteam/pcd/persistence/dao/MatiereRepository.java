package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Matiere;


@Repository("matiereRepository")
public interface MatiereRepository extends JpaRepository<Matiere, String>  {
}