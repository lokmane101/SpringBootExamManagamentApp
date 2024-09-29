package com.Exams.core.web.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Exams.core.services.IAdministrateurService;
import com.Exams.core.services.IDepartementService;
import com.Exams.core.services.IElementPedagogiqueService;
import com.Exams.core.services.IEnseignantService;
import com.Exams.core.services.IFiliereService;
import com.Exams.core.services.IPersonnelService;
import com.Exams.core.web.models.PersonnelModel;
import com.Exams.core.bo.Enseignant;
import com.Exams.core.bo.Filiere;
import com.Exams.core.bo.Groupe;
import com.Exams.core.bo.Administrateur;
import com.Exams.core.bo.Departement;
import com.Exams.core.bo.Personnel;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class PersonnelController {
	
	@Autowired 
	private IPersonnelService personnelService;
	@Autowired 
	private IFiliereService filiereService;
	@Autowired 
	private IDepartementService departementService;
	@Autowired 
	private IElementPedagogiqueService elementPedagogiqueService;
	
    @Autowired
    private IEnseignantService enseignantService;
    
    @Autowired
    private IAdministrateurService administrateurService;

	
	public PersonnelController() {}
	
	@RequestMapping(value = "/userHomePage")
	public String showForm(Model model) {
		return "user/userHomePage";
	}
	
	@GetMapping(value = "/showForm")
	public String showForm(@RequestParam int typePerson, Model model) {
		PersonnelModel pmodel = new PersonnelModel(typePerson);

		model.addAttribute("personnelModel", pmodel);
		

		List<Personnel> personnels = personnelService.getAllPersonnels();
		List<PersonnelModel> modelPersonnels = new ArrayList<>();

		for (Personnel personnel : personnels) {
			PersonnelModel pm = new PersonnelModel();
			/*BeanUtils.copyProperties(personnel, pm);
			if (personnel instanceof Enseignant) {
				pm.setTypePerson(PersonnelModel.TYPE_ENSEIGNANT);
			} else {
				pm.setTypePerson(PersonnelModel.TYPE_ADMIN);
			}
			
			
			modelPersonnels.add(pm);
			*/
			
			if (personnel instanceof Enseignant) {

				BeanUtils.copyProperties((Enseignant) personnel , pm);
				pm.setTypePersonnel(PersonnelModel.TYPE_ENSEIGNANT);
				modelPersonnels.add(pm);
			} else if (personnel instanceof Administrateur) {
				BeanUtils.copyProperties((Administrateur) personnel, pm);
				pm.setTypePersonnel(PersonnelModel.TYPE_ADMIN);
				modelPersonnels.add(pm);
			}
		}

		model.addAttribute("personnelList", modelPersonnels);
		model.addAttribute("departementList", departementService.getAllDepartements());
		model.addAttribute("filiereList", filiereService.getAllFilieres());

		return "user/form";
	}
	
	@RequestMapping(value = "addPersonnel", method = RequestMethod.POST)
	public String process(@Valid @ModelAttribute("personnelModel") PersonnelModel personnel, 
	                      BindingResult bindingResult, 
	                      Model model, 
	                      RedirectAttributes redirectAttributes) {

	    if (bindingResult.hasErrors()) {
	        model.addAttribute("departementList", departementService.getAllDepartements());
	        model.addAttribute("filiereList", filiereService.getAllFilieres());
	        return "user/form";
	    }

	    if (!personnelService.getPersonnelByNomAndPrenom(personnel.getNom().toLowerCase(), personnel.getPrenom().toLowerCase()).isEmpty()) {
	        redirectAttributes.addFlashAttribute("msg2", "Le personnel avec son nom et prénom existe déjà. Veuillez choisir d'autre nom et prénom.");
	        redirectAttributes.addFlashAttribute("msg2Type", "danger");
	        return "redirect:/user/showForm?typePerson=" + personnel.getTypePersonnel();
	    }

	    if (personnel.getTypePersonnel() == PersonnelModel.TYPE_ENSEIGNANT) {
	        Enseignant ens = new Enseignant();
	        ens.setNom(personnel.getNom().toLowerCase());
	        ens.setPrenom(personnel.getPrenom().toLowerCase());
	        Departement departement = departementService.getDepartementById(personnel.getDepartement());
	        Filiere filiere = filiereService.getFiliereByIdFiliere(personnel.getFiliere());
	        ens.setDepartement(departement);
	        ens.setFiliere(filiere);
	        personnelService.addPersonnel(ens);
	        redirectAttributes.addFlashAttribute("msg2", "L'enseignant est créé avec succès.");
	        redirectAttributes.addFlashAttribute("msg2Type", "success");
	    } else if (personnel.getTypePersonnel() == PersonnelModel.TYPE_ADMIN) {
	        Administrateur admin = new Administrateur();
	        admin.setNom(personnel.getNom().toLowerCase());
	        admin.setPrenom(personnel.getPrenom().toLowerCase());
	        personnelService.addPersonnel(admin);
	        redirectAttributes.addFlashAttribute("msg2", "L'administrateur est créé avec succès.");
	        redirectAttributes.addFlashAttribute("msg2Type", "success");
	    }

	    return "redirect:/user/showForm?typePerson=" + personnel.getTypePersonnel();
	}


	@RequestMapping("ListerPersonnels")
	public String managepersonnels(Model model) {

		List<Personnel> personnels = personnelService.getAllPersonnels();
		List<PersonnelModel> modelPersonnels = new ArrayList<PersonnelModel>();

		for (int i = 0; i < personnels.size(); i++) {
			PersonnelModel pm = new PersonnelModel();
			if (personnels.get(i) instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) personnels.get(i), pm);
				pm.setTypePersonnel(PersonnelModel.TYPE_ENSEIGNANT);
				modelPersonnels.add(pm);
			} else if (personnels.get(i) instanceof Administrateur) {
				BeanUtils.copyProperties((Administrateur) personnels.get(i), pm);
				pm.setTypePersonnel(PersonnelModel.TYPE_ADMIN);
				modelPersonnels.add(pm);
			}
		}

		model.addAttribute("personnelsList", modelPersonnels);

		return "personnels/listerPersonnels";
	}
	
	@RequestMapping(value = "deletePersonnel/{idPersonnel}", method = RequestMethod.GET)
	public String delete(@PathVariable Long idPersonnel) {
	    Personnel p = personnelService.getPersonnelById(idPersonnel);
	    List<Enseignant> ens = enseignantService.getAllEnseignants();
	    List<Administrateur> adm = administrateurService.getAllAdministrateurs();
	    boolean foundInEnseignants = false;
	    for (Enseignant it : ens) {
	        if (it.getNom().equalsIgnoreCase(p.getNom()) && it.getPrenom().equalsIgnoreCase(p.getPrenom())) {
	        	if(! it.getSurveillances().isEmpty()) {
	            foundInEnseignants = true;
	            break; 
	            }
	        }
	    }
	    for (Administrateur it : adm) {
	        if (it.getNom().equalsIgnoreCase(p.getNom()) && it.getPrenom().equalsIgnoreCase(p.getPrenom())) {
	        	if(! it.getSurveillances().isEmpty()) {
	            foundInEnseignants = true;
	            break; 
	            }
	        }
	    }

	    if (foundInEnseignants) {
            throw new IllegalStateException("Ce personnel est associé au moins à un examen. Impossible de le supprimer.");
	    } else {
	        personnelService.deletePersonnel(Long.valueOf(idPersonnel));
	        return "redirect:/user/ListerPersonnels"; 
	    }
	}

	
	
	@RequestMapping("ModifierPersonnel")
	public String updatePerson(@Valid @ModelAttribute("personnelModel") PersonnelModel personnel, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("departementList", departementService.getAllDepartements());
			model.addAttribute("filiereList", filiereService.getAllFilieres());
			return "personnels/modifierPersonnelForm";
		}

		if (personnel.getTypePersonnel() == personnel.TYPE_ADMIN) {
			Administrateur admin = new Administrateur();
			BeanUtils.copyProperties(personnel, admin);
			personnelService.updatePersonnel(admin);

		} else if (personnel.getTypePersonnel() == personnel.TYPE_ENSEIGNANT) {
			Enseignant prof = new Enseignant();
			
			BeanUtils.copyProperties(personnel, prof);
		    Departement departement = departementService.getDepartementById(personnel.getDepartement());
		    Filiere filiere = filiereService.getFiliereByIdFiliere(personnel.getFiliere());
			prof.setDepartement(departement);
			prof.setFiliere(filiere);
	        

			personnelService.updatePersonnel(prof);
		}
		model.addAttribute("msg", "Opération effectuée avec succès");
		model.addAttribute("departementList", departementService.getAllDepartements());
		model.addAttribute("filiereList", filiereService.getAllFilieres());
		return "personnels/modifierPersonnelForm";
	}
	
	@RequestMapping(value = "ModifierPersonnelForm/{idPersonnel}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable("idPersonnel") int idPersonnel, Model model) {
	    Personnel utl = personnelService.getPersonnelById(Long.valueOf(idPersonnel));
	    PersonnelModel pm = new PersonnelModel();

	    if (utl instanceof Enseignant) {
	        BeanUtils.copyProperties((Enseignant) utl, pm);
	        pm.setTypePersonnel(PersonnelModel.TYPE_ENSEIGNANT);
	    } else if (utl instanceof Administrateur) {
	        BeanUtils.copyProperties((Administrateur) utl, pm);
	        pm.setTypePersonnel(PersonnelModel.TYPE_ADMIN);
	    }
	    model.addAttribute("personnelModel", pm); 
		model.addAttribute("departementList", departementService.getAllDepartements());
		model.addAttribute("filiereList", filiereService.getAllFilieres());
	    return "personnels/modifierPersonnelForm";
	}

	

}
