package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class TypeExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeExamen;

    @NotBlank(message = "Ce champ est obligatoire")
    private String intitule;

    @OneToMany(mappedBy = "typeExamen", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;

	public Long getIdTypeExamen() {
		return idTypeExamen;
	}

	public void setIdTypeExamen(Long idTypeExamen) {
		this.idTypeExamen = idTypeExamen;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Examen> getExamens() {
		return examens;
	}

	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}

	@Override
	public String toString() {
		return "TypeExamen [idTypeExamen=" + idTypeExamen + ", intitule=" + intitule + "]";
	}
	
	
}
