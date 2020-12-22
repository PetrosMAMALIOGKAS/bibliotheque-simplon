package co.simplon.dao;

import co.simplon.model.Utilisateur;

public interface UtilisateurDao {
	
	Utilisateur getUtilisateur(String email);

}
