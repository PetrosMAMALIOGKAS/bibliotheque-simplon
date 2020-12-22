package co.simplon.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.simplon.dao.DaoContext;
import co.simplon.dao.GenreDao;
import co.simplon.dao.LivreDao;
import co.simplon.model.Genre;
import co.simplon.model.Livre;

/**
 * Servlet implementation class ControlListerLivresParTheme
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ControlListerLivresParTheme" })

public class ControlListerLivresParTheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
	private GenreDao genreDao;
	
	public void init() {
		 
	    	DaoContext daoContext = new DaoContext();
	    	this.livreDao = daoContext.getLivreDao();
	    	this.genreDao = daoContext.getGenreDao();
	    	
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlListerLivresParTheme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ArrayList<Genre> listGenres =  (ArrayList<Genre>) genreDao.lister();
			
			request.setAttribute("listGenres", listGenres);
			response.setCharacterEncoding("UTF-8");
			this.getServletContext().getRequestDispatcher("/listerLivresParGenre.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int genre = Integer.parseInt(request.getParameter("genre"));

		ArrayList<Livre> listLivresParTheme = new ArrayList<Livre>();
		listLivresParTheme = (ArrayList<Livre>) livreDao.listerParTheme(genre);
		
		Gson json = new Gson();
		String answer = json.toJson(listLivresParTheme);

	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(answer);
	}

}
