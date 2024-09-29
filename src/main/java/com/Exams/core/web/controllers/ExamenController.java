package com.Exams.core.web.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import org.springframework.web.multipart.MultipartFile;

import com.Exams.core.bo.Administrateur;
import com.Exams.core.bo.ElementPedagogique;
import com.Exams.core.bo.Enseignant;
import com.Exams.core.bo.Salle;
import com.Exams.core.bo.Session;
import com.Exams.core.bo.Surveillance;
import com.Exams.core.bo.TypeExamen;
import com.Exams.core.services.IAdministrateurService;
import com.Exams.core.services.IElementPedagogiqueService;
import com.Exams.core.services.IEnseignantService;
import com.Exams.core.services.IExamenService;
import com.Exams.core.services.IGroupeService;
import com.Exams.core.services.ISalleService;
import com.Exams.core.services.ISemestreService;
import com.Exams.core.services.ISessionService;
import com.Exams.core.services.ISurveillanceService;
import com.Exams.core.services.ITypeExamenService;

import jakarta.persistence.criteria.Path;
import jakarta.validation.Valid;

import com.Exams.core.bo.Examen;
import com.Exams.core.bo.Groupe;


@Controller
@RequestMapping("/examen")
@SessionAttributes("examenModel")
public class ExamenController {
	
	@Autowired
    private IElementPedagogiqueService elementPedagogiqueService;
    
	@Autowired
	private ISalleService salleService;
	
	@Autowired
	private IEnseignantService enseignantService;	

	@Autowired
	private ITypeExamenService typeExamenService;
	
	@Autowired
	private ISemestreService semestreService;
	
	@Autowired
	private ISessionService sessionService;
	
	@Autowired
	private IAdministrateurService adminService;
	
	@Autowired
	private IGroupeService gruopeService;

	@Autowired
	private IExamenService examenService;
	
	@Autowired
	private ISurveillanceService surveillanceService;

	private Date date;
	
	@ModelAttribute("examenModel")
	public Integer getExamenModel() {
	        return null; // This will initialize the session attribute if it doesn't exist
	    }
	    
	public Date getDate() {
	        return date;
	    }

	public void setDate(Date date) {
	        this.date = date;
	    }
	@RequestMapping("initExam")
	public String InitExam(Model model) {

	    HashMap<String, Number> sallesProfNum = new HashMap<String, Number>();
		Examen examen = new Examen();
		String heure =new String();
		model.addAttribute("examenModel", examen);
		model.addAttribute("elementList",elementPedagogiqueService.getAllElementPedagogiques());
		model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
		model.addAttribute("salleList", salleService.getAllSalles());
		model.addAttribute("typeExamenList", typeExamenService.getAllTypeExamens());
		model.addAttribute("sessionList", sessionService.getAllSessions());
		model.addAttribute("adminList", adminService.getAllAdministrateurs());
		model.addAttribute("date",date );
		model.addAttribute("heure",heure);
		model.addAttribute("sallesProfNum",sallesProfNum);
		model.addAttribute("msg", "Examen a été planifié avec succèss");

		
		
		
		return "examen/creerExamen";
	}
	
