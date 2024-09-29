package com.Exams.core.bo;


import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartement;

    @NotBlank(message = "Ce champ est obligatoire")
    private String nomDepartement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, targetEntity = Enseignant.class )
    private Set<Enseignant> enseignants;


	public Long getIdDepartement() {
		return idDepartement;
	}


	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}


	public String getNomDepartement() {
		return nomDepartement;
	}


	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}


	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}


	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}


	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement + ", enseignants="
				+ enseignants + "]";
	}
	
	
	

}
