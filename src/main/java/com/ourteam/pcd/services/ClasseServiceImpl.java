package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Classe;
import com.ourteam.pcd.persistence.dao.ClasseRepository;

@Service
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	ClasseRepository classeDao;
	@Override
	public List<Classe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe saveAndFlush(Classe arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Classe arg0) {
		// TODO Auto-generated method stub
		
	}

}
