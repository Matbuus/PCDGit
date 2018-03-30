package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Matiere;
import com.ourteam.pcd.persistence.dao.MatiereRepository;

@Service
public class MatiereServiceImpl implements MatiereService {
	@Autowired
	MatiereRepository matiereDao;
	
	@Override
	public List<Matiere> findAll() {
		return matiereDao.findAll();
	}

	@Override
	public Matiere findOne(Long arg0) {
		return matiereDao.findOne(arg0);
	}

	@Override
	public Matiere getOne(Long arg0) {
		return matiereDao.getOne(arg0);
	}

	@Override
	public Matiere saveAndFlush(Matiere arg0) {
		return matiereDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(Long arg0) {
		matiereDao.delete(arg0);
		
	}

	@Override
	public void delete(Matiere arg0) {
		matiereDao.delete(arg0);
		
	}

	
	public Matiere findByNom(String nom) {
		return matiereDao.findByNom(nom);		
	}
}
