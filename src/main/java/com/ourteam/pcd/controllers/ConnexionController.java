package com.ourteam.pcd.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Utilisateur;
import com.ourteam.pcd.services.CompteService;

// Controlleur qui permet la connexion, enregistre les informations de la personne qui se connecte
// dans des variables de session, pour pouvoir identifier le type de l'utilisateur, son nom et son mail.
// Utilisation de session comme paramètre des requetes pour pouvoir y enregistrer des attributs.

@RestController
@Transactional
@RequestMapping("")
public class ConnexionController {
	@Autowired
	private CompteService compteService;
	Utilisateur user = null;
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	@CrossOrigin
	public Utilisateur connexion(HttpSession session,@RequestBody final Compte compte) throws Exception {
		
		String USER_MAIL; // Attribut contenant l'email de l'utilisateur connecté
		String USER_NAME; // Attribut contenant le nom de l'utilisateur connecté 
		String USER_TYPE; // Attribut contenant le type de l'utilisateur connecté 
		System.out.println(compte.getEmail()+ " "+ compte.getPassword());
		if(session.getAttribute("Compte") != null) {
			
			// Si cet attribut est non nul, cela signifie qu'il y a deja une personne connectée
			
			System.out.println("Vous êtes déjà connecté ! ");
			return null;
		}
		
		// Initialisation d'un nouvel utilisateur connecté 
		
		 user = compteService.connexion(compte);
		
		// Si user est non nul, cela signifie que ce compte existe bel et bien 
		
		if(user != null) {
			
			// Remplissage des attributs:
			
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
			
			// Enregistrement des attributs comme étant attributs de la session en cours:
			session.setAttribute("Compte", compte);
			session.setAttribute("USER_MAIL", USER_MAIL);
			session.setAttribute("USER_NAME", USER_NAME);
			session.setAttribute("USER_TYPE", USER_TYPE);
	
			
			
			System.out.println("CONNEXION EFFECTUEE AVEC SUCCES");
			return user;
		}
		// Si user est nul, cela signifie que le compte n'existe pas
		else { System.out.println("COMPTE INEXISTANT"); return null; }
		
		
	}
	
	
	// Test pour verifier le fonctionnement des attributs de session, etc.
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	@CrossOrigin
	public void pageDeConnexion(HttpSession session) throws Exception {
		System.out.println("SALUT TOI");
		if(session.getAttribute("Compte") == null) {
			session.setAttribute("USER_MAIL", null);
			session.setAttribute("USER_NAME", null);
			session.setAttribute("USER_TYPE", null);
			System.out.println("PAGE DE CONNEXION !");
		}
		else System.out.println("Vous êtes déjà connecté!");
	}
	
	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET, headers = "Accept=application/json")
	@CrossOrigin
	public Utilisateur pageDeDeconnexion(HttpSession session) throws Exception {
		session.setAttribute("Compte", null);
		session.setAttribute("USER_MAIL", null);
		session.setAttribute("USER_NAME", null);
		session.setAttribute("USER_TYPE", null);
		System.out.println("Vous êtes déconnecté.");
		return user;
	}
}
