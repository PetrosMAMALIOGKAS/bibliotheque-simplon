package co.simplon.model;

public class Livre {
	private String id;
	private String titre;
	private Auteur auteur;
	private Genre genre;


	private Livre(Builder builder) {
		
		this.id = builder.id;
		this.titre = builder.titre;
		this.auteur = builder.auteur;
		this.genre = builder.genre;
		
	}

	public String getId() {
		
		return id;
		
	}

	public void setId(String id) {
		
		this.id = id;
		
	}

	public String getTitre() {
		
		return titre;
		
	}

	public void setTitre(String titre) {
		
		this.titre = titre;
		
	}

	public Auteur getAuteur() {
		
		return auteur;
		
	}

	public void setAuteur(Auteur auteur) {
		
		this.auteur = auteur;
		
	}

	public Genre getGenre() {
		
		return genre;
		
	}

	public void setGenre(Genre genre) {
		
		this.genre = genre;
		
	}

	

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", genre=" + genre + "]";
	}



	public static class Builder {
		private String id;
		private String titre;
		private Auteur auteur;
		private Genre genre;
		
		public Builder id(String id) {
			
			this.id = id;
			return this;
			
		}

		public Builder titre(String titre) {
			
			this.titre = titre;
			return this;
			
		}

		public Builder auteur(Auteur auteur) {
			
			this.auteur = auteur;
			return this;
			
		}

		public Builder genre(Genre genre) {
			
			this.genre = genre;
			return this;
			
		}

		public Livre build() {
			
			return new Livre(this);
			
		}
	}

}
