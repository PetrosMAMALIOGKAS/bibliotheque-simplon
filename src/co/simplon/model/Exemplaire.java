package co.simplon.model;

public class Exemplaire {
	private String id_exemplaire;
	private Livre livre;
	private Editeur editeur;
	private String anneAquisition;
	private Rayon rayon;

	private Exemplaire(Builder builder) {
		
		this.livre = builder.livre;
		this.editeur = builder.editeur;
		this.anneAquisition = builder.anneAquisition;
		this.rayon = builder.rayon;
		
	}

	public String getId_exemplaire() {
		
		return id_exemplaire;
		
	}

	public void setId_exemplaire(String id_exemplaire) {
		
		this.id_exemplaire = id_exemplaire;
		
	}

	public Livre getLivre() {
		
		return livre;
		
	}

	public void setLivre(Livre livre) {
		
		this.livre = livre;
		
	}

	public Editeur getEditeur() {
		
		return editeur;
		
	}

	public void setEditeur(Editeur editeur) {
		
		this.editeur = editeur;
		
	}

	public String getAnneAquisition() {
		
		return anneAquisition;
		
	}

	public void setAnneAquisition(String anneAquisition) {
		
		this.anneAquisition = anneAquisition;
		
	}

	public Rayon getRayon() {
		
		return rayon;
		
	}

	public void setRayon(Rayon rayon) {
		
		this.rayon = rayon;
		
	}

	@Override
	public String toString() {
		
		return "Exemplaire [id_exemplaire=" + id_exemplaire + ", livre=" + livre + ", editeur=" + editeur
				+ ", anneEdition=" + anneAquisition + "]";
		
	}

	public static class Builder {
		private Livre livre;
		private Editeur editeur;
		private String anneAquisition;
		private Rayon rayon;

		public Builder livre(Livre livre) {
			
			this.livre = livre;
			return this;
			
		}

		public Builder editeur(Editeur editeur) {
			
			this.editeur = editeur;
			return this;
			
		}

		public Builder anneAquisition(String anneAquisition) {
			
			this.anneAquisition = anneAquisition;
			return this;
			
		}

		public Builder rayon(Rayon rayon) {
			
			this.rayon = rayon;
			return this;
			
		}

		public Exemplaire build() {
			
			return new Exemplaire(this);
			
		}
	}

}
