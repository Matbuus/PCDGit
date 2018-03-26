package com.ourteam.pcd.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Utilisateur;
import com.ourteam.pcd.services.CompteService;

@RestController
@Transactional
@RequestMapping("")
public class ConnexionController {
	@Autowired
	private CompteService compteService;
	
	// Controlleur qui permet la connexion, enregistre les informations de la personne qui se connecte
	// dans des variables de session, pour pouvoir identifier le type de l'utilisateur, son nom et son mail.
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void connexion(HttpSession session,@RequestBody final Compte compte) throws Exception {
		
		String USER_MAIL;
		String USER_NAME;
		String USER_TYPE;
		if(session.getAttribute("Compte") != null) {
			System.out.println("Vous êtes déjà connecté ! ");
			return ;
		}
		Utilisateur user = compteService.connexion(compte);
		if(user != null) {
			USER_MAIL = compte.getEmail();
			USER_NAME = user.getPrenom()+" "+user.getNom();
			String type = user.getClass().getName();
			if(type.equals("com.ourteam.pcd.entities.Etudiant")) {
				USER_TYPE = "ETUDIANT";
			}
			else if(type.equals("com.ourteam.pcd.entities.Enseignant")) {
				USER_TYPE = "ENSEIGNANT";
			}
			else USER_TYPE = "ADMIN";
			session.setAttribute("USER_MAIL", USER_MAIL);
			session.setAttribute("USER_NAME", USER_NAME);
			session.setAttribute("USER_TYPE", USER_TYPE);
			session.setAttribute("Compte", compte);
			System.out.println("CONNEXION EFFECTUEE AVEC SUCCES");
		}
		else System.out.println("COMPTE INEXISTANT");
		
		
	}
	
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public void pageDeConnexion(HttpSession session) throws Exception {
		if(session.getAttribute("Compte") == null)
		System.out.println("PAGE DE CONNEXION !");
		else System.out.println("Vous êtes déjà connecté!");
	}
}
