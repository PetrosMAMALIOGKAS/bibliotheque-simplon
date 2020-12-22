package co.simplon.dao;

import java.util.List;
import co.simplon.model.Adherent;

public interface AdherentDao {
	
	List<Adherent> lister();
	Adherent affiche(String email);
	
}
