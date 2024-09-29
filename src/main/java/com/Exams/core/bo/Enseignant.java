package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "enseignantId")
public class Enseignant extends Personnel {

    @ManyToOne
    @JoinColumn(name = "id_departement")
    @NotNull
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "id_filiere")
    @NotNull
    private Filiere filiere;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    @JoinTable(
        name = "enseignant_surveillance",
        joinColumns = @JoinColumn(name = "id_enseignant"),
        inverseJoinColumns = @JoinColumn(name = "id_surveillance")
    )
    private Set<Surveillance> surveillances = new HashSet<>();

    @OneToMany(mappedBy = "coordinateur", cascade = CascadeType.ALL, targetEntity = ElementPedagogique.class)
    private Set<ElementPedagogique> coordinateurElementPedagogiques;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL, targetEntity = ElementPedagogique.class)
    private Set<ElementPedagogique> enseignantElementPedagogiques;


    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Set<Surveillance> getSurveillances() {
        return surveillances;
    }

    public void setSurveillances(Set<Surveillance> surveillances) {
        this.surveillances = surveillances;
    }

    public Set<ElementPedagogique> getCoordinateurElementPedagogiques() {
        return coordinateurElementPedagogiques;
    }

    public void setCoordinateurElementPedagogiques(Set<ElementPedagogique> coordinateurElementPedagogiques) {
        this.coordinateurElementPedagogiques = coordinateurElementPedagogiques;
    }

    public Set<ElementPedagogique> getEnseignantElementPedagogiques() {
        return enseignantElementPedagogiques;
    }

    public void setEnseignantElementPedagogiques(Set<ElementPedagogique> enseignantElementPedagogiques) {
        this.enseignantElementPedagogiques = enseignantElementPedagogiques;
    }
}
