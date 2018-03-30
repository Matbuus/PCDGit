package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Compte;


@Repository("compteDao")
public interface CompteRepository extends JpaRepository<Compte, String>  {
}