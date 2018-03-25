package com.ourteam.pcd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.services.DocumentDeClasseService;
import com.ourteam.pcd.entities.DocumentDeClasse;

@RestController
@Transactional
@RequestMapping("/documentdeclasse")
public class DocumentDeClasseController {
	@Autowired
	private DocumentDeClasseService documentDeClasseService;

	@RequestMapping(value = "/creerDocument", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public DocumentDeClasse addDocument(@RequestBody final DocumentDeClasse document) throws Exception {
		System.out.println("POST");
		return documentDeClasseService.saveAndFlush(document);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<DocumentDeClasse> AfficherAllDocuments() throws Exception {
		List<DocumentDeClasse> liste = documentDeClasseService.findAll();
		if(liste == null) return liste;
		for(int i=0;i<liste.size();i++)
			System.out.println("Nom : " + liste.get(i).getNom() + " | Id: "+ liste.get(i).getIdDocument());
		return liste;
	}
	   @RequestMapping(value="/{id}", method=RequestMethod.GET)
	    public DocumentDeClasse getDocumentDeClasse(@PathVariable(value="id") Long id){
		   	System.out.println("HERE");
	        DocumentDeClasse doc = documentDeClasseService.findOne(id);
	        System.out.println("Nom du document: " + doc.getNom() + " Nom du prof: " + doc.getEnseignant().getNom());
	        return doc;
	        
	    }

}
