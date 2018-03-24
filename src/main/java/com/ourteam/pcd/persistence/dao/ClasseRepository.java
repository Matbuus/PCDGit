package com.ourteam.pcd.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.entities.Classe;


@Repository("classeDao")
public interface ClasseRepository extends JpaRepository<Classe, String>  {
}