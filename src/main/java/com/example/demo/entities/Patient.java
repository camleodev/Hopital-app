package com.example.demo.entities;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min=2, max=20)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private boolean malade;
	@Min(100)
	private int score;
	
	public Patient(Long id, String nom, Date dateNaissance, boolean malade, int score) {
		
		this.id = id;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.malade = malade;
		this.score = score;
	}
	
	public Patient() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isMalade() {
		return malade;
	}

	public void setMalade(boolean malade) {
		this.malade = malade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
