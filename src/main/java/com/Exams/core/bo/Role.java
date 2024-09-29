package com.Exams.core.bo;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;

	private String nomRole;

	public Long getIdRole() {
		return idRole;
	}

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL , targetEntity = UserAccount.class)
	private Set<UserAccount> accounts;


	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

}