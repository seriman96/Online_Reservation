package ml.bdd_package_org.rh;

import java.util.List;

//import ml.objet_beans_org.rh.Appartement;
//import ml.objet_beans_org.rh.Appartement;
import ml.objet_beans_org.rh.Client;
import ml.objet_beans_org.rh.Loggin;
//import ml.objet_beans_org.rh.Employe;
/*import ml.objet_beans_org.rh.Reservation;
import ml.objet_beans_org.rh.Salle;*/
//import ml.objet_beans_org.rh.Salle;
import ml.objet_beans_org.rh.Tarif;

public interface Option {
	
	void ajoutCl(Client cl,Tarif reserv_Clt) throws DaoException;
	void ajoutRe(Tarif reserv) throws DaoException;
	void ajoutTar(Tarif tar) throws DaoException;
	void reBanque(Client clt);
	List<Client> sortieAclient();
	List<Tarif> sortieReservation();
	List<Tarif> sortieTarif();
	List<Tarif> sortieAppart(String typeAprt);
	List<Tarif> sortieSalle(String typeSall);
	void authentification(Loggin logge);
	List<Client> selectAclient();
	List<Tarif> selectReservation();
	List<Tarif> selectTarif();
	List<Tarif> selectAppart();
	List<Tarif> selectSalle();
	void supprimerCl(int idcle);
	/*void supprimerRe(int idrese);
	void supprimerTr(int idtfr);*/

}
