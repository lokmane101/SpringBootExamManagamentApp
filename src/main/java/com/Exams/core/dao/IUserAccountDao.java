package com.Exams.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exams.core.bo.UserAccount;

public interface IUserAccountDao extends JpaRepository<UserAccount, Long> {

	UserAccount getUserAccountByLogin(String username);
	
}
