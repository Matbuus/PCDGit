package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ourteam.pcd.persistence.dao.CompteRepository;
import com.ourteam.pcd.persistence.dao.EnseignantRepository;
import com.ourteam.pcd.persistence.dao.EtudiantRepository;
import com.ourteam.pcd.persistence.dao.ResponsableScolariteRepository;
import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Utilisateur;

@Transactional
@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteRepository compteDao;
	@Autowired
	EtudiantRepository etudiantDao;
	@Autowired
	EnseignantRepository enseignantDao;
	@Autowired
	ResponsableScolariteRepository responsableScolariteDao;

	@Override
	public List<Compte> findAll() {
		return compteDao.findAll();
	}

	@Override
	public Compte findOne(String arg0) {
		return compteDao.findOne(arg0);
	}

	@Override
	public Compte getOne(String arg0) {
		return compteDao.getOne(arg0);
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

	public Utilisateur connexion(Compte arg0) {
		Compte compteAVerifier = this.findOne(arg0.getEmail());
		if( compteAVerifier != null) {
			if(compteAVerifier.getPassword().equals(arg0.getPassword()))
			{
				if(responsableScolariteDao.findByCompte(arg0) != null)
					return responsableScolariteDao.findByCompte(arg0);
				else if (enseignantDao.findByCompte(arg0) != null)
					return  enseignantDao.findByCompte(arg0);
				else return etudiantDao.findByCompte(arg0);
			}
			else return null;
		}
		else return null;
	}

}
