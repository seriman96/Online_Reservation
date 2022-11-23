package ml.servlet_package.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.bdd_package_org.rh.ConnectionAlaBase;
import ml.bdd_package_org.rh.Option;
import ml.objet_beans_org.rh.Client;
import ml.objet_beans_org.rh.Loggin;


@WebServlet("/ConnectionLog")
public class ConnectionLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  Option acces;
    
    public void init() throws ServletException{
  
    	ConnectionAlaBase chargement_Bdd = ConnectionAlaBase.getInstance();
    	
    	this.acces = chargement_Bdd.getUtilisateur();
    	
    }   
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recue = request.getParameter("connection");
		if(recue.equals("suivant")) {
			
			Loggin lg = new Loggin();
			lg.setLogin(request.getParameter("log"));
			lg.setPassword(request.getParameter("pasword"));
			
			acces.authentification(lg);
			String logi = lg.getLogin();
			String pas = lg.getPassword();
			if(logi.equals("Admin") && pas.equals("Admin")) {
				request.setAttribute("message", "");
				this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Echec d'authentification");
				this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
			}
		}
		
	}

}
