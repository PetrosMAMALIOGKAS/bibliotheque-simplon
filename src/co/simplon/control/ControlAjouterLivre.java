package co.simplon.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.AuteurDao;
import co.simplon.dao.DaoContext;
import co.simplon.dao.GenreDao;
import co.simplon.dao.LivreDao;
import co.simplon.general.Messages;
import co.simplon.model.Auteur;
import co.simplon.model.Genre;
import co.simplon.model.Livre;

/**
 * Servlet implementation class ControlAjouterLivre
 */
@WebServlet("/ControlAjouterLivre")
public class ControlAjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuteurDao auteurDao;
	private GenreDao genreDao;
	private LivreDao livreDao;
	
	public void init() {
		 
	    	DaoContext daoContext = new DaoContext();
	    	this.auteurDao = daoContext.getAuteurDao();
	    	this.genreDao = daoContext.getGenreDao();
	    	this.livreDao = daoContext.getLivreDao();
	    	
	}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Auteur> listAuteurs =  (ArrayList<Auteur>) auteurDao.lister();
		ArrayList<Genre>  listGenres  =  (ArrayList<Genre>) genreDao.lister();
		
		request.setAttribute("listAuteurs", listAuteurs);
		request.setAttribute("listGenres", listGenres);
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/ajouterLivre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int genre_id = Integer.parseInt(request.getParameter("genre_id"));
		int auteur_id = Integer.parseInt(request.getParameter("auteur_id"));	
		
		String titre =  request.getParameter("titre");
		
		Auteur auteur = auteurDao.getAuteurById(auteur_id);
		Genre  genre  = genreDao.getGenreById(genre_id);
		
		Livre livre = new Livre.Builder()
							   .auteur(auteur)
							   .genre(genre)
							   .titre(titre)
							   .build();
		livreDao.ajouter(livre);
		
		ArrayList<String> messages = new ArrayList<String>();
		messages = Messages.getListMessages();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("messages", messages);
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