	@RequestMapping("UpdateExam")
	public String updateExam(Model model,
	                         @ModelAttribute("examenModel") Examen examen,
	                         BindingResult result,
	                         @RequestParam(value = "selectedSalle", required = false) List<String> selectedSalles,
	                 		@RequestParam(value = "coordinateur", required = false) String coordinateur,
	                         @RequestParam(value = "nomElement", required = false) String nomElement,
	                         @RequestParam(value = "selectedTypeExamen", required = false) String typeExamen,
							@RequestParam(value = "session", required = false) String session){	
	    if (result.hasErrors()) {
	        model.addAttribute("elementList", elementPedagogiqueService.getAllElementPedagogiques());
	        model.addAttribute("salleList", salleService.getAllSalles());
	        model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
	        model.addAttribute("sessionList", sessionService.getAllSessions());
			model.addAttribute("typeExamenList", typeExamenService.getAllTypeExamens());	
			model.addAttribute("adminList",adminService.getAllAdministrateurs() );
			model.addAttribute("msg", "Examen a été planifié avec succèss");
			
	    }
	    ElementPedagogique elementPedagogique = elementPedagogiqueService.getElementPedagogiqueByTitre(nomElement);
	    Enseignant coordinateur1 = enseignantService.getEnseignantByNom(coordinateur);
	    if(coordinateur1 == null) {
	    	coordinateur1 = elementPedagogique.getCoordinateur();
	    	// Si l'utilisateur n'a pas choisi auacun coordinateur, ce sera le coordinateur de la matiere 
	    }
	    
	    Set<Surveillance> surveillances = new HashSet<>();
	    
	    
	    
	    
	    for (String nomSalle : selectedSalles) {
	    	
	        Salle salle = salleService.getSalleByNomSalle(nomSalle);
	        
	        if (salle != null) {
	            Surveillance surveillance = new Surveillance();
	            surveillance.setCoordinateur(coordinateur1);
	            surveillance.setSalle(salle);
	            surveillances.add(surveillance);
	            
	        }
	        
	    }
	    
	    examen.setElementPedagogique(elementPedagogique);
	    examen.setSurveillances(surveillances);

	    LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        Month currentMonth = currentDate.getMonth();
	    examen.setAnneeUniversitaire(nomElement);
	    String anneeUniversitaire;
        if (currentMonth.compareTo(Month.JUNE) <= 0) {
            anneeUniversitaire = (currentYear - 1) + "/" + currentYear;
        } else {
            anneeUniversitaire = currentYear + "/" + (currentYear + 1);
        }
        String intitule;
        if (currentMonth.compareTo(Month.SEPTEMBER) >= 0 || currentMonth.compareTo(Month.JANUARY) <= 0) {
        	intitule = "automne";
        } else {
        	intitule = "printemps";
        }

        examen.setSemestre(semestreService.getSemestreByIntitule(intitule));
        examen.setAnneeUniversitaire(anneeUniversitaire);
        Session session1 = sessionService.getSessionByIntitule(session);

	    TypeExamen typeExam = typeExamenService.getTypeExamenByIntitule(typeExamen);
	    examen.setTypeExamen(typeExam);
        examen.setSession(session1);
        	    return "examen/creerExamen2";
	}
	
