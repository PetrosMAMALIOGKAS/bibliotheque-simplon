package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoContext {
	
	private static Connection conn;
	
	public static Connection getConnection() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/bibliotheque_simplon?serverTimezone=UTC","root","root");
			return conn;
		}
		catch(Exception e){
			System.out.println(e); 
		}
		return null;
	}
	
	public LivreDao getLivreDao() {
		
		return new LivreDaoImpl(this);
		
	}
	
	public GenreDao getGenreDao() {
		
		return new GenreDaoImpl(this);
		
	}
	
	public UtilisateurDao getUtilisateurDao() {
		
		return new UtilisateurDaoImpl(this);
		
	}
	
	public AdherentDao getAdherentDao() {
		
		return new AdherentDaoImpl(this);
		
	}
	
	public AuteurDao getAuteurDao() {
		
		return new AuteurDaoImpl(this);
	}

}