package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Adherent;
import co.simplon.model.Auteur;

public class AuteurDaoImpl implements AuteurDao {
	private DaoContext daocontext;
	
	public AuteurDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}

	@Override
	public List<Auteur> lister() {
		List<Auteur> listAuteurs = new ArrayList<Auteur>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM auteur;";
		
		try {
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				listAuteurs.add(new Auteur.Builder()
										.id_auteur(Integer.toString(result.getInt(1)))
										.nom(result.getString(2))
										.prenom(result.getString(3))
										.build());  
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listAuteurs;

	}
	
	@Override
	public Auteur getAuteurById(int id_auteur) {
		
		Auteur auteur = new Auteur.Builder().build();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM auteur WHERE auteur_id=?";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id_auteur);
			result = preparedStatement.executeQuery();
			
			auteur.setId_auteur(Integer.toString(id_auteur));
			auteur.setNom(result.getString(2));
			auteur.setPrenom(result.getString(3));
			auteur.setAdresse(result.getString(4));
			auteur.setTelephone(result.getString(5));
			
			System.out.println(auteur.toString());
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return auteur;
		
	}

}