	@RequestMapping("UpdateExam2")
	public String choisirMaxProf(Model model,
	                             @ModelAttribute("examenModel") Examen examen,
	                             @RequestParam Map<String, String> sallesProfNum,
	                             @RequestParam("assignmentMethod") String assignmentMethod	                      
	                             
	                             ) {
		Enseignant coordinateur = new Enseignant();						
	    Set<Surveillance> surveillances = new HashSet<>();
	    Set<Surveillance> oldSurveillance =examen.getSurveillances(); //Liste des surveillance contenant juste les salles 
	    															  //et le coordinateur vient de jsp creerExamen
	    
	    List<Groupe> groupList = new ArrayList<Groupe>();
	    Set<Enseignant> enseignantListG = new HashSet<Enseignant>();
	    List<Enseignant> enseignantList = enseignantService.getAllEnseignants();
        if ("groupeAssignmet".equals(assignmentMethod)) {
        // get  a group randomly from goupe list
        groupList = gruopeService.getAllGroupes();
        if (groupList == null || groupList.isEmpty()) {
            throw new IllegalStateException("The group list is empty or not initialized.");
        }

        Random random = new Random();
        
        // Use a while loop to find a group with non-null and non-empty Enseignants
        while (enseignantListG == null || enseignantListG.isEmpty()) {
        	if (groupList.isEmpty()) {
                 throw new IllegalStateException("Aucun groupe ne contient suffisamment d'enseignants à assigner.");
             }
            int randomIndex = random.nextInt(groupList.size());
            enseignantListG = groupList.get(randomIndex).getEnseignants();
            System.out.println(enseignantListG);
            groupList.remove(randomIndex);
        }

        
        }
	    
        
      //get an administrator randomly by shuffle
        
        List<Administrateur> listAdmin= adminService.getAllAdministrateurs();
        Collections.shuffle(listAdmin);

        // Pick the first element (randomly due to shuffling)
                
        
	    for (Map.Entry<String, String> entry : sallesProfNum.entrySet()) {
	        String roomName = entry.getKey();
	        String profNumStr = entry.getValue();
	        for (Surveillance surveillance : oldSurveillance) {
	            if (roomName.equals(surveillance.getSalle().getNomSalle())) {
	                coordinateur = surveillance.getCoordinateur();
	                
	            }
	        }
	        
	        // Skip the assignmentMethod entry
	        if ("assignmentMethod".equals(roomName)) {
	            continue;
	        }

	        try {
	            // Parse the number of professors for each room
	            int value = Integer.parseInt(profNumStr);

	            // Initialize a new surveillance
	            Surveillance surveillance = new Surveillance();
	            
	            
	            
	            Administrateur randomAdministrateur = listAdmin.get(0);
	            surveillance.setCoordinateur(coordinateur);
	            surveillance.setSalle(salleService.getSalleByNomSalle(roomName));
	            surveillance.setAdministrateur(randomAdministrateur);
	            listAdmin.remove(0);
	            
	            
	            // Assignment by group
	            if ("groupeAssignmet".equals(assignmentMethod)) {


	                if (enseignantListG == null || enseignantListG.isEmpty()) {
	                    throw new IllegalArgumentException("The enseignant list is empty or not initialized.");
	                }

	                if (value > enseignantListG.size()) {
	                    throw new IllegalArgumentException("Number of professors is larger than the available list.");
	                }

	                List<Enseignant> copyList = new ArrayList<>(enseignantListG);
	                Collections.shuffle(copyList);
	                List<Enseignant> randomSurveillants =(copyList.subList(0, value));
	                surveillance.setSurveillants(randomSurveillants);
	                enseignantListG.removeAll(randomSurveillants);
	                
	            } else if ("randomAssignment".equals(assignmentMethod)) {

	                if (enseignantList == null || enseignantList.isEmpty()) {
	                    throw new IllegalArgumentException("The enseignant list is empty or not initialized.");
	                }

	                if (value > enseignantList.size()) {
	                    throw new IllegalArgumentException("Number of professors is larger than the available list.");
	                }

	                List<Enseignant> copyList = new ArrayList<>(enseignantList);
	                Collections.shuffle(copyList);
	                List<Enseignant> randomSurveillants =(copyList.subList(0, value));
	                surveillance.setSurveillants(randomSurveillants);
	                System.out.println(enseignantList);
	                enseignantList.removeAll(randomSurveillants);
	                System.out.println(enseignantList);
	            
	            }
	            surveillances.add(surveillance);
	            List<Enseignant> surveillants =surveillance.getSurveillants();
	            for (Enseignant surveillant : surveillants) {
	            	Set<Surveillance> Esurveillances = surveillant.getSurveillances();
	    			Esurveillances.add(surveillance);
	    			surveillant.setSurveillances(Esurveillances);

		        }
	            
	        } catch (NumberFormatException e) {
	            throw new IllegalArgumentException("Invalid number format for room: " + roomName + ", value: " + profNumStr, e);
	        }
	    }

	    examen.setSurveillances(surveillances);
	    //examen.setDureeReelle(examen.getDureePrevue()+examen.getHeureDeDebut());
	    examenService.addExamen(examen);
	    for (Surveillance surveillance : surveillances) {
	        surveillance.setExamen(examen); // Now examen is persisted and we can set it

	        // Save the surveillance entity
	        surveillanceService.addSurveillance(surveillance);

	       
	    }
	    return "redirect:/examen/ListerExamens";
	}

	  @RequestMapping("/ListerExamens")
	    public String listerExamens(Model model) {
	        model.addAttribute("examenList", examenService.getAllExamens());
	        return "examen/listerExamen";
	    }

	  @RequestMapping(value = "/deleteExamen/{id}", method = RequestMethod.GET)
	  public String delete(@PathVariable("id") Long idExamen) {
	      Examen examen = examenService.getExamenById(idExamen);
	      
	      // Remove associations between Enseignant and Surveillance
	      Set<Surveillance> surveillances = examen.getSurveillances();
	      for (Surveillance surveillance : surveillances) {
	          List<Enseignant> surveillants = surveillance.getSurveillants();
	          for (Enseignant surveillant : surveillants) {
	              surveillant.getSurveillances().remove(surveillance);
	              enseignantService.updateEnseignant(surveillant);
	          }
	          surveillance.setSurveillants(null);  // Clear surveillants list
	          surveillanceService.updateSurveillance(surveillance); // Update the surveillance
	      }
	      
	      // Remove surveillances associated with the examen
	      for (Surveillance surveillance : surveillances) {
	          surveillanceService.deleteSurveillance(surveillance.getIdSurveillance());
	      }
	      
	      // Delete the examen
	      examenService.deleteExamen(idExamen);
	      return "redirect:/examen/ListerExamens";
	  }	    
	    @PostMapping("/associerPV")
	    public String modifierExamen(@RequestParam("idExamen") Long idExamen, 
	                                 @Valid @ModelAttribute("examenModel") Examen newExamen, 
	                                 BindingResult bindingResult, 
	                                 Model model) {
	        if (bindingResult.hasErrors()) {
	            return "examen/associerPv";
	        }

	        Examen existingExamen = examenService.getExamenById(idExamen);
	        if (existingExamen != null) {
	        	String pv = newExamen.getPv().substring(0, newExamen.getPv().length() - 1);
	            existingExamen.setPv(pv);
	        	String epreuve = newExamen.getEpreuve().substring(0, newExamen.getEpreuve().length() - 1);
	            existingExamen.setEpreuve(epreuve);
	            existingExamen.setDureeReelle(newExamen.getDureeReelle());
	            existingExamen.setRapportTextuelle(newExamen.getRapportTextuelle());

	            examenService.updateExamen(existingExamen);
	        } else {
	            model.addAttribute("errorMessage", "Examen introuvable.");
	            return "examen/associerPv";
	        }

	        return "redirect:/examen/ListerExamens";
	    }

