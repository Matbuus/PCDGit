package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.persistence.dao.DocumentDeClasseRepository;

@Service
public class DocumentDeClasseServiceImpl implements DocumentDeClasseService {
	@Autowired
	DocumentDeClasseRepository documentDeClasseDao;
	
	@Override
	public List<DocumentDeClasse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDeClasse findOne(Long arg0) {
		return documentDeClasseDao.findOne(arg0);
	}

	@Override
	public DocumentDeClasse getOne(Long arg0) {
		return documentDeClasseDao.getOne(arg0);
	}

	@Override
	public DocumentDeClasse saveAndFlush(DocumentDeClasse arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DocumentDeClasse arg0) {
		// TODO Auto-generated method stub
		
	}

}
