package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.persistence.dao.EtudiantRepository;
import com.ourteam.pcd.entities.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	EtudiantRepository etudiantDao;
	
	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant findOne(String arg0) {
		return etudiantDao.findOne(arg0);
	}

	@Override
	public Etudiant getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant saveAndFlush(Etudiant arg0) {
		return etudiantDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Etudiant arg0) {
		// TODO Auto-generated method stub
		
	}

}
