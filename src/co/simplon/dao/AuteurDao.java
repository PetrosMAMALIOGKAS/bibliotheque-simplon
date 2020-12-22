package co.simplon.dao;

import java.util.List;
import co.simplon.model.Auteur;

public interface AuteurDao {
	
	List<Auteur> lister();
	Auteur getAuteurById(int id_auteur);
	
}
