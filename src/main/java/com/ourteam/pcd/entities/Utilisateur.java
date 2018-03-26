package com.ourteam.pcd.entities;

import javax.persistence.*;

@MappedSuperclass
@Table(name="Utilisateur")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Utilisateur {

	public Utilisateur() {}
	
	public Utilisateur(Compte compte, String nom, String prenom, String telephone) {
		super();
		this.compte = compte;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	@OneToOne
	@JoinColumn(name="email", unique=true,nullable=false) // Jointure avec la table Compte en utilisant la colonne "email"
	protected Compte compte;
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@Column(name="nom", nullable=false,length=20)
	protected String nom;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column(name="prenom", nullable = false, length = 20)
	protected String prenom;
	
	
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Column(name="telephone" , unique = true, nullable = false, length = 8)
	protected String telephone;


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	

}
