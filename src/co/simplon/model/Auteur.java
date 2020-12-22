package co.simplon.model;

public class Auteur {
	private String id_auteur;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	
	private Auteur(Builder builder) {
		
		this.id_auteur = builder.id_auteur;
		this.prenom = builder.prenom;
		this.nom = builder.nom;
		this.adresse = builder.adresse;
		this.telephone = builder.telephone;
		
	}

	public String getId_auteur() {
		
		return id_auteur;
		
	}

	public void setId_auteur(String id_auteur) {
		
		this.id_auteur = id_auteur;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom) {
		
		this.nom = nom;
		
	}

	public String getPrenom() {
		
		return prenom;
		
	}

	public void setPrenom(String prenom) {
		
		this.prenom = prenom;
		
	}

	public String getAdresse() {
		
		return adresse;
		
	}

	public void setAdresse(String adresse) {
		
		this.adresse = adresse;
		
	}

	public String getTelephone() {
		
		return telephone;
		
	}

	public void setTelephone(String telephone) {
		
		this.telephone = telephone;
		
	}

	@Override
	public String toString() {
		
		return "Auteur [id_auteur=" + id_auteur + ", nom=" + nom + ", prenom=" + prenom + "]";
		
	}
	
	
	public static class Builder {
		
		private String id_auteur;
		private String nom;
		private String prenom;
		private String adresse;
		private String telephone;
		
		public Builder id_auteur(String id_auteur) {
			
			this.id_auteur = id_auteur;
			return this;
			
		}
		
		public Builder nom(String nom) {
			
			this.nom = nom;
			return this;
			
		}
		
		public Builder prenom(String prenom) {
			
			this.prenom = prenom;
			return this;
			
		}
		
		public Builder adresse(String adresse) {
			
			this.adresse = adresse;
			return this;
			
		}
		
		public Builder telephone(String telephone) {
			
			this.telephone = telephone;
			return this;
			
		}
		
		
		public Auteur build() {
			
			return new Auteur(this);
			
		}
	}
	
}
