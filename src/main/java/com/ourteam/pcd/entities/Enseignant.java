package com.ourteam.pcd.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Enseignant")
public class Enseignant extends Utilisateur {
	
	public Enseignant() {}
	
	public Enseignant(Compte compte, String nom, String prenom, String telephone, String idEnseignant) {
		super(compte, nom, prenom, telephone);
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
	@OneToMany(mappedBy="enseignant", fetch=FetchType.EAGER)
	private Set<DocumentDeClasse> ensembleDocumentsDeClasse;

	public Set<DocumentDeClasse> getEnsembleDocumentsDeClasse() {
		return ensembleDocumentsDeClasse;
	}

	public void setEnsembleDocumentsDeClasse(Set<DocumentDeClasse> ensembleDocumentsDeClasse) {
		this.ensembleDocumentsDeClasse = ensembleDocumentsDeClasse;
	}

	@OneToMany(mappedBy="enseignantResponsable", fetch=FetchType.EAGER)
	private Set<Autorisation> autorisationsDonnees;

	public Set<Autorisation> getAutorisationsDonnees() {
		return autorisationsDonnees;
	}

	public void setAutorisationsDonnees(Set<Autorisation> autorisationsDonnees) {
		this.autorisationsDonnees = autorisationsDonnees;
	}

}
