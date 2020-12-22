package co.simplon.control;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ControlListerLivres
 */
@WebServlet("/ControlListerLivres")
public class ControlListerLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
	private AuteurDao auteurDao;
	private GenreDao genreDao;
	
	public void init() {
		 
	    	DaoContext daoContext = new DaoContext();
	    	this.livreDao = daoContext.getLivreDao();
	    	this.auteurDao = daoContext.getAuteurDao();
	    	this.genreDao = daoContext.getGenreDao();
	    	
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlListerLivres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Livre> listLivres =  (ArrayList<Livre>) livreDao.lister();
		ArrayList<Auteur> listAuteurs =  (ArrayList<Auteur>) auteurDao.lister();
		ArrayList<Genre>  listGenres  =  (ArrayList<Genre>) genreDao.lister();
		
		request.setAttribute("listAuteurs", listAuteurs);
		request.setAttribute("listGenres", listGenres);
		request.setAttribute("listLivres", listLivres);
		response.setCharacterEncoding("UTF-8");
		
		this.getServletContext().getRequestDispatcher("/gestionLivres.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
