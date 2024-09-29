package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemestre;

    @NotBlank(message = "Ce champ est obligatoire")
    private String intitule;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;

	public Long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
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
		return "Semestre [idSemestre=" + idSemestre + ", intitule=" + intitule + ", examens=" + examens + "]";
	}
	
	
}
