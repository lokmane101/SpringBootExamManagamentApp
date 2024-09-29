package com.Exams.core.bo;

import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;




@Entity
public class Salle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalle;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private String nomSalle;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private Integer capacité;
	
    public Long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public Integer getCapacité() {
		return capacité;
	}

	public void setCapacité(Integer capacité) {
		this.capacité = capacité;
	}

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, targetEntity = Surveillance.class )
    private Set<Surveillance> surveillances;

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", nomSalle=" + nomSalle + ", capacité=" + capacité + ", surveillances="
				+ surveillances + "]";
	}
	
	

}
