package com.Exams.core.bo;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

    @NotBlank(message = "Ce champ est obligatoire")
    private String nomGroupe;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_groupe")
    private Set<Enseignant> enseignants;
	
	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignant) {
		this.enseignants = enseignant;
	}

	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", nomGroupe=" + nomGroupe + "]";
	}
	
	
	
	

}
