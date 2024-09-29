package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class TypeElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeElement;

    @NotBlank(message = "Ce champ est obligatoire")
    private String titre;
    
    @OneToMany(mappedBy = "typeElement", cascade = CascadeType.ALL, targetEntity = ElementPedagogique.class)
    private Set<ElementPedagogique> elementPedagogiques;

    // Getters and setters...
    public Long getIdTypeElement() {
        return idTypeElement;
    }

    public void setIdTypeElement(Long idTypeElement) {
        this.idTypeElement = idTypeElement;
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
        return "TypeElement [idTypeElement=" + idTypeElement + ", titre=" + titre + "]";
    }
}
