package co.simplon.dao;

import java.util.List;
import co.simplon.model.Livre;


public interface LivreDao {

	void ajouter(Livre livre);
	List<Livre> lister();
	List<Livre> listerParTheme(int idTheme);
	Livre getLivreById(String livre_id);
	void modifier(Livre livre);
	void supprimerLivreById(String livre_id);
}
