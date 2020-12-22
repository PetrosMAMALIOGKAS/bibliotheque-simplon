package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Auteur;
import co.simplon.model.Genre;


public class GenreDaoImpl implements GenreDao {
	private DaoContext daocontext;
	
	public GenreDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}

	@Override
	public List<Genre> lister() {
		
		List<Genre> listGenres = new ArrayList<Genre>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM genre;";
		
		try {
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				listGenres.add(new Genre.Builder()
										.genre_id(result.getString(1))
										.nom(result.getString(2))
										.build());  
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listGenres;
		
	}

	@Override
	public Genre getGenreById(int id_genre) {
		Genre genre = new Genre.Builder().build();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM genre WHERE genre_id=?";
		
		try {
			
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id_genre);
			result = preparedStatement.executeQuery();
			
			genre.setGenre_id(Integer.toString(id_genre));
			genre.setNom(result.getString(2));
		
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return genre;
	}

}
