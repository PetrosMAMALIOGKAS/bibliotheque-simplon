package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.general.Messages;
import co.simplon.model.Auteur;
import co.simplon.model.Genre;
import co.simplon.model.Livre;

public class LivreDaoImpl implements LivreDao {
	private DaoContext daocontext;
	
	public LivreDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}
	
	@Override
	public void ajouter(Livre livre) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO livre VALUES (null, ?,?,?);";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, livre.getTitre());
			preparedStatement.setInt(2, Integer.parseInt(livre.getAuteur().getId_auteur()));
			preparedStatement.setInt(3, Integer.parseInt(livre.getGenre().getGenre_id()));
			preparedStatement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			
			Messages.addErrorMessage("Probleme d'insertion dans la BDD");
			e.printStackTrace();
			
		}
		
		Messages.addInfoMessage("le livre " + livre.getTitre() + " a ete ajoute dans La BDD");
	}
	
	
	@Override
	public List<Livre> lister() {
		
		List<Livre> listLivres = new ArrayList<Livre>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM livre;";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				listLivres.add(new Livre.Builder()
										.id(result.getString(1))
										.titre(result.getString(2))
										.build());  
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listLivres;
		
	}
	
	@Override
	public List<Livre> listerParTheme(int idTheme) {
		
		List<Livre> listLivres = new ArrayList<Livre>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM livre WHERE genre = ?;";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idTheme);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				
				listLivres.add(new Livre.Builder()
										.id(Integer.toString(result.getInt(1)))
										.titre(result.getString(2))
										.build());  
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return listLivres;
		
	}

	@Override
	public Livre getLivreById(String livre_id) {
		
		Livre livre = new Livre.Builder().build();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM livre WHERE livre_id = ?;";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(livre_id));
			result = preparedStatement.executeQuery();
			livre.setId(livre_id);
		
			result.next();
				livre.setTitre(result.getString(2));
				livre.setAuteur(new Auteur.Builder().id_auteur(Integer.toString(result.getInt(3))).build());
				livre.setGenre(new Genre.Builder().genre_id(Integer.toString(result.getInt(4))).build());
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return livre;
	}

	@Override
	public void modifier(Livre livre) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "UPDATE  livre SET titre = ?, auteur= ?, genre =? WHERE livre_id = ?;";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(4, Integer.parseInt(livre.getId()));
			preparedStatement.setString(1, livre.getTitre());
			preparedStatement.setInt(2, Integer.parseInt(livre.getAuteur().getId_auteur()));
			preparedStatement.setInt(3, Integer.parseInt(livre.getGenre().getGenre_id()));
			preparedStatement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			
			Messages.addErrorMessage("SQL Error during mofification of " + livre.getTitre());
			e.printStackTrace();
			
		}
		Messages.addInfoMessage(livre.getTitre() + " modified");
	}

	@Override
	public void supprimerLivreById(String livre_id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "DELETE FROM livre WHERE livre_id = ?;";
		
		try {
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(livre_id));
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			
			Messages.addErrorMessage("SQL Error during delete");
			e.printStackTrace();
			
		}
		
		Messages.addInfoMessage("Deleted ");
	}
	
}






