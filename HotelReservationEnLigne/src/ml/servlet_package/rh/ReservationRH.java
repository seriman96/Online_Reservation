package ml.servlet_package.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.bdd_package_org.rh.ConnectionAlaBase;
import ml.bdd_package_org.rh.DaoException;
import ml.bdd_package_org.rh.Option;
import ml.objet_beans_org.rh.BeansException;
//import ml.objet_beans_org.rh.BeansExceptionAvance;
//import ml.objet_beans_org.rh.Appartement;
import ml.objet_beans_org.rh.Client;
//import ml.objet_beans_org.rh.Reservation;
import ml.objet_beans_org.rh.Tarif;


@WebServlet("/ReservationRH")
public class ReservationRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  Option acces;
    
    public void init() throws ServletException{
  
    	ConnectionAlaBase chargement_Bdd = ConnectionAlaBase.getInstance();
    	
    	this.acces = chargement_Bdd.getUtilisateur();
    	
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Formulaire_Appa.jsp").forward(request, response);
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recue = request.getParameter("reservation");
		if(recue.equals("Reserver")) {
			try {
			Client cls = new Client();
			cls.setNomCl(request.getParameter("nom"));
			cls.setPrenomCl(request.getParameter("prenom"));
			cls.setContact(Integer.parseInt(request.getParameter("contact")));
			cls.setAge(Integer.parseInt(request.getParameter("age")));
			cls.setCompte(request.getParameter("compte"));
			cls.setEmail(request.getParameter("email"));
			
			
			
			Tarif trf = new Tarif();
			trf.setTypeA(request.getParameter("type"));
			trf.setPrixJ();
			
				trf.setDebutR(request.getParameter("debut"));
			
				trf.setFinR(request.getParameter("fin"));
			
			trf.setSejour();
			trf.setModeR(request.getParameter("mode"));
			trf.setFraisR();
			trf.setPrixS();
			if(request.getParameter("mode").equals("Reservation simple") || request.getParameter("mode").equals("Tout payé")) {
				trf.setSommeRecue_S_T();
			}else {
				
					trf.setSommeRecu(Integer.parseInt(request.getParameter("avance")) );
				
			}
			
			trf.setSommeRestant();
			
			
			acces.reBanque(cls);
			
				acces.ajoutRe(trf);
			
				acces.ajoutTar(trf);
			
				acces.ajoutCl(cls,trf);
			
			
			
			
			}catch (DaoException e) {
				request.setAttribute("erreur", e.getMessage());
			}catch (BeansException e1) {
				request.setAttribute("erreur", e1.getMessage());
			}
			request.setAttribute("donneClient", acces.sortieAclient());
			request.setAttribute("donneReservation", acces.sortieReservation());
			request.setAttribute("donneTarif", acces.sortieTarif());
			request.setAttribute("donneAppart", acces.sortieAppart(request.getParameter("type")));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/RecueUser.jsp").forward(request, response);
		}else {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Formulaire_Appa.jsp").forward(request, response);
		}
		
	}

}
