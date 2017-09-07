package fr.epf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// Address has been badly named, we therefore use a different column name
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@Column(name="location")
	private String adresse;
	
	private String country;
	
	@Override
	public String toString() {
		return adresse + " " + country;
	}
	
	public Adresse() {}
	
	public Adresse(String location, String country) {
		this.adresse = location;
		this.country = country;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
