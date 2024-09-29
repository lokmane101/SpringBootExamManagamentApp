package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ElementPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementPedagogique;

    @NotBlank(message = "Ce champ est obligatoire")
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_coordinateur")
    private Enseignant coordinateur;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "id_typeelement")
    private TypeElement typeElement;

    @OneToMany(mappedBy = "elementPedagogique", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;

    // Getters and setters...
    public Long getIdElementPedagogique() {
        return idElementPedagogique;
    }

    public void setIdElementPedagogique(Long idElementPedagogique) {
        this.idElementPedagogique = idElementPedagogique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Enseignant getCoordinateur() {
        return coordinateur;
    }

    public void setCoordinateur(Enseignant coordinateur) {
        this.coordinateur = coordinateur;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(TypeElement typeElement) {
        this.typeElement = typeElement;
    }

    public Set<Examen> getExamens() {
        return examens;
    }

    public void setExamens(Set<Examen> examens) {
        this.examens = examens;
    }

    @Override
    public String toString() {
        return "ElementPedagogique [idElementPedagogique=" + idElementPedagogique + ", titre=" + titre + "]";
    }
}
