package com.ourteam.pcd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.services.AutorisationService;
import com.ourteam.pcd.entities.Autorisation;

@RestController
@Transactional
@RequestMapping("/autorisation")
public class AutorisationController {
	
	@Autowired
	private AutorisationService autorisationService;

	@RequestMapping(value = "/donnerAutorisation", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Autorisation addAutorisation(@RequestBody final Autorisation autorisation) throws Exception {
		System.out.println("POST");
		return autorisationService.saveAndFlush(autorisation);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Autorisation> AfficherAutorisations() throws Exception {
		List<Autorisation> liste = autorisationService.findAll();
		if (liste == null ) return liste;
		for(int i=0;i<liste.size();i++)
			System.out.println("Nom de la classe: " + liste.get(i).getClasseConcernee().getNomClasse() + " | Nom du cours: "+ liste.get(i).getDocumentConcerne().getNom());
		return liste;
	}

}
