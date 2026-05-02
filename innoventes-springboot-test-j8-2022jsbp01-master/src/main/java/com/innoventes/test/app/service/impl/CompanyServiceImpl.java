package com.innoventes.test.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoventes.test.app.dto.CompanyDTO;
import com.innoventes.test.app.entity.Company;
import com.innoventes.test.app.error.ApplicationErrorCodes;
import com.innoventes.test.app.exception.ResourceNotFoundException;
import com.innoventes.test.app.exception.ValidationException;
import com.innoventes.test.app.repository.CompanyRepository;
import com.innoventes.test.app.service.CompanyService;
import com.innoventes.test.app.util.ServiceHelper;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	ModelMapper mapper;
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ServiceHelper serviceHelper;

	@Override
	public List<Company> getAllCompanies() {
		ArrayList<Company> companyList = new ArrayList<Company>();
		companyRepository.findAll().forEach(companyList::add);
		return companyList;
	}

	@Override
	public Company addCompany(Company company) throws ValidationException {
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Long id, Company company) throws ValidationException {
		Company existingCompanyRecord = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
						ApplicationErrorCodes.COMPANY_NOT_FOUND));
		company.setId(existingCompanyRecord.getId());
		return companyRepository.save(company);
	}

	@Override
	public void deleteCompany(Long id) {
		Company existingCompanyRecord = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
						ApplicationErrorCodes.COMPANY_NOT_FOUND));
		companyRepository.deleteById(existingCompanyRecord.getId());
	}
	@Override
	public CompanyDTO getById(Long id)
	{
		Company company= companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		return convertEntityToDto(company);
	}
	@Override
	public CompanyDTO getByCompanyCode(String companyCode)
	{
		Optional<Company> company= companyRepository.finByCompanyCode(companyCode);//.orElseThrow(() -> ;
		Company company1=new Company();
		if(company.isPresent())
		{
			
			return convertEntityToDto(company.get());
		}
		else {
			throw new RuntimeException("Company Not Found");
		}
				
	}
	public CompanyDTO updatePartial(Long id,CompanyDTO dto)
	{
		Company company=companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company Not Found By Id"));
		if(dto.getCompanyName() !=null)
		{
			company.setCompanyName(dto.getCompanyName());
		}
		if(dto.getEmail() !=null)
		{
			company.setEmail(dto.getEmail());
		}if(dto.getStrength() !=null)
		{
			company.setStrength(dto.getStrength());
		}
		if(dto.getStrength() !=null)
		{
			company.setStrength(dto.getStrength());
		}
		 if(dto.getWebSiteURL() !=null)
		{
			company.setWebSiteURL(dto.getWebSiteURL());
		}
		 if(dto.getWebSiteURL() !=null)
		{
			company.setWebSiteURL(dto.getWebSiteURL());
		} if(dto.getCompanyCode() !=null)
		{
//			
			if(companyRepository.existsByCompanyCode(dto.getCompanyCode()))
			{
				throw new RuntimeException("Company code is already present/exist");
				
			}
			company.setCompanyCode(dto.getCompanyCode());
			
		}
		Company saved=companyRepository.save(company);
//		return mapper.map(saved,CompanyDTO.class);
		return convertEntityToDto(saved);
		
	}

	private CompanyDTO convertEntityToDto(Company saved) {
		// TODO Auto-generated method stub
		CompanyDTO dto=new CompanyDTO();
		dto.setId(saved.getId());
		dto.setCompanyCode(saved.getCompanyCode());
		dto.setCompanyName(saved.getCompanyName());
		dto.setEmail(saved.getEmail());
		dto.setStrength(saved.getStrength());
		dto.setWebSiteURL(saved.getWebSiteURL());
		return dto;
	}
}
