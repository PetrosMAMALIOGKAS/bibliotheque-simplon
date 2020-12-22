package co.simplon.model;

public class Editeur {
	private String editeur_id;
	private String nom;
	private String adresse;

	private Editeur(Builder builder) {
		
		this.nom = builder.nom;
		this.adresse = builder.adresse;
		
	}

	public String getEditeur_id() {
		
		return editeur_id;
		
	}

	public void setEditeur_id(String editeur_id) {
		
		this.editeur_id = editeur_id;
		
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

	@Override
	public String toString() {
		
		return "Editeur [editeur_id=" + editeur_id + ", nom=" + nom + ", adresse=" + adresse + "]";
		
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

		public Editeur build() {
			
			return new Editeur(this);
			
		}
	}

}
