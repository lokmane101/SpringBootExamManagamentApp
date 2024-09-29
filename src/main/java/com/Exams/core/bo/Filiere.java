package com.Exams.core.bo;


import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;

    @NotBlank(message = "Ce champ est obligatoire")
    private String nomFiliere;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, targetEntity = Enseignant.class)
    private Set<Enseignant> enseignants;



	public Long getIdFiliere() {
		return idFiliere;
	}


	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}


	public String getNomFiliere() {
		return nomFiliere;
	}


	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}


	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}


	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}


	@Override
	public String toString() {
		return "Filiere [idFiliere=" + idFiliere + ", nomFiliere=" + nomFiliere + ", enseignants="
				+ enseignants + "]";
	}
	
	
	

}
