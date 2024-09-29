package com.Exams.core.bo;

import java.sql.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    private Set<Surveillance> surveillances;

    @Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", surveillances=" + surveillances + ", semestre=" + semestre.getIntitule()
				+ ", session=" + session + ", typeExamen=" + typeExamen + ", elementPedagogique=" + elementPedagogique
				+ ", date=" + date + ", heureDeDebut=" + heureDeDebut + ", dureePrevue=" + dureePrevue
				+ ", dureeReelle=" + dureeReelle + ", anneeUniversitaire=" + anneeUniversitaire + ", epreuve=" + epreuve
				+ ", pv=" + pv + ", rapportTextuelle=" + rapportTextuelle + "]";
	}

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public TypeExamen getTypeExamen() {
		return typeExamen;
	}

	public void setTypeExamen(TypeExamen typeExamen) {
		this.typeExamen = typeExamen;
	}

	public ElementPedagogique getElementPedagogique() {
		return elementPedagogique;
	}

	public void setElementPedagogique(ElementPedagogique elementPedagogique) {
		this.elementPedagogique = elementPedagogique;
	}

	public String getHeureDeDebut() {
		return heureDeDebut;
	}

	public void setHeureDeDebut(String heureDeDebut) {
		this.heureDeDebut = heureDeDebut;
	}

	public String getDureePrevue() {
		return dureePrevue;
	}

	public void setDureePrevue(String dureePrevue) {
		this.dureePrevue = dureePrevue;
	}

	public String getDureeReelle() {
		return dureeReelle;
	}

	public void setDureeReelle(String dureeReelle) {
		this.dureeReelle = dureeReelle;
	}

	public String getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public String getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(String epreuve) {
		this.epreuve = epreuve;
	}

	public String getPv() {
		return pv;
	}

	public void setPv(String pv) {
		this.pv = pv;
	}

	public String getRapportTextuelle() {
		return rapportTextuelle;
	}

	public void setRapportTextuelle(String rapportTextuelle) {
		this.rapportTextuelle = rapportTextuelle;
	}

	@ManyToOne
    @JoinColumn(name = "id_semestre")
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "id_session")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "id_type_examen")
    private TypeExamen typeExamen;

    @ManyToOne
    @JoinColumn(name = "id_element_pedagogique")
    private ElementPedagogique elementPedagogique;

    private Date date;

    private String heureDeDebut;

    private String dureePrevue;

    private String dureeReelle ;


    private String anneeUniversitaire;

    private String epreuve ;

    private String pv ;

    @NotBlank(message = "Ce champ est obligatoire")
    private String rapportTextuelle = "Rien à signaler";

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
