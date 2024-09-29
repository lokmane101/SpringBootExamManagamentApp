package com.Exams.core.bo;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;

    @NotBlank(message = "Ce champ est obligatoire")
    private String intitule;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;

	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
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
	
	

	
	
	
	
	
}
