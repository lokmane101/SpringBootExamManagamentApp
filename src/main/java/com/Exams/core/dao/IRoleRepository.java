package com.Exams.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Exams.core.bo.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
