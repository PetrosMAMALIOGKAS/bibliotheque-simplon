package co.simplon.model;

import java.util.ArrayList;

public class Bibliotheque {
	
	private String nom;
	private String adresse;
	private ArrayList<Adherent> listDesAdherents;
	
	private Bibliotheque(Builder builder) {
		
		this.nom = builder.nom;
		this.adresse = builder.adresse;
		this.listDesAdherents = new ArrayList<Adherent>();
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom) {
		
		this.nom = nom;
		
	}

	public String getAdresse() {
		
		return adresse;
		
	}

	public void setAdresse(String adresse) {
		
		this.adresse = adresse;
		
	}

	public ArrayList<Adherent> getListDesAdherents() {
		
		return listDesAdherents;
		
	}

	public void inscrire(Adherent adherent) {
		
		this.listDesAdherents.add(adherent);
		
	}
	
	public boolean desinscrire(Adherent adherent) {
		
		return this.listDesAdherents.remove(adherent);
		
	}

	@Override
	public String toString() {
		
		String s = "";
		int counter = 1;
		for (Adherent element : this.listDesAdherents) {
			s = s + counter + ". " + element.getPrenom() + element.getNom() + "\n";
		}
		return "Bibliotheque ***** listDesAdherents \n" + s;
		
	}
	
	public static class Builder {
		
		private String nom;
		private String adresse;
		
		public Builder nom(String nom) {
			
			this.nom = nom;
			return this;
			
		}
		
		public Builder adresse(String adresse) {
			
			this.adresse = adresse;
			return this;
			
		}
		
		public Bibliotheque build() {
			
			if (this.adresse == null) {
				throw new IllegalStateException("L adresse est obligatoire");
			}
			
			if (this.nom == null) {
				throw new IllegalStateException("Le nom est obligatoire");
			}
			
			return new Bibliotheque(this);
		}
	}
	

}
