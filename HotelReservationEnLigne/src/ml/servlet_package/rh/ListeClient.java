package ml.servlet_package.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.bdd_package_org.rh.ConnectionAlaBase;
import ml.bdd_package_org.rh.Option;


@WebServlet("/ListeClient")
public class ListeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  Option acces;
    
    public void init() throws ServletException{
  
    	ConnectionAlaBase chargement_Bdd = ConnectionAlaBase.getInstance();
    	
    	this.acces = chargement_Bdd.getUtilisateur();
    	
    }   
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String liste = request.getParameter("lister");
		if(liste.equals("Lister_client")) {
			
			request.setAttribute("sortieClient", acces.selectAclient());
			request.setAttribute("sortieReservation", acces.selectReservation());
			request.setAttribute("sortieTarif", acces.selectTarif());
			request.setAttribute("sortieAppart", acces.selectAppart());
			request.setAttribute("sortieSal", acces.selectSalle());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
		}
	}

}
