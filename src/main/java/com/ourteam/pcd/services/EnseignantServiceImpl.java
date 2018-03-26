package com.ourteam.pcd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.persistence.dao.EnseignantRepository;

@Service
public class EnseignantServiceImpl implements EnseignantService {
	@Autowired
	EnseignantRepository enseignantDao;
	
	@Override
	public List<Enseignant> findAll() {
		return enseignantDao.findAll();
	}

	@Override
	public Enseignant findOne(String arg0) {
		return enseignantDao.findOne(arg0);
	}

	@Override
	public Enseignant getOne(String arg0) {
		return enseignantDao.getOne(arg0);
	}

	@Override
	public Enseignant saveAndFlush(Enseignant arg0) {
		return enseignantDao.saveAndFlush(arg0);
	}

	@Override
	public void delete(String arg0) {
		enseignantDao.delete(arg0);
	}

	@Override
	public void delete(Enseignant arg0) {
		enseignantDao.delete(arg0);		
	}
	
	public List<Enseignant> chercherParNom(String arg0){
		List<Enseignant> all = this.findAll();
		ArrayList<Enseignant> res = new ArrayList<>();
		for(int i=0;i<all.size();i++) {
			if(all.get(i).getNom().contains(arg0))
				res.add(all.get(i));
		}
		String[] words = arg0.split(" ");
		for(int i=0;i<all.size();i++) {
			if(res.contains((Enseignant)(all.get(i))))
					continue;
			for(int j=0;j< words.length;j++) {
				if(all.get(i).getNom().contains(words[j]))
					res.add(all.get(i));
			}		
		}		
		return res;
	}

}
