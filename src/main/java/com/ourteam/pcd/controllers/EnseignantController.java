package com.ourteam.pcd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.services.EnseignantService;
import com.ourteam.pcd.entities.Enseignant;

@RestController
@Transactional
@RequestMapping("/enseignant")
public class EnseignantController {
	@Autowired
	private EnseignantService enseignantService;
	private Enseignant enseignant = null;
	
	
	   @RequestMapping(value="/{id}", method=RequestMethod.GET)
	    public void getDocumentDeClasse(@PathVariable(value="id") String id){
		   	System.out.println("HEREENSEIGNANT");
		   	if(enseignant == null )
		   	enseignant  = enseignantService.findOne(id);
	        System.out.println("Nom de l'enseignant : " + enseignant.getNom());
	    }

}
