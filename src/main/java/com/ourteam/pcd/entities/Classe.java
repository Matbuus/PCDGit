package com.ourteam.pcd.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Classe")
public class Classe {
	
	public Classe() {}
	
	@Id
	@Column(name="nomClasse")
	private String nomClasse;

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public Classe(String nomClasse) {
		super();
		this.nomClasse = nomClasse;
	}
	
	@OneToMany(mappedBy="classeConcernee")
	private Set<Autorisation> autorisationsRecues;

	public Set<Autorisation> getAutorisationsRecues() {
		return autorisationsRecues;
	}

	public void setAutorisationsRecues(Set<Autorisation> autorisationsRecues) {
		this.autorisationsRecues = autorisationsRecues;
	}

	
}
