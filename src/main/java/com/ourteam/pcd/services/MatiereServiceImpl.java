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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere saveAndFlush(Matiere arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Matiere arg0) {
		// TODO Auto-generated method stub
		
	}

}
