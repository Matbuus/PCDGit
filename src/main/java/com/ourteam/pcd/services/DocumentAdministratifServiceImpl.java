package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.DocumentAdministratif;
import com.ourteam.pcd.persistence.dao.DocumentAdministratifRepository;

@Service
public class DocumentAdministratifServiceImpl implements DocumentAdministratifService {

	@Autowired
	DocumentAdministratifRepository documentAdministratifDao;
	
	@Override
	public List<DocumentAdministratif> findAll() {
		return documentAdministratifDao.findAll();
	}

	@Override
	public DocumentAdministratif findOne(Long arg0) {
		return documentAdministratifDao.findOne(arg0);
	}

	@Override
	public DocumentAdministratif getOne(Long arg0) {
		return documentAdministratifDao.getOne(arg0);
	}

	@Override
	public DocumentAdministratif saveAndFlush(DocumentAdministratif arg0) {
		return documentAdministratifDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(Long arg0) {
		documentAdministratifDao.delete(arg0);
		
	}

	@Override
	public void delete(DocumentAdministratif arg0) {
		documentAdministratifDao.delete(arg0);	
	}

}
