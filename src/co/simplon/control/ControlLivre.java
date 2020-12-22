package co.simplon.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.DaoContext;
import co.simplon.general.Messages;

/**
 * Servlet implementation class ControlLivre
 */
@WebServlet("/ControlLivre")
public class ControlLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		
    	
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choise = request.getParameter("choise");
		
		Messages.effaceMessages();
		
		switch (choise) {
		case "ControlListerLivres":
			
			this.getServletContext().getRequestDispatcher("/ControlListerLivres").forward(request, response);
			break;
		case "ControlListerLivresParTheme":
			
			this.getServletContext().getRequestDispatcher("/ControlListerLivresParTheme").forward(request, response);
			break;
		case "ControlAjouterLivre":
			
			this.getServletContext().getRequestDispatcher("/ControlAjouterLivre").forward(request, response);
			break;
		case "modifier":
			
			this.getServletContext().getRequestDispatcher("/ControlGetLivre").forward(request, response);
			break;	
		case "Supprimer":
			
			this.getServletContext().getRequestDispatcher("/ControlSupprimmerLivre").forward(request, response);
			break;
		case "":
			
			//  TO DO
			break;
		default :
			
			// TO DO
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
