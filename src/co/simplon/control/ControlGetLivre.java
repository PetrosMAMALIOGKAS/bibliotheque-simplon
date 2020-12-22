package co.simplon.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.AuteurDao;
import co.simplon.dao.DaoContext;
import co.simplon.dao.GenreDao;
import co.simplon.dao.LivreDao;
import co.simplon.model.Auteur;
import co.simplon.model.Genre;
import co.simplon.model.Livre;

/**
 * Servlet implementation class ControlGetLivre
 */
@WebServlet("/ControlGetLivre")
public class ControlGetLivre extends HttpServlet {
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
     * @see HttpServlet#HttpServlet()
     */
    public ControlGetLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Auteur> listAuteurs =  (ArrayList<Auteur>) auteurDao.lister();
		ArrayList<Genre>  listGenres  =  (ArrayList<Genre>) genreDao.lister();
		
		String livre_id = request.getParameter("livre_id");
		
		Livre livrePourModifier = livreDao.getLivreById(livre_id);
		
		request.setAttribute("listAuteurs", listAuteurs);
		request.setAttribute("listGenres", listGenres);
		request.setAttribute("livrePourModifier", livrePourModifier);
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/modificationLivre.jsp").forward(request, response);
	}

}
