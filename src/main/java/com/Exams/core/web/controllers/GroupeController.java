package com.Exams.core.web.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Exams.core.bo.Departement;
import com.Exams.core.bo.ElementPedagogique;
import com.Exams.core.bo.Enseignant;
import com.Exams.core.bo.Filiere;
import com.Exams.core.bo.Groupe;
import com.Exams.core.bo.Personnel;
import com.Exams.core.services.IDepartementService;
import com.Exams.core.services.IEnseignantService;
import com.Exams.core.services.IFiliereService;
import com.Exams.core.services.IGroupeService;
import com.Exams.core.services.IPersonnelService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/groupe")
@SessionAttributes("typeGroupe")
public class GroupeController {

    @Autowired
    private IFiliereService filiereService;

    @Autowired
    private IDepartementService departementService;

    @Autowired
    private IEnseignantService enseignantService;

    @Autowired
    private IGroupeService groupeService;
    
    @Autowired
    private IPersonnelService personnelService;

    @ModelAttribute("typeGroupe")
    public Integer getTypeGroupe() {
        return null; // This will initialize the session attribute if it doesn't exist
    }
    
    @RequestMapping("initGroupe")
    public String initGroupe(Model model) {
        model.addAttribute("filiereList", filiereService.getAllFilieres());
        model.addAttribute("departementList", departementService.getAllDepartements());
        return "groupe/initGroupe";
    }

    @RequestMapping("derictToCreerGroupeParFiliere")
    public String derictToCreerGroupeParFiliere(Model model) {
        model.addAttribute("typeGroupe", 1);
        Groupe groupe = new Groupe();
        model.addAttribute("groupeModel",groupe);
    	model.addAttribute("departementList", departementService.getAllDepartements());
        model.addAttribute("filiereList", filiereService.getAllFilieres());
        return "groupe/creerGroupe";
    }

    @RequestMapping("derictToCreerGroupeParDepartement")
    public String derictToCreerGroupeParDepartement(Model model) {
        model.addAttribute("typeGroupe", 2);
        Groupe groupe = new Groupe();
        model.addAttribute("groupeModel",groupe);
        model.addAttribute("departementList",departementService.getAllDepartements());
        return "groupe/creerGroupe";
    }

    @RequestMapping("derictToCreerGroupe")
    public String derictToCreerGroupe(Model model) {
        model.addAttribute("typeGroupe", 3);
        Groupe groupe = new Groupe();
        model.addAttribute("groupeModel",groupe);
        model.addAttribute("enseignantList",enseignantService.getAllEnseignants());
        return "groupe/creerGroupe";
    }



    @PostMapping(value = "CreerGroupeParFiliere")
    public String creerGroupeParFiliere(Model model, 
            @RequestParam("nomFiliere") String nomFiliere, 
            @Valid @ModelAttribute("groupeModel") Groupe groupe, 
            BindingResult result) {
	if (result.hasErrors()) {
	model.addAttribute("filiereList", filiereService.getAllFilieres());
	return "groupe/creerGroupe";
	}
    if (groupeService.getGroupeByNomGroupe(groupe.getNomGroupe()) != null) {
        model.addAttribute("msg2", "Le nom du groupe existe déjà. Veuillez choisir un autre nom.");
        model.addAttribute("msg2Type", "danger");
        model.addAttribute("groupeModel", new Groupe());
    	model.addAttribute("filiereList", filiereService.getAllFilieres());

        return "groupe/creerGroupe";
    }

	Filiere filiere = filiereService.findByNomFiliere(nomFiliere);
	
	List<Enseignant> ListEnseignants = enseignantService.getAllEnseignantsByFiliereId(filiere.getIdFiliere());
	Set<Enseignant> setEnseignants = new HashSet<>(ListEnseignants);
	
	Groupe newGroupe = groupe;
	newGroupe.setEnseignants(setEnseignants);
    groupe.getNomGroupe().toLowerCase();
	groupeService.addGroupe(newGroupe);
	
	model.addAttribute("msg", "Groupe a été créé avec succès");
	model.addAttribute("filiereList", filiereService.getAllFilieres());
	model.addAttribute("groupeModel", new Groupe());  
	
	return "groupe/creerGroupe";
	}





