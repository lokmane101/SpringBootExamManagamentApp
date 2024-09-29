package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Surveillance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurveillance;

    @ManyToMany(mappedBy = "surveillances")
    private List<Enseignant> surveillants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_coordinateur")
    private Enseignant coordinateur;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Administrateur administrateur;

    @ManyToOne
    @JoinColumn(name = "id_salle")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "id_examen")
    private Examen examen;

	public Long getIdSurveillance() {
		return idSurveillance;
	}

	public void setIdSurveillance(Long idSurveillance) {
		this.idSurveillance = idSurveillance;
	}

	public List<Enseignant> getSurveillants() {
		return surveillants;
	}

	public void setSurveillants(List<Enseignant> surveillants) {
		this.surveillants = surveillants;
	}

	public Enseignant getCoordinateur() {
		return coordinateur;
	}

	public void setCoordinateur(Enseignant coordinateur) {
		this.coordinateur = coordinateur;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
	public String toString() {
		return "Surveillance [idSurveillance=" + idSurveillance + ", surveillants=" + surveillants + ", coordinateur="
				+ coordinateur + ", administrateur=" + administrateur + ", salle=" + salle.getNomSalle(); 
	}

	



}
