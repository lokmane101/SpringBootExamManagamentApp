package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "adminId")
public class Administrateur extends Personnel {

    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    private Set<Surveillance> surveillances;

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}
	
	
	
	

}
