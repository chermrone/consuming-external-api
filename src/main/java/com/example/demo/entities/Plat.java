package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plat {
	@Id
	private Long id;
	private String nom;
	private double prix;
	private String description;
	private String image;
	private boolean statut;
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Plat(Long id, String nom, double prix, String description, String image, boolean statut) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.image = image;
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", description=" + description + ", image="
				+ image + ", statut=" + statut + "]";
	}
	public Plat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
