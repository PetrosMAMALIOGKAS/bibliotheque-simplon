package co.simplon.model;

public class Utilisateur {
	String utilisateur_id;
	String email;
	String password;
	
	private Utilisateur(Builder builder) {
		this.utilisateur_id = builder.utilisateur_id;
		this.email = builder.email;
		this.password = builder.password;
	}
	
	

	public String getUtilisateur_id() {
		
		return utilisateur_id;
		
	}


	public void setUtilisateur_id(String utilisateur_id) {
		
		this.utilisateur_id = utilisateur_id;
		
	}


	public String getEmail() {
		
		return email;
		
	}


	public void setEmail(String email) {
		
		this.email = email;
		
	}
	

	public String getPassword() {
		
		return password;
		
	}


	public void setPassword(String password) {
		
		this.password = password;
		
	}

	
	@Override
	public String toString() {
		return "Utilisateur [utilisateur_id=" + utilisateur_id + ", email=" + email + ", password=" + password + "]";
	}


	public static class Builder {
		private String utilisateur_id;
		private String email;
		private String password;

		public Builder utilisateur_id(String utilisateur_id) {
			this.utilisateur_id = utilisateur_id;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Utilisateur build() {
			return new Utilisateur(this);
		}
	}

	
}
