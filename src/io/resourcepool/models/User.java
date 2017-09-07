package io.resourcepool.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Adress> adresse;
	
	@OneToOne (fetch = FetchType.LAZY, mappedBy = "owner")
	private Cellphone cellphone;
	
	
	//a default constructor is important for Hibernate usage
	public User() {}
	
	public Cellphone getCellphone() {
		return cellphone;
	}

	public void setCellphone(Cellphone cellphone) {
		this.cellphone = cellphone;
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<Adress> getAdresse() {
		return adresse;
	}

	public void setAdresse(List<Adress> adresse) {
		this.adresse = adresse;
	}

	
}
