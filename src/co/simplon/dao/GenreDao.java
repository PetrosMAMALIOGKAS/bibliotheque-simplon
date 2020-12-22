package co.simplon.dao;

import java.util.List;
import co.simplon.model.Genre;

public interface GenreDao {
	
	List<Genre> lister();
	Genre getGenreById(int id_genre);

}
