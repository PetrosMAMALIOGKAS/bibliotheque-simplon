package co.simplon.logic;

import co.simplon.dao.DaoContext;
import co.simplon.dao.UtilisateurDao;
import co.simplon.general.Messages;
import co.simplon.model.Utilisateur;

public class ConnectionLogic {
	private UtilisateurDao utilisateurDao;
	
		
	public ConnectionLogic() {
		super();
	}

	public void init() {
		 
	    	DaoContext daoContext = new DaoContext();
	    	this.utilisateurDao = daoContext.getUtilisateurDao();
	    	
	}
	
	public boolean connectUtilisateur(String email, String password) {
		
		init();
		Utilisateur utilisateur = utilisateurDao.getUtilisateur(email);
		
		if (utilisateur == null ) {
			Messages.addErrorMessage("email and/or password are not corrects");
			return false;
		}
		
		if (password != utilisateur.getPassword()) {
			Messages.addErrorMessage("email and/or password are not corrects");
			return false;
		}
		return true;
	}
	
	

}
