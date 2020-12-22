package co.simplon.dao;

public class MenuLigne {
	private String label;
	private String lien;
	private String args;

	
	private MenuLigne(Builder builder) {
		
		this.label = builder.label;
		this.lien = builder.lien;
		this.args = builder.args;
		
	}
	
	
	public String getLabel() {
		
		return label;
		
	}


	public void setLabel(String label) {
		
		this.label = label;
		
	}


	public String getLien() {
		
		return lien;
		
	}


	public void setLien(String lien) {
		
		this.lien = lien;
		
	}

	
	public String getArgs() {
		
		return args;
		
	}

	public void setArgs(String args) {
		
		this.args = args;
		
	}
	
	public String afficheLigne() {
		
		String adresse = this.lien;
		String result = "<a href=" + adresse + ">" + this.label + "</a>";
		return result;
		
	}


	public static class Builder {
		private String label;
		private String lien;
		private String args;

		public Builder label(String label) {
			
			this.label = label;
			return this;
			
		}

		public Builder lien(String lien) {
			
			this.lien = lien;
			return this;
			
		}

		public Builder args(String args) {
			
			this.args = args;
			return this;
			
		}

		public MenuLigne build() {
			
			return new MenuLigne(this);
			
		}
	}


}
