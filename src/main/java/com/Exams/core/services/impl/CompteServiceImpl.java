package com.Exams.core.services.impl;

import java.util.List;

import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exams.core.bo.Personnel;
import com.Exams.core.bo.Role;
import com.Exams.core.bo.UserAccount;
import com.Exams.core.dao.IPersonnelRepository;
import com.Exams.core.dao.IRoleRepository;
import com.Exams.core.dao.IUserAccountDao;
import com.Exams.core.services.IUserAccountservice;

@Service
@Transactional
public class CompteServiceImpl implements IUserAccountservice {

	@Autowired
	private IUserAccountDao userDao;

	@Autowired
	private IRoleRepository roleDao;

	@Autowired
	private IPersonnelRepository personDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Role> getAllRoles() {
		return roleDao.findAll();
	}

	public List<UserAccount> getAllAccounts() {
		return userDao.findAll();
	}

	public UserAccount createUser(String login, Long idRole, Long idPerson) {

		UserAccount userAccount = new UserAccount();

		// le login
		userAccount.setLogin(login);

		// Affecter le role
		userAccount.setRole(roleDao.findById(idRole).get());

		// récupérer la personne de la base de données
		Personnel personnel = personDao.findById(idPerson).get();

		// determiner la personne
		userAccount.setProprietaire(personnel);

		// génrer le mot de passe aléatoirement
		String generatedPass = generatePassayPassword();

		// hachage du mot de passe + gain de sel
		String encodedPass = passwordEncoder.encode(generatedPass);

		// affecter ce mot de passe
		userAccount.setPassword(encodedPass);
		userAccount.setRawPassword(generatedPass);

		// Créer le compte
		userDao.save(userAccount);

		return userAccount;

	}

	// génère le mot de passe. Il se base sur Passay
	public String generatePassayPassword() {
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(10, digits);

		return password;
	}

	@Override
	public UserAccount getAccountByUserName(String login) {

		return userDao.getUserAccountByLogin(login);
	}

}
