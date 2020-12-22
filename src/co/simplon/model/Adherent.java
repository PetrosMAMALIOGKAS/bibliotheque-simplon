package co.simplon.model;

import java.sql.Date;
import java.util.HashMap;

public class Adherent {
	private String adherent_id;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Date dateDeAdhession;
	private String email;
	private String adresse;
	private String telephone;
	private Utilisateur utilisateur;
	private HashMap<Exemplaire, Date> livresEmprunte;
	
	
	private Adherent(Builder builder) {
		
		this.adherent_id = builder.adherent_id;
		this.prenom = builder.prenom;
		this.nom = builder.nom;
		this.dateDeNaissance = builder.dateDeNaissance;
		this.dateDeAdhession = builder.dateDeAdhession;
		this.email = builder.email;
		this.adresse = builder.adresse;
		this.telephone = builder.telephone;
		this.utilisateur = builder.utilisateur;
		this.livresEmprunte = new HashMap<Exemplaire, Date>(); 
		
	}
	
	public String getAdherent_id() {
		
		return adherent_id;
		
	}

	public void setAdherent_id(String adherent_id) {
		
		this.adherent_id = adherent_id;
		
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
	
	public Date getDateDeNaissance() {
		
		return dateDeNaissance;
		
	}
	
	public void setDateDeNaissanca(Date dateDeNaissance) {
		
		this.dateDeNaissance = dateDeNaissance;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	public String getAdresse() {
		
		return adresse;
		
	}
	
	public void setAdresse(String adresse) {
		
		this.adresse = adresse;
		
	}
	
	public void emprunter(Exemplaire exemplaire, Date dateDePret) {
		
		this.livresEmprunte.put(exemplaire, dateDePret);
		
	}
	
	
	public Date getDateDeAdhession() {
		
		return dateDeAdhession;
		
	}

	public void setDateDeAdhession(Date dateDeAdhession) {
		
		this.dateDeAdhession = dateDeAdhession;
		
	}

	public String getTelephone() {
		
		return telephone;
		
	}

	public void setTelephone(String telephone) {
		
		this.telephone = telephone;
		
	}

	public Utilisateur getUtilisateur() {
		
		return utilisateur;
		
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		
		this.utilisateur = utilisateur;
		
	}

	public HashMap<Exemplaire, Date> getLivresEmprunte() {
		
		return livresEmprunte;
		
	}

	public void setLivresEmprunte(HashMap<Exemplaire, Date> livresEmprunte) {
		
		this.livresEmprunte = livresEmprunte;
		
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		
		this.dateDeNaissance = dateDeNaissance;
		
	}

	@Override
	public String toString() {
		
		return "Adherent [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissanca=" + dateDeNaissance + ", email="
				+ email + ", adresse=" + adresse + "]";
		
	}
	
	
	public static class Builder {
		private String adherent_id;
		private String nom;
		private String prenom;
		private Date dateDeNaissance;
		private Date dateDeAdhession;
		private String email;
		private String adresse;
		private String telephone;
		private Utilisateur utilisateur;
		
		public Builder adherent_id(String adherent_id) {
			
			this.adherent_id = adherent_id;
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
		
		public Builder dateDeNaissance(Date dateDeNaissance) {
			
			this.dateDeNaissance = dateDeNaissance;
			return this;
			
		}
		
		public Builder dateDeAdhession(Date dateDeAdhession) {
			
			this.dateDeAdhession = dateDeAdhession;
			return this;
			
		}
		
		public Builder email(String email) {
			
			this.email = email;
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
		
		public Builder utilisateur(Utilisateur utilisateur) {
			
			this.utilisateur = utilisateur;
			return this;
			
		}

		public Adherent build() {
			
			if (this.prenom == null) {
				throw new IllegalStateException("Le prenom est obligatoire");
			}
			
			if (this.nom == null) {
				throw new IllegalStateException("Le nom est obligatoire");
			}
			
			return new Adherent(this);
			
		}
	}
	
}