	    @RequestMapping(value = "/associerPVForm", method = RequestMethod.GET)
	    public String modifier(@RequestParam("idExamen") Long idExamen, Model model) {
	        Examen examen = examenService.getExamenById(idExamen);
	        model.addAttribute("examenModel", examen);
	        return "examen/associerPv";
	    }
	    
	    
	    
	    
	    @RequestMapping(value = "/modifierExamen", method = RequestMethod.POST)
	    public String modifierExamen(@Valid @ModelAttribute("examenModel") Examen newExamen, @RequestParam ("idExamen") Long idExamen,BindingResult bindingResult,
	    		Model model, @RequestParam(value = "selectedSalle", required = false) List<String> selectedSalles,
         		@RequestParam(value = "coordinateur", required = false) String coordinateur,
                @RequestParam(value = "nomElement", required = false) String nomElement,
                @RequestParam(value = "selectedTypeExamen", required = false) String typeExamen,
				@RequestParam(value = "session", required = false) String session) {

		    ElementPedagogique elementPedagogique = elementPedagogiqueService.getElementPedagogiqueByTitre(nomElement);
		    Enseignant coordinateur1 = enseignantService.getEnseignantByNom(coordinateur);
		    if(coordinateur1 == null) {
		    	coordinateur1 = elementPedagogique.getCoordinateur();
	        
	    	Examen existingExamen = examenService.getExamenById(idExamen);
	        if (existingExamen != null) {
	        	existingExamen.setHeureDeDebut(newExamen.getHeureDeDebut());
	        	// ...
	        	examenService.updateExamen(existingExamen);
	        } else {
	        	model.addAttribute("errorMessage", "Examen introuvable.");
	            return "examen/modifierExamen";
	        }

	        return "redirect:/examen/ListerExamens";
	        
	    }
			return session;
	    }
	    @RequestMapping(value = "/modifierExamenForm/{id}", method = RequestMethod.GET)
	    public String modifierForm(@PathVariable("id") Long idExamen, Model model,
	    		@RequestParam(value = "selectedSalle", required = false) List<String> selectedSalles,
         		@RequestParam(value = "coordinateur", required = false) String coordinateur,
                 @RequestParam(value = "nomElement", required = false) String nomElement,
                 @RequestParam(value = "selectedTypeExamen", required = false) String typeExamen,
				@RequestParam(value = "session", required = false) String session) {
	        Examen examen = examenService.getExamenById(idExamen);

		    HashMap<String, Number> sallesProfNum = new HashMap<String, Number>();
			String heure =new String();
			model.addAttribute("examenModel", examen);
			model.addAttribute("elementList",elementPedagogiqueService.getAllElementPedagogiques());
			model.addAttribute("enseignantList", enseignantService.getAllEnseignants());
			model.addAttribute("salleList", salleService.getAllSalles());
			model.addAttribute("typeExamenList", typeExamenService.getAllTypeExamens());
			model.addAttribute("sessionList", sessionService.getAllSessions());
			model.addAttribute("adminList", adminService.getAllAdministrateurs());
			model.addAttribute("date",date );
			model.addAttribute("heure",heure);
			model.addAttribute("sallesProfNum",sallesProfNum);
			Set<Surveillance> surveillances = examen.getSurveillances();
			List<String> selectedSallesForCurrentExam = new ArrayList<String>();
		      for (Surveillance surveillance : surveillances) {
		    	  selectedSallesForCurrentExam.add(surveillance.getSalle().getNomSalle());}
		      
		    model.addAttribute("selectedSallesForCurrentExam", selectedSallesForCurrentExam);

	        return "examen/modifierExamen";
	    }



		
	



}
