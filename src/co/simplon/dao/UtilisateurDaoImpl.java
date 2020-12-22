package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Genre;
import co.simplon.model.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private DaoContext daocontext;
	
	public UtilisateurDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}

	@Override
	public Utilisateur getUtilisateur(String email) {
		Utilisateur utilisateur = new Utilisateur.Builder().build();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM utilisateur WHERE email=?";
		
		try {
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setNString(1, email);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				utilisateur.setUtilisateur_id(Integer.toString(result.getInt(1)));
				utilisateur.setEmail(email);
				utilisateur.setPassword(result.getString(3));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return utilisateur;
	}

} 
