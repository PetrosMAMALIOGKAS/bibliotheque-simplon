package co.simplon.model;

public class CategorieProfessionnelle {
	private String categorie_professionnelle_id;
	private String nom;
	private String description;
	
	private CategorieProfessionnelle(Builder builder) {
		
		this.nom = builder.nom;
		this.description = builder.description;
		
	}

	public void setCategorie_professionnelle_id(String categorie_professionnelle_id) {
		
		this.categorie_professionnelle_id = categorie_professionnelle_id;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom) {
		
		this.nom = nom;
		
	}

	public String getDescription() {
		
		return description;
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}

	@Override
	public String toString() {
		
		return "CategorieProfessionnelle [categorie_professionnelle_id=" + categorie_professionnelle_id + ", nom=" + nom
				+ ", description=" + description + "]";
		
	}

	public static class Builder {
		private String nom;
		private String description;


		public Builder nom(String nom) {
		
			this.nom = nom;
			return this;
			
		}

		public Builder description(String description) {
			
			this.description = description;
			return this;
			
		}

		public CategorieProfessionnelle build() {
			
			return new CategorieProfessionnelle(this);
			
		}
	}

	
}
