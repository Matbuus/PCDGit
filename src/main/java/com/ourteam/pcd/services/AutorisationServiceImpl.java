package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Autorisation;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.persistence.dao.AutorisationRepository;


@Service
public class AutorisationServiceImpl implements AutorisationService {
	@Autowired
	AutorisationRepository autorisationDao;
	@Autowired
	ClasseService classeService;
	@Autowired
	EnseignantService enseignantService;
	@Autowired
	DocumentDeClasseService documentDeClasseService;
	
	@Override
	public List<Autorisation> findAll() {
		return autorisationDao.findAll();
	}

	@Override
	public Autorisation findOne(Long arg0) {
		return autorisationDao.findOne(arg0);
	}

	@Override
	public Autorisation getOne(Long arg0) {
		return autorisationDao.getOne(arg0);
	}

	@Override
	public Autorisation saveAndFlush(Autorisation arg0) {
		return autorisationDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(Long arg0) {
		autorisationDao.delete(arg0);
	}

	@Override
	public void delete(Autorisation arg0) {
		autorisationDao.delete(arg0);
		
	}
	
	public Autorisation donnerAutorisation(Long idClasse, Long idDocument, Enseignant enseignant) {
		Autorisation autorisation = new Autorisation();
		autorisation.setClasseConcernee(classeService.findOne(idClasse));
		autorisation.setEnseignantResponsable(enseignant);
		autorisation.setDocumentConcerne(documentDeClasseService.findOne(idDocument));
		boolean exists = false;
		for(Autorisation aut: this.findAll()) {
			if(aut.getClasseConcernee().getNomClasse().equals(autorisation.getClasseConcernee().getNomClasse()) && aut.getEnseignantResponsable().getIdEnseignant().equals(autorisation.getEnseignantResponsable().getIdEnseignant()) && aut.getDocumentConcerne().getIdDocument().equals(autorisation.getDocumentConcerne().getIdDocument())) {
				exists = true;
				break;
			}
					
		}
		if(!exists) {
			this.saveAndFlush(autorisation);
			classeService.findOne(idClasse).getAutorisationsRecues().add(autorisation);
			documentDeClasseService.findOne(idDocument).getAutorisations().add(autorisation);
			classeService.saveAndFlush(classeService.findOne(idClasse));
			documentDeClasseService.saveAndFlush(documentDeClasseService.findOne(idDocument));
			
		}
		
		return autorisation;
	}



}
