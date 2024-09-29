package com.Exams.core.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Exams.core.bo.ElementPedagogique;
import com.Exams.core.bo.Groupe;
import com.Exams.core.services.IElementPedagogiqueService;
import com.Exams.core.services.IEnseignantService;
import com.Exams.core.services.INiveauService;
import com.Exams.core.services.ITypeElementService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/user")
public class ElementPedagogiqueController {
    @Autowired
    private IElementPedagogiqueService elementPedagogiqueService;
    @Autowired
    private INiveauService niveauService;
    @Autowired
    private IEnseignantService enseignantService;
    @Autowired
    private ITypeElementService typeElementService;

    @RequestMapping(value = "/modifierElement", method = RequestMethod.POST)
    public String modifierElement(@Valid @ModelAttribute("elementPedagogiqueModel") ElementPedagogique newElementPedagogique, @RequestParam ("idElementPedagogique") Long idElementPedagogique,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("ListNiveaux", niveauService.getAllNiveaus());
            model.addAttribute("ListEnseignants", enseignantService.getAllEnseignants());
            model.addAttribute("ListTypesElements", typeElementService.getAllTypeElements());
            return "elementPedagogique/modifierElementPedagogique";
        }

        // Fetch the existing element from the database
        ElementPedagogique existingElementPedagogique = elementPedagogiqueService.getElementPedagogiqueById(idElementPedagogique);
        if (existingElementPedagogique != null) {
            // Update the existing element with the new values
            existingElementPedagogique.setTitre(newElementPedagogique.getTitre());
            existingElementPedagogique.setCoordinateur(newElementPedagogique.getCoordinateur());
            existingElementPedagogique.setEnseignant(newElementPedagogique.getEnseignant());
            existingElementPedagogique.setTypeElement(newElementPedagogique.getTypeElement());
            existingElementPedagogique.setNiveau(newElementPedagogique.getNiveau());

            // Save the updated element back to the database
            elementPedagogiqueService.updateElementPedagogique(existingElementPedagogique);
        } else {
            // Handle the case where the element doesn't exist
            model.addAttribute("errorMessage", "Element pédagogique introuvable.");
            return "elementPedagogique/modifierElementPedagogique";
        }

        return "redirect:/user/ListerElementPedagogiques";
    }

    @RequestMapping(value = "/modifierElementForm", method = RequestMethod.GET)
    public String modifierForm(@RequestParam("idElementPedagogique") Long idElementPedagogique, Model model) {
        ElementPedagogique elementPedagogique = elementPedagogiqueService.getElementPedagogiqueById(idElementPedagogique);
        model.addAttribute("elementPedagogiqueModel", elementPedagogique);
        model.addAttribute("ListNiveaux", niveauService.getAllNiveaus());
        model.addAttribute("ListEnseignants", enseignantService.getAllEnseignants());
        model.addAttribute("ListTypesElements", typeElementService.getAllTypeElements());

        return "elementPedagogique/modifierElementPedagogique";
    }

    @RequestMapping(value = "/deleteElementPedagogique/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long idElementPedagogique) {
        elementPedagogiqueService.deleteElementPedagogique(idElementPedagogique);
        return "redirect:/user/ListerElementPedagogiques";
    }

    @GetMapping("/showAddForm")
    public String loadElementsData(Model model) {
        ElementPedagogique elementPedagogique = new ElementPedagogique();
        model.addAttribute("elementPedagogiqueModel", elementPedagogique);
        model.addAttribute("ListNiveaux", niveauService.getAllNiveaus());
        model.addAttribute("ListEnseignants", enseignantService.getAllEnseignants());
        model.addAttribute("ListTypesElements", typeElementService.getAllTypeElements());
        return "elementPedagogique/ajouterElementPedagogique";
    }

    @RequestMapping(value = "/addElement", method = RequestMethod.POST)
    public String addElement(@Valid @ModelAttribute("elementPedagogiqueModel") ElementPedagogique elementPedagogique, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("ListNiveaux", niveauService.getAllNiveaus());
            model.addAttribute("ListEnseignants", enseignantService.getAllEnseignants());
            model.addAttribute("ListTypesElements", typeElementService.getAllTypeElements());
            return "elementPedagogique/ajouterElementPedagogique";
        }
        if (elementPedagogiqueService.getElementPedagogiqueByTitre(elementPedagogique.getTitre().toLowerCase()) != null) {
            model.addAttribute("msg2", "Le titre d'élément existe déjà. Veuillez choisir un autre titre.");
            model.addAttribute("msg2Type", "danger");
            model.addAttribute("ListEnseignants", enseignantService.getAllEnseignants());
            model.addAttribute("ListTypesElements", typeElementService.getAllTypeElements());  
            model.addAttribute("ListNiveaux", niveauService.getAllNiveaus());
            model.addAttribute("elementPedagogiqueModel", new ElementPedagogique());
            return "elementPedagogique/ajouterElementPedagogique";
        }
        elementPedagogique.setTitre(elementPedagogique.getTitre().toLowerCase());
        elementPedagogiqueService.addElementPedagogique(elementPedagogique);
        return "redirect:/user/ListerElementPedagogiques";
    }

    @RequestMapping("/ListerElementPedagogiques")
    public String listerElementPedagogiques(Model model) {
        model.addAttribute("elementPedagogiqueList", elementPedagogiqueService.getAllElementPedagogiques());
        return "elementPedagogique/listerElementPedagogiques";
    }
}
