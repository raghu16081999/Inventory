package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.innoventes.test.app.annotation.EvenNumberOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;
	@NotNull
	@NotBlank
	@Size(min=5)
	@Column(name = "company_name")
	private String companyName;
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	@Min(0)
	@Column(name = "strength")
	@EvenNumberOrZero
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;
	
	@Column(name ="company_code", unique=true)
	@Pattern(regexp="^[A-Za-z]{2}[0-9]{2}[EeNn]{1}$",message="Invalid company code format")
	private String companyCode;

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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

//	@Override
//	public Long getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
