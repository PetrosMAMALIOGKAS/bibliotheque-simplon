package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Adherent;
import co.simplon.model.Genre;

public class AdherentDaoImpl implements AdherentDao {
	private DaoContext daocontext;
	
	public AdherentDaoImpl(DaoContext daocontext) {
		this.daocontext = daocontext;
	}

	@Override
	public List<Adherent> lister() {
		List<Adherent> listGenres = new ArrayList<Adherent>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String query = "SELECT * FROM adherent;";
		
		try {
			connection = DaoContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				listGenres.add(new Adherent.Builder()
										.build());  
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listGenres;
	}

	@Override
	public Adherent affiche(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
