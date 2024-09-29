package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;

    @NotBlank(message = "Ce champ est obligatoire")
    private String titre;
    
    @OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL, targetEntity = ElementPedagogique.class)
    private Set<ElementPedagogique> elementPedagogiques;

    // Getters and setters...
    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Set<ElementPedagogique> getElementPedagogiques() {
        return elementPedagogiques;
    }

    public void setElementPedagogiques(Set<ElementPedagogique> elementPedagogiques) {
        this.elementPedagogiques = elementPedagogiques;
    }

    @Override
    public String toString() {
        return "Niveau [idNiveau=" + idNiveau + ", titre=" + titre + "]";
    }
}
