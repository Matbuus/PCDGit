package com.ourteam.pcd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.entities.Autorisation;
import com.ourteam.pcd.entities.Classe;
import com.ourteam.pcd.entities.DocumentDeClasse;
import com.ourteam.pcd.entities.Enseignant;
import com.ourteam.pcd.entities.Etudiant;
import com.ourteam.pcd.entities.Matiere;
import com.ourteam.pcd.services.AutorisationService;
import com.ourteam.pcd.services.DocumentDeClasseService;
import com.ourteam.pcd.services.EnseignantService;
import com.ourteam.pcd.services.EtudiantService;
import com.ourteam.pcd.services.MatiereService;

@RestController
@Transactional
@RequestMapping("/etudiant")
public class EtudiantController {
	@Autowired
	private DocumentDeClasseService documentDeClasseService;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private MatiereService matiereService;
	private Etudiant etudiant=null;
	@Autowired
	private AutorisationService autorisationService;
	private List<Matiere> listeDesMatieres = new ArrayList<>();
	
	@RequestMapping(value = "/documents", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
	 public List<Matiere> consulterMatieres(HttpSession session)  throws Exception {
		if(etudiant == null  || etudiant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
			String mail = (String)session.getAttribute("USER_MAIL");
			etudiant = etudiantService.findByEmail(mail);	
			System.out.println(etudiant.getNom());
		}
		//return documentDeClasseService.findByEnseignant(enseignant);
		
		for(Classe classe: etudiant.getClasses()) {
			for(Matiere matiere: classe.getMatieres()) {
				System.out.println(matiere.getNom());
				if(!listeDesMatieres.contains(matiere))
					listeDesMatieres.add(matiere);
			}
		}
		return listeDesMatieres;
	}
	
	@RequestMapping(value = "/documents/{idmatiere}", headers="Accept=application/json" , method = RequestMethod.GET)
    @ResponseBody
	 public List<DocumentDeClasse> consulterDocuments(HttpSession session, @PathVariable("idmatiere") Long idmatiere)  throws Exception{	
			if(etudiant == null || etudiant.getCompte().getEmail().equals((String)session.getAttribute("USER_MAIL")) == false) {
				String mail = (String)session.getAttribute("USER_MAIL");
				etudiant = etudiantService.findByEmail(mail);	
				System.out.println(etudiant.getNom());
			}
			List<DocumentDeClasse> documentsAutorises = new ArrayList<>();
			for(Classe c: etudiant.getClasses()) {
				for(Autorisation autorisation : c.getAutorisationsRecues()) {
					documentsAutorises.add(autorisation.getDocumentConcerne());
					System.out.println(autorisation.getIdAutorisation());
				}
			}
			List<DocumentDeClasse> resultat = new ArrayList<>();
			for(DocumentDeClasse doc : documentsAutorises)
				if(doc.getMatiereConcernee().getIdMatiere() == idmatiere) 
					resultat.add(doc);
			return resultat;
	}
	
	
}
