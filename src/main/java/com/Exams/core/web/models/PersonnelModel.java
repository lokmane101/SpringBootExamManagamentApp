package com.Exams.core.web.models;

import jakarta.validation.constraints.NotBlank;

public class PersonnelModel {

	public static final int TYPE_ADMIN = 1;
	public static final int TYPE_ENSEIGNANT= 2;
	
	private Long idPersonnel;
	private int typePersonnel;
	

	@NotBlank(message = "Ce champs est obligatoire")
	private String nom;

	@NotBlank(message = "Ce champs est obligatoire")
	private String prenom;

	private Long filiere;
	
	private Long departement;
	




	
	
	public PersonnelModel() {
		
	}
	


	@Override
	public String toString() {
		return "PersonnelModel [idPersonnel=" + idPersonnel + ", typePersonnel=" + typePersonnel + ", filiere="
				+ filiere + ", departement=" + departement  + ", nom="
				+ nom + ", prenom=" + prenom + "]";
	}



	public Long getFiliere() {
		return filiere;
	}



	public void setFiliere(Long filiere) {
		this.filiere = filiere;
	}



	public Long getDepartement() {
		return departement;
	}



	public void setDepartement(Long departement) {
		this.departement = departement;
	}





	public PersonnelModel(int typePersonnel) {
		this.typePersonnel = typePersonnel;
	}




	public int getTypePersonnel() {
		return typePersonnel;
	}


	public void setTypePersonnel(int typePersonnel) {
		this.typePersonnel = typePersonnel;
	}


	public static int getTypeAdmin() {
		return TYPE_ADMIN;
	}


	public static int getTypeEnseignant() {
		return TYPE_ENSEIGNANT;
	}


	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}





}
