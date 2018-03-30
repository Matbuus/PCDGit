package com.ourteam.pcd.controllers;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Matiere;
import com.ourteam.pcd.services.AutorisationService;
import com.ourteam.pcd.services.DocumentDeClasseService;
import com.ourteam.pcd.services.EnseignantService;
import com.ourteam.pcd.services.MatiereService;

@RestController
@Transactional
@RequestMapping("/enseignant")
public class EnseignantController {
	
	@Autowired
	private DocumentDeClasseService documentDeClasseService;
	@Autowired
	private EnseignantService enseignantService;
	@Autowired
	private MatiereService matiereService;
	private Enseignant enseignant=null;
	@Autowired
	private AutorisationService autorisationService;
	
	
	
	
	///////////////////////////////////////// DOCUMENTS DE CLASSE ///////////////////////////////////////////////////
	
	// TEST: Renvoie la liste des documents -> To-Do : Renvoie liste de matières enseignées par l'enseignant 
	// -> Enseignant choisit une matière ->Affichage des documents par matières 
	
	@RequestMapping(value = "/documents", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
	 public Set<Matiere> consulterMatieres(HttpSession session)  throws Exception {
		if(enseignant == null || enseignant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
			String mail = (String)session.getAttribute("USER_MAIL");
			enseignant = enseignantService.findByEmail(mail);	
			System.out.println(enseignant.getNom());
		}
		//return documentDeClasseService.findByEnseignant(enseignant);
		return enseignant.getMatieres();
	}
	
	
	// -> L'enseignant choisit un document en particulier -> 
	
	@RequestMapping(value = "/documents/{idmatiere}/{idDocument}", headers="Accept=application/json" , method = RequestMethod.GET)
    @ResponseBody
	public DocumentDeClasse consulterDocument(HttpSession session, @PathVariable("idmatiere") Long idmatiere,@PathVariable("idDocument") Long idDocument)  throws Exception{	
			if(enseignant == null || enseignant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false ) {
				String mail = (String)session.getAttribute("USER_MAIL");
				enseignant = enseignantService.findByEmail(mail);	
			}
			return documentDeClasseService.findOne(idDocument);
	}
	
	
	// -> Enseignant Choisit une matière -> Affichage des documents qu'il a publiés pour cette matière :
	
	@RequestMapping(value = "/documents/{idmatiere}", headers="Accept=application/json" , method = RequestMethod.GET)
    @ResponseBody
	 public List<DocumentDeClasse> consulterDocuments(HttpSession session, @PathVariable("idmatiere") Long idmatiere)  throws Exception{	
			if(enseignant == null || enseignant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
				String mail = (String)session.getAttribute("USER_MAIL");
				enseignant = enseignantService.findByEmail(mail);	
			}
			Matiere matiere = matiereService.findOne(idmatiere);
			return documentDeClasseService.findByMatiereConcernee(matiere);
	}
	

	// L'enseignant choisit de publier un nouveau document qui concerne cette matière ->
	// Même démarche que l'ajour des documents administratifs 
	
	@RequestMapping(value = "/documents/{idmatiere}/publier", headers=("content-type=multipart/*"), method = RequestMethod.POST)
    @ResponseBody 
	public ResponseEntity<DocumentDeClasse> upload(HttpSession session,@RequestParam("file") MultipartFile inputFile , @PathVariable("idmatiere") Long idmatiere)  throws Exception{
		if(enseignant == null || enseignant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
			String mail = (String)session.getAttribute("USER_MAIL");
			enseignant = enseignantService.findByEmail(mail);	
			System.out.println(enseignant.getNom());
		}
		
		// Quelques verifications sur la matière 
		Boolean exists = false;
		Matiere matiere = matiereService.findOne(idmatiere);
		if(matiere == null) {
			System.err.println("Matiere non existante");
			return null;
		}
		if(matiere.getEnseignants() == null ) 
			System.out.println("NULL");
		else {
		for(Enseignant ens : matiere.getEnseignants()) {
			if(ens.getCompte().getEmail().equals(enseignant.getCompte().getEmail())){
				exists = true;
				//System.err.println("EXISTS");
				break;
			}
		}
		}
		// Si l'enseignant n'est pas déjà enregistré, on met à jour!
		if(!exists){
			matiere.getEnseignants().add(enseignant);
			enseignant.getMatieres().add(matiere);
		 	matiereService.saveAndFlush(matiere);
		 	enseignantService.saveAndFlush(enseignant);
		}
		
		
		
		// Document qui doit persister
		
		DocumentDeClasse documentDeClassePublie = new DocumentDeClasse(); 
	  HttpHeaders headers = new HttpHeaders();
	  if (!inputFile.isEmpty()) {
	   try {
		   
		   // Nom original du fichier: A utiliser dans les recherches
		   
	    String originalFilename = inputFile.getOriginalFilename();
	    
	    	  // Destination ou enregistrer les fichiers sur le serveur 
	    
	    File destinationFile = new File("/Users/malekattia/Documents/PCD/uploadedfiles/"+ originalFilename+java.sql.Timestamp.valueOf(LocalDateTime.now()));
	    inputFile.transferTo(destinationFile);
	    
	    // Mise en place de notre objet à persister
	    
	    documentDeClassePublie.setNom(destinationFile.getPath());
	    documentDeClassePublie.setNomOriginal(originalFilename);
	    documentDeClassePublie.setDateDePublication(java.sql.Timestamp.valueOf(LocalDateTime.now()));
	    documentDeClassePublie.setMatiereConcernee(matiere);
	    documentDeClassePublie.setEnseignant(enseignant);
	    headers.add("File Uploaded Successfully - ", originalFilename);
	    
	    // Enregistrement: 
	    
	    documentDeClasseService.saveAndFlush(documentDeClassePublie);
	    Hibernate.initialize(enseignant.getEnsembleDocumentsDeClasse());
	    return new ResponseEntity<>(documentDeClassePublie, headers, HttpStatus.OK);
	   } catch (Exception e) {    
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }
	  }else{
	   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }
	 }
	

	// Suppression d'un document de cours 
	
	@RequestMapping(value = "/documents/{idmatiere}/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void supprimerDocument(@PathVariable("id") Long id) {
		// Exception au cas ou l'id n'existe pas
		try {
		documentDeClasseService.delete(id);
		System.out.println("Supprimé avec succès.");
		} catch(Exception e) {	
			System.err.println("Erreur, verifier l'id. ");
		}
    }

	/////////////////////////////////// AUTORISATIONS ////////////////////////////////////
	
	
	@RequestMapping(value = "/documents/{idmatiere}/{iddocument}/autoriser/{idclasse}", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void autoriser(HttpSession session,@PathVariable("idmatiere") Long idmatiere,@PathVariable("iddocument") Long iddocument,@PathVariable("idclasse") Long idclasse) throws Exception {
		if(enseignant == null || enseignant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
			String mail = (String)session.getAttribute("USER_MAIL");
			enseignant = enseignantService.findByEmail(mail);	
			System.out.println(enseignant.getNom());
		}
		System.out.println("HERE");
		autorisationService.donnerAutorisation(idclasse, iddocument, enseignant);
	}
	
		
}
