package com.innoventes.test.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innoventes.test.app.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {

	Optional<Company> finByCompanyCode(String companyCode);
	boolean existsByCompanyCode(String code);
	
}