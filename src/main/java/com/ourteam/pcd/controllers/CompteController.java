package com.ourteam.pcd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.services.CompteService;
import com.ourteam.pcd.entities.Compte;

@RestController
@RequestMapping("/compte")
public class CompteController {
	@Autowired
	private CompteService compteService;

	@RequestMapping(value = "/creerCompte", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Compte addCompte(@RequestBody final Compte compte) throws Exception {
		System.out.println("POST");
		return compteService.saveAndFlush(compte);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Compte> AfficherAllComptes() throws Exception {
		List<Compte> liste = compteService.findAll();
		if(liste == null) return liste;
		for(int i=0;i<liste.size();i++)
			System.out.println("Email: " + liste.get(i).getEmail() + " | Password: "+ liste.get(i).getPassword());
		return liste;
	}

}
