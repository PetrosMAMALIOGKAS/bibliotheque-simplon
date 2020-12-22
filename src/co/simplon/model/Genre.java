package co.simplon.model;

public class Genre {
	private String genre_id;
	private String nom;

	private Genre(Builder builder) {
		
		this.genre_id = builder.genre_id;
		this.nom = builder.nom;
		
	}

	public String getGenre_id() {
		
		return genre_id;
		
	}

	public void setGenre_id(String genre_id) {
		
		this.genre_id = genre_id;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom) {
		
		this.nom = nom;
		
	}

	@Override
	public String toString() {
		
		return "Genre [genre_id=" + genre_id + ", nom=" + nom + "]";
		
	}

	public static class Builder {
		private String genre_id;
		private String nom;
		
		public Builder genre_id(String genre_id) {
			
			this.genre_id = genre_id;
			return this;
			
		}

		public Builder nom(String nom) {
			
			this.nom = nom;
			return this;
			
		}

		public Genre build() {
			
			return new Genre(this);
			
		}
	}

}
