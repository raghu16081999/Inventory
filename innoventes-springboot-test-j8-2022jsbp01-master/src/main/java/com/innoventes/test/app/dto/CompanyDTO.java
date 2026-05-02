package com.innoventes.test.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.innoventes.test.app.annotation.EvenNumberOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;
	@NotNull
	@NotBlank
	@Size(min=5)
	private String companyName;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@Min(0)
//	@Min(0)
//	@Column(name = "strength")
	@EvenNumberOrZero
	private Integer strength;
//	@Column(name ="company_code", unique=true)
	@Pattern(regexp="^[A-Za-z]{2}[0-9]{2}[EeNn]{1}$",message="Invalid company code format")
	private String webSiteURL;
	@Column(name ="company_code", unique=true)
	@Pattern(regexp="^[A-Za-z]{2}[0-9]{2}[EeNn]{1}$",message="Invalid company code format")
	private String companyCode;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public String getWebSiteURL() {
		return webSiteURL;
	}
	public void setWebSiteURL(String webSiteURL) {
		this.webSiteURL = webSiteURL;
	}
	
}