    @PostMapping(value = "CreerGroupeParDepartement")
    public String creerGroupeParDepartement(Model model, 
            @RequestParam("nomDepartement") String nomDepartement, 
            @Valid @ModelAttribute("groupeModel") Groupe groupe, 
            BindingResult result) { 
		if (result.hasErrors()) {
		model.addAttribute("departementList", departementService.getAllDepartements());
		return "groupe/creerGroupe";
		}
        if (groupeService.getGroupeByNomGroupe(groupe.getNomGroupe()) != null) {
            model.addAttribute("msg2", "Le nom du groupe existe déjà. Veuillez choisir un autre nom.");
            model.addAttribute("msg2Type", "danger");
    		model.addAttribute("departementList", departementService.getAllDepartements());
            model.addAttribute("groupeModel", new Groupe());
            return "groupe/creerGroupe";
        }

		
		Departement departement = departementService.findByNomDepartement(nomDepartement);
		List<Enseignant> ListEnseignants = enseignantService.getAllEnseignantsByFiliereId(departement.getIdDepartement());
		Set<Enseignant> setEnseignants = new HashSet<>(ListEnseignants);
		Groupe newGroupe = groupe;
		newGroupe.setEnseignants(setEnseignants);
        groupe.getNomGroupe().toLowerCase();
		groupeService.addGroupe(newGroupe);
		
		model.addAttribute("msg1", "Groupe a été créé avec succès");
		model.addAttribute("departementList", departementService.getAllDepartements());
		model.addAttribute("filiereList", filiereService.getAllFilieres());
		model.addAttribute("groupeModel", new Groupe()); 
		
		return "groupe/creerGroupe";
		}


    @PostMapping("CreerGroupe")
    public String creerGroupe(Model model, 
                               @Valid @ModelAttribute("groupeModel") Groupe groupe, 
                               BindingResult result,
                               @RequestParam(value = "selectedProfessors", required = false) List<Long> selectedProfessors) {

        if (result.hasErrors()) {
            model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
            return "groupe/creerGroupe";
        }

        // Vérification si le nom du groupe existe déjà
        if (groupeService.getGroupeByNomGroupe(groupe.getNomGroupe().toLowerCase()) != null) {
            model.addAttribute("msg2", "Le nom du groupe existe déjà. Veuillez choisir un autre nom.");
            model.addAttribute("msg2Type", "danger");
            model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
            model.addAttribute("groupeModel", new Groupe());
            return "groupe/creerGroupe";
        }

        // Vérification si des professeurs sont sélectionnés
        if (selectedProfessors == null) {
            model.addAttribute("msg2", "Sélectionner au moins un enseignant.");
            model.addAttribute("msg2Type", "danger");
            model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
            model.addAttribute("groupeModel", new Groupe());
            return "groupe/creerGroupe";
        }

        // Création du groupe
        Set<Enseignant> enseignantSet = new HashSet<>();
        for (Long professorId : selectedProfessors) {
            Personnel personnel = personnelService.getPersonnelById(professorId);
            enseignantSet.add((Enseignant) personnel);
        }
        groupe.setEnseignants(enseignantSet);
        groupe.getNomGroupe().toLowerCase();
        groupeService.addGroupe(groupe);

        model.addAttribute("msg2", "Groupe créé avec succès.");
        model.addAttribute("msg2Type", "success");
        model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
        model.addAttribute("groupeModel", new Groupe());

        return "groupe/creerGroupe";
    }
    
    

    @RequestMapping("/ListerGroupes")
    public String listerGroupes(Model model) {
    	// System.out.println( groupeService);
        List<Groupe> groupes = groupeService.getAllGroupes(); 
        model.addAttribute("groupeList", groupes);
        return "groupe/listerGroupe";
    }
    
    @RequestMapping(value = "/deleteGroupe/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long idGroupe) {
        groupeService.deleteGroupe(idGroupe);
        return "redirect:/groupe/ListerGroupes";
    }
    
    
    
    @RequestMapping(value = "/modifierGroupe", method = RequestMethod.POST)
    public String modifierElement(@Valid @ModelAttribute("groupeModel") Groupe newGroupe, @RequestParam ("idGroupe") Long idGroupe ,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "groupe/modifierGroupe";
        }
        Groupe existingGroupe = groupeService.getGroupeById(idGroupe);  
        if (existingGroupe != null) {
        	existingGroupe.setNomGroupe(newGroupe.getNomGroupe());
        	groupeService.updateGroupe(existingGroupe);
        } else {
            model.addAttribute("errorMessage", "Groupe introuvable.");
            return "groupe/modifiergroupe";
        }
        return "redirect:/groupe/ListerGroupes";
    }

    @RequestMapping(value = "/modifierGroupeForm", method = RequestMethod.GET)
    public String modifierForm(@RequestParam("idGroupe") Long idGroupe, Model model) {
        Groupe groupe = groupeService.getGroupeById(idGroupe);
        model.addAttribute("groupeModel", groupe);
        return "groupe/modifierGroupe";
    }


   
}
