package co.simplon.model;

public class Rayon {
	private String rayon_id;
	private String designation;


	private Rayon(Builder builder) {

		this.designation = builder.designation;
		
	}

	public String getRayon_id() {
		
		return rayon_id;
		
	}

	public void setRayon_id(String rayon_id) {
		
		this.rayon_id = rayon_id;
		
	}

	public String getDesignation() {
		
		return designation;
		
	}

	public void setDesignation(String designation) {
		
		this.designation = designation;
		
	}

	@Override
	public String toString() {
		
		return "Rayon [rayon_id=" + rayon_id + ", designation=" + designation + "]";
		
	}

	public static class Builder {
		private String designation;

		public Builder designation(String designation) {
			
			this.designation = designation;
			return this;
			
		}

		public Rayon build() {
			
			return new Rayon(this);
			
		}
	}

}
