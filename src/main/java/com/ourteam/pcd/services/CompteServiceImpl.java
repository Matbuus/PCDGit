package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.persistence.dao.CompteRepository;
import com.ourteam.pcd.entities.Compte;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteRepository compteDao;

	@Override
	public List<Compte> findAll() {
		return compteDao.findAll();
	}

	@Override
	public Compte findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte saveAndFlush(Compte arg0) {
		return compteDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(String arg0) {
		compteDao.delete(arg0);
		
	}

	@Override
	public void delete(Compte arg0) {
		try {
		compteDao.delete(arg0);
		} catch (Exception e) {
			System.out.println("Compte Inexistant");
		}
	}


}
