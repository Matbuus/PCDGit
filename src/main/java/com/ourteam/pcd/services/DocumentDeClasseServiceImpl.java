package com.ourteam.pcd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Matiere;
import com.ourteam.pcd.persistence.dao.DocumentDeClasseRepository;

@Service
public class DocumentDeClasseServiceImpl implements DocumentDeClasseService {
	@Autowired
	DocumentDeClasseRepository documentDeClasseDao;
	
	@Override
	public List<DocumentDeClasse> findAll() {
		return documentDeClasseDao.findAll();
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
		return documentDeClasseDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(Long arg0) {
	documentDeClasseDao.delete(arg0);
		
	}

	@Override
	public void delete(DocumentDeClasse arg0) {
		try {
		documentDeClasseDao.delete(arg0);	
		} catch(Exception e) {
			
		}
	}
	
	public List<DocumentDeClasse> chercherParNom(String arg0){
		List<DocumentDeClasse> all = this.findAll();
		ArrayList<DocumentDeClasse> res = new ArrayList<>();
		for(int i=0;i<all.size();i++) {
			if(all.get(i).getNomOriginal().contains(arg0))
				res.add(all.get(i));
		}
		String[] words = arg0.split(" ");
		for(int i=0;i<all.size();i++) {
			if(res.contains((DocumentDeClasse)(all.get(i))))
					continue;
			for(int j=0;j< words.length;j++) {
				if(all.get(i).getNomOriginal().contains(words[j]))
					res.add(all.get(i));
			}		
		}		
		return res;
	}


	@Override
	public List<DocumentDeClasse> findByMatiereConcernee(Matiere matiere) {
		return documentDeClasseDao.findByMatiereConcernee(matiere);	
	}
	
	public List<DocumentDeClasse> findByEnseignant(Enseignant enseignant){
		return documentDeClasseDao.findByEnseignant(enseignant);
	}
}
