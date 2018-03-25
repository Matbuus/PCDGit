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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentAdministratif findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentAdministratif getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentAdministratif saveAndFlush(DocumentAdministratif arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DocumentAdministratif arg0) {
		// TODO Auto-generated method stub
		
	}

}
