package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.persistence.dao.EnseignantRepository;

@Service
public class EnseignantServiceImpl implements EnseignantService {
	@Autowired
	EnseignantRepository enseignantDao;
	
	@Override
	public List<Enseignant> findAll() {
		return enseignantDao.findAll();
	}

	@Override
	public Enseignant findOne(String arg0) {
		return enseignantDao.findOne(arg0);
	}

	@Override
	public Enseignant getOne(String arg0) {
		return enseignantDao.getOne(arg0);
	}

	@Override
	public Enseignant saveAndFlush(Enseignant arg0) {
		return enseignantDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(String arg0) {
		enseignantDao.delete(arg0);
	}

	@Override
	public void delete(Enseignant arg0) {
		enseignantDao.delete(arg0);		
	}

}
