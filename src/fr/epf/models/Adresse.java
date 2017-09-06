package fr.epf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
}
