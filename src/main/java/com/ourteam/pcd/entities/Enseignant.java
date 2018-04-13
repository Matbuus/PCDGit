package com.ourteam.pcd.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Enseignant")
public class Enseignant extends Utilisateur {
	
	public Enseignant() {}
	
	public Enseignant(Compte compte, String nom, String prenom, String telephone, String idEnseignant,String numcin) {
		super(compte, nom, prenom, telephone,numcin);
		this.idEnseignant = idEnseignant;
	}

	@Id
	@Column(name="idenseignant", nullable=false,length=8)
	private String idEnseignant;

	public String getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(String idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	@JsonIgnore
	@OneToMany(mappedBy="enseignant", fetch=FetchType.EAGER)
	private Set<DocumentDeClasse> ensembleDocumentsDeClasse;

	public Set<DocumentDeClasse> getEnsembleDocumentsDeClasse() {
		return ensembleDocumentsDeClasse;
	}

	public void setEnsembleDocumentsDeClasse(Set<DocumentDeClasse> ensembleDocumentsDeClasse) {
		this.ensembleDocumentsDeClasse = ensembleDocumentsDeClasse;
	}

	@JsonIgnore
	@OneToMany(mappedBy="enseignantResponsable", fetch=FetchType.EAGER)
	private Set<Autorisation> autorisationsDonnees;

	public Set<Autorisation> getAutorisationsDonnees() {
		return autorisationsDonnees;
	}

	public void setAutorisationsDonnees(Set<Autorisation> autorisationsDonnees) {
		this.autorisationsDonnees = autorisationsDonnees;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "enseignants")
	private Set<Matiere> matieres;

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
}
