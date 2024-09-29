package com.Exams.core.web.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Exams.core.bo.UserAccount;
import com.Exams.core.bo.UserPrincipal;
import com.Exams.core.bo.Personnel;
import com.Exams.core.web.models.UserAndAccountInfos;

@Controller
public class LoginController {

	@Autowired
	private HttpSession httpSession;

	private UserAndAccountInfos getUserAccount() {
		// On vérifie si les infors de l'utilisateur sont déjà dans la session
		UserAndAccountInfos userInfo = (UserAndAccountInfos) httpSession.getAttribute("userInfo");

		if (userInfo == null) {

			// On obtient l'objet representant le compte connecté (Objet UserPrincipal
			// implémentant UserDetails)
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			// On cast vers notre objet UserPrincipal
			UserAccount userAccount = ((UserPrincipal) principal).getUser();

			Personnel u = userAccount.getProprietaire();
			
			String roleName = userAccount.getRole().getNomRole();

			userInfo = new UserAndAccountInfos(u.getIdPersonnel(), userAccount.getIdCompte(), userAccount.getLogin(),
					u.getNom(), u.getPrenom(), roleName);

			// On le stocke dans la session
			httpSession.setAttribute("userInfo", userInfo);
		}

		return userInfo;

	}

	@GetMapping("/showMyLoginPage")
	public String showLoginForm() {

		return "loginForm";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";

	}

	@GetMapping("/user/showuserHome")
	public String showStudentHomePage(Model m) {
		return "user/userHomePage";

	}

}
