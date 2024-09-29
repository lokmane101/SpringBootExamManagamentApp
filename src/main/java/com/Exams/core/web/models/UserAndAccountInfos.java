package com.Exams.core.web.models;

public class UserAndAccountInfos {

	private Long idPersonne;
	
	private Long idCompte;
	
	private String login;
	
	private String nom;
	
	private String roleName;
	
	
	public UserAndAccountInfos() {
	}
	

	public UserAndAccountInfos(Long idPersonne, Long idCompte, String login, String nom, String prenom,String roleName) {
		this.idPersonne = idPersonne;
		this.idCompte = idCompte;
		this.login = login;
		this.nom = nom;
		this.roleName = roleName;
	}

	
	
	
	@Override
	public String toString() {
		return "UserAndAccountInfos [idPersonne=" + idPersonne + ", idCompte=" + idCompte + ", login=" + login
				+ ", nom=" + nom + ", prenom=" + "]";
	}


	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
