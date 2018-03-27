package com.ourteam.pcd.controllers;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.DocumentAdministratif;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Etudiant;
import com.ourteam.pcd.services.CompteService;
import com.ourteam.pcd.services.DocumentAdministratifService;
import com.ourteam.pcd.services.EnseignantService;
import com.ourteam.pcd.services.EtudiantService;

// Controlleur des actions de l'admin/responsable scolarité:
// Possibilité de gérer les comptes des utilisateurs et de gerer des documents administratifs 

@RestController
@Transactional
@RequestMapping("/responsable")
public class AdminController {
	
	// Attributs : 
	
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private CompteService compteService;
	@Autowired
	private EnseignantService enseignantService;
	@Autowired 
	private EtudiantService etudiantService;
	@Autowired
	private DocumentAdministratifService documentAdministratifService;
	
	
	// TEST 
	
	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public void pageAdmin(HttpSession session) throws Exception {
		System.out.println("Page de gestion: Admin");
	}
	
	
	//////////////////////////////////////// GESTION COMPTES ///////////////////////////////////////////////////////
	
	// Liste de tous les comptes 
	
	@RequestMapping(value = "/comptes", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Compte> listeDesComptes(HttpSession session) throws Exception {
		return compteService.findAll();
	}
	
	// Ajout de compte : Test 
	
	@RequestMapping(value = "/comptes/add", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public void ajout(HttpSession session) throws Exception {
		System.out.println("Ajouter un compte: ENSEIGNANT | ETUDIANT ");
	}
	
	
	// On envoit un compte et un enseignant sous forme de json 
	// Requete Post pour enregistrer un compte enseignant
	
	@RequestMapping(value = "/comptes/add/enseignant", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void ajouterEnseignant(HttpSession session,@RequestBody ObjectNode json) throws Exception {
		JsonNode compteNode = json.findValue("compte");
		JsonNode enseignantNode = json.findValue("enseignant");
		Compte compte = mapper.treeToValue(compteNode, Compte.class);
		if(compteService.findOne(compte.getEmail()) != null) {
			
			// Verifier que le mail n'est pas utilisé
			
			System.out.println("EMAIL DEJA UTILISE");
		}
		else {
			
			// Si l'email est disponible
			
		Enseignant enseignant = mapper.treeToValue(enseignantNode, Enseignant.class);
		if(enseignantService.findOne(enseignant.getIdEnseignant()) == null) {
			
			// Si l'enseignant n'est pas déjà enregistré
			
			enseignant.setCompte(compte);
			compteService.saveAndFlush(compte);
			enseignantService.saveAndFlush(enseignant);
			System.out.println("Enseignant enregistré avec succès");
		}
		
		// Si l'enseignant est déjà enregistré
		
		else System.out.println("Enseignant déjà inscrit");
		}
	}
	
	
	// On envoit un compte et un etudiant sous forme de json 
	// Requete Post pour enregistrer un compte etudiant
	// Même schema que les comptes enseignants
	
	@RequestMapping(value = "/comptes/add/etudiant", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void ajouterEtudiant(HttpSession session,@RequestBody ObjectNode json) throws Exception {
		JsonNode compteNode = json.findValue("compte");
		JsonNode etudiantNode = json.findValue("etudiant");
		Compte compte = mapper.treeToValue(compteNode, Compte.class);
		if(compteService.findOne(compte.getEmail()) != null) {
			System.out.println("EMAIL DEJA UTILISE");
		}
		else {
		Etudiant etudiant = mapper.treeToValue(etudiantNode, Etudiant.class);
		if(etudiantService.findOne(etudiant.getNumInscription()) == null) {
			etudiant.setCompte(compte);
			compteService.saveAndFlush(compte);
			etudiantService.saveAndFlush(etudiant);
			System.out.println("Etudiant enregistré avec succès");
		}
		else System.out.println("Etudiant déjà inscrit");
		}
	}
	
	// Suppression d'un compte après les avoir listés grace à la requete GET :
	
	@RequestMapping(value = "/comptes/delete/{email}", method = RequestMethod.GET)
    @ResponseBody
    public void supprimerDocument(@PathVariable("email") String email) {
		// Exception au cas ou l'email n'existe pas
		try {
		compteService.delete(email);
		System.out.println("Supprimé avec succès.");
		} catch(Exception e) {	
			System.err.println("Erreur, verifier l'email. ");
		}
    }



	
	///////////////////////////////////////// DOCUMENTS ADMINISTRATIFS ///////////////////////////////////////////////////
	
	// GET POUR TEST: Affichage de tous les documents administratifs publiés: Gestion 
	
	@RequestMapping(value = "/documents", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public void publier(HttpSession session) throws Exception {
		System.out.println("Page de publication de document.");
	}
	
	// Front: Formulaire  ou on met le document à publier. 
	// POST: PUBLICATION D'UN DOCUMENT ADMINISTRATIF:
	
	@RequestMapping(value = "/documents/publier", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	 public ResponseEntity<DocumentAdministratif> upload(@RequestParam("file") MultipartFile inputFile) {
	  // Document qui doit persister
	  DocumentAdministratif documentAdministratifPublie = new DocumentAdministratif(); 
	  HttpHeaders headers = new HttpHeaders();
	  if (!inputFile.isEmpty()) {
	   try {
		   
		   // Nom original du fichier: A utiliser dans les recherches
		   
	    String originalFilename = inputFile.getOriginalFilename();
	    
	    	  // Destination ou enregistrer les fichiers sur le serveur 
	    
	    File destinationFile = new File("/Users/malekattia/Documents/PCD/uploadedfiles/"+ originalFilename+java.sql.Timestamp.valueOf(LocalDateTime.now()));
	    inputFile.transferTo(destinationFile);
	    
	    // Mise en place de notre objet à persister
	    
	    documentAdministratifPublie.setNom(destinationFile.getPath());
	    documentAdministratifPublie.setNomOriginal(originalFilename);
	    documentAdministratifPublie.setDateDePublication(java.sql.Timestamp.valueOf(LocalDateTime.now()));
	    headers.add("File Uploaded Successfully - ", originalFilename);
	    
	    // Enregistrement: 
	    
	    documentAdministratifService.saveAndFlush(documentAdministratifPublie);
	    
	    return new ResponseEntity<>(documentAdministratifPublie, headers, HttpStatus.OK);
	   } catch (Exception e) {    
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }
	  }else{
	   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }
	 }
	
	// Suppression d'un document administratif:
	
	@RequestMapping(value = "/documents/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void supprimerDocument(@PathVariable("id") Long id) {
		// Exception au cas ou l'id n'existe pas
		try {
		documentAdministratifService.delete(id);
		System.out.println("Supprimé avec succès.");
		} catch(Exception e) {	
			System.err.println("Erreur, verifier l'id. ");
		}
    }

	
}
