package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Autorisation;
import com.ourteam.pcd.persistence.dao.AutorisationRepository;


@Service
public class AutorisationServiceImpl implements AutorisationService {
	@Autowired
	AutorisationRepository autorisationDao;
	
	@Override
	public List<Autorisation> findAll() {
		return autorisationDao.findAll();
	}

	@Override
	public Autorisation findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autorisation getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autorisation saveAndFlush(Autorisation arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Autorisation arg0) {
		// TODO Auto-generated method stub
		
	}

}
