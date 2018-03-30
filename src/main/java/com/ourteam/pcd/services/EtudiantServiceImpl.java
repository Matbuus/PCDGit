package com.ourteam.pcd.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.persistence.dao.CompteRepository;
import com.ourteam.pcd.persistence.dao.EtudiantRepository;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	EtudiantRepository etudiantDao;
	@Autowired
	CompteRepository compteDao;
	
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

	@Override
	public Set<Etudiant> findWithIdList(String[] idEtudiants) {
		Set<Etudiant> res = new HashSet<>();
		for(int i=0;i<idEtudiants.length;i++) {
			res.add(etudiantDao.findOne(idEtudiants[i]));
			System.out.println("Etudiant :::: " + etudiantDao.findOne(idEtudiants[i]).getNom());
		}
		
		return res;
		
	}
	
	@Override
	public Etudiant findByEmail(String email) {
		return etudiantDao.findByCompte(compteDao.findOne(email));
	}

}
