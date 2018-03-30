package com.ourteam.pcd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Classe;
import com.ourteam.pcd.entities.Etudiant;
import com.ourteam.pcd.entities.Matiere;
import com.ourteam.pcd.persistence.dao.ClasseRepository;

@Service
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	ClasseRepository classeDao;
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	MatiereService matiereService;
	
	@Override
	public List<Classe> findAll() {
		return classeDao.findAll();
	}

	@Override
	public Classe findOne(Long arg0) {
		return classeDao.findOne(arg0);
	}

	@Override
	public Classe getOne(Long arg0) {
		return classeDao.getOne(arg0);
	}

	@Override
	public Classe saveAndFlush(Classe arg0) {
		return classeDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(Long arg0) {
		classeDao.delete(arg0);
		
	}

	@Override
	public void delete(Classe arg0) {
		classeDao.delete(arg0);
		
	}

	@Override
	public Classe findByNomClasse(String nomClasse) {
		return classeDao.findByNomClasse(nomClasse);
	}
	
	public void addEtudiantsToClasse(Classe classe, String[] idEtudiants) {
		//classe.getEtudiants().addAll(etudiantService.findWithIdList(idEtudiants));
		for(int i=0;i<idEtudiants.length;i++) {
			Etudiant e = etudiantService.findOne(idEtudiants[i]);
			classe.getEtudiants().add(e);
			boolean exists = false;
			for(Classe cc: e.getClasses()) {
				if(cc.getNomClasse().equals(classe.getNomClasse())){
					exists = true;
					break;
				}
			}
			if(!exists) {
				e.getClasses().add(classe);
				etudiantService.saveAndFlush(e);
			}
		}
		
		this.saveAndFlush(classe);
	}
	public void addMatieresToClasse(Classe classe, String[] idMatieres) {
		for(int i=0;i<idMatieres.length;i++) {
			Matiere matiere = matiereService.findByNom(idMatieres[i]);
			classe.getMatieres().add(matiere);
			boolean exists = false;
			if(matiere.getClasses() == null) {
				System.out.println("SSS");
			}else {
			for(Classe cc: matiere.getClasses()) {
				if(cc.getNomClasse().equals(classe.getNomClasse())){
					exists = true;
					break;
				}
			}
			}
			if(!exists) {
				matiere.getClasses().add(classe);
				matiereService.saveAndFlush(matiere);
			}
		}
		
		this.saveAndFlush(classe);
	}
}
