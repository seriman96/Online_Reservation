package ml.bdd_package_org.rh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import ml.objet_beans_org.rh.Appartement;
import ml.objet_beans_org.rh.Client;
import ml.objet_beans_org.rh.Loggin;
//import ml.objet_beans_org.rh.Employe;
/*import ml.objet_beans_org.rh.Reservation;
import ml.objet_beans_org.rh.Salle;*/
import ml.objet_beans_org.rh.Tarif;

public class OptionImple implements Option {
	
	private ConnectionAlaBase chargement_Bdd;
	private static Connection connexion = null;
	public int soldeUser ; 
	
	
	//public int somme_Recu ;
	//public	int somme_Rest;
	
	public OptionImple(ConnectionAlaBase chargement_Bdd) {
		this.chargement_Bdd = chargement_Bdd;
	}

	@Override
	public void ajoutCl(Client cl,Tarif reserv_Clt) throws DaoException {
		 PreparedStatement req_prepare = null;
		    
		/* reBanque();
		int userSolde =  soldeUser;
		Reservation res = new Reservation();
		int frs = res.getFraisR();*/
		 if(soldeUser == 0) {
			 throw new DaoException("Le compte que vous avez saisi n'existe pas, Veuillez revoir votre numero de compte.");
			}
		 else if(soldeUser >= reserv_Clt.getFraisR()) {
			try {
				connexion = chargement_Bdd.getConnection();
				req_prepare = connexion.prepareStatement("INSERT INTO client(NomCl,PrenomCl,ContactCl,Age,compte,Email) VALUES(?,?,?,?,?,?);");
				req_prepare.setString(1, cl.getNomCl()); 
				req_prepare.setString(2, cl.getPrenomCl());
				
				req_prepare.setInt(3, cl.getContact()); 
				req_prepare.setInt(4, cl.getAge());
				
				req_prepare.setString(5, cl.getCompte()); 
				req_prepare.setString(6, cl.getEmail());
				
				req_prepare.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				
				try {
					if(req_prepare != null) {
						req_prepare.close();
					}
					if(connexion != null) {
						connexion.close();
					}
					
				} catch (SQLException e2) {
					
				}
			}
		}else {
			throw new DaoException("votre compte est insuffisant pour la reservation demandée.");
		}
		    

	}

	

	@Override
	public void ajoutRe(Tarif reserv) throws DaoException {
		PreparedStatement req_preparerR = null;
		
		/* reBanque();
		int userSolde =  soldeUser;
		Reservation res = new Reservation();
		int frs = res.getFraisR();*/
		 if(soldeUser == 0) {
			 throw new DaoException("Le compte que vous avez saisi n'existe pas, Veuillez revoir votre numero de compte.");
			}
		 else if(soldeUser >= reserv.getFraisR()) {
			try {
				connexion = chargement_Bdd.getConnection();
				req_preparerR = connexion.prepareStatement("INSERT INTO reservation(DebutR,FinR,ModeR,FraisR,SommeRecu,SommeRest) VALUES(?,?,?,?,?,?);");
				req_preparerR.setString(1, reserv.getDebutR());
				req_preparerR.setString(2, reserv.getFinR());
				req_preparerR.setString(3, reserv.getModeR());
				req_preparerR.setInt(4, reserv.getFraisR());
				if(reserv.getModeR().equals("Reservation simple") || reserv.getModeR().equals("Tout payé")) {
					req_preparerR.setInt(5, reserv.getSommeRecue_S_T());
				}else {
					req_preparerR.setInt(5, reserv.getSommeRecu());
				}
				req_preparerR.setInt(6, reserv.getSommeRestant());
				req_preparerR.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(req_preparerR != null) {
						req_preparerR.close();
					}
					if(connexion != null) {
						connexion.close();
					}
					
				} catch (SQLException e2) {
					
				}
			}	
		}else {
			throw new DaoException("votre compte est insuffisant pour la reservation demandée.");
		}/**/
			
		

	}

	

	@Override
	public void ajoutTar(Tarif tar) throws DaoException {
		PreparedStatement req_preparerT = null;
		
		/* reBanque();
		int userSolde =  soldeUser;
		Reservation res = new Reservation();
		int frs = res.getFraisR();*/
		 if(soldeUser == 0) {
			 throw new DaoException("Le compte que vous avez saisi n'existe pas, Veuillez revoir votre numero de compte.");
			}
		 else if(soldeUser >= tar.getFraisR()) {
			try {
				connexion = chargement_Bdd.getConnection();
				req_preparerT = connexion.prepareStatement("INSERT INTO tarif(PrixJ,Sejour,PrixS) VALUES(?,?,?);");
			
				req_preparerT.setInt(1, tar.getPrixJ());
				req_preparerT.setInt(2, tar.getSejour());
				req_preparerT.setInt(3, tar.getPrixS());
				req_preparerT.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(req_preparerT != null) {
						req_preparerT.close();
					}
					if(connexion != null) {
						connexion.close();
					}
					
				} catch (SQLException e2) {
					
				}
			}	
		}else {
			throw new DaoException("votre compte est insuffisant pour la reservation demandée.");
		}/**/

	}

	@Override
	public List<Client> sortieAclient() {
		//prevoir une boucle for pour le nbre de salle ou appa (taille) ou ajouter au condition dans les ajout et select
		//int contactUser
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
        List<Client> cl = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM client ORDER BY IdCl DESC LIMIT 1;");
				//req_prepare.setInt(1, contactUser);ContactCl like ?
				//req_prepare.setInt(1, "%"+contactUser+"%");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie client.
				int idCl = resultat.getInt("IdCl");
				String nomC = resultat.getString("NomCl");
				String prenomC = resultat.getString("PrenomCl");
				int contactC = resultat.getInt("ContactCl");
				int ageC = resultat.getInt("Age");
				String compteC = resultat.getString("compte");
				String emailC = resultat.getString("Email");
				
				//table client
				Client util = new Client();
				util.setIdCl(idCl);
				util.setNomCl(nomC);
				util.setPrenomCl(prenomC);
				util.setContact(contactC);
				util.setAge(ageC);
				util.setCompte(compteC);
				util.setEmail(emailC);
				
				cl.add(util);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return cl;
	}
	
	@Override
	public List<Tarif> sortieReservation() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
        List<Tarif> reser = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM reservation ORDER BY IdR DESC LIMIT 1;");
				//req_prepare.setString(1, "%"+finRes+"%");String finRes
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie reservation
				int idRe = resultat.getInt("IdR");
				String debutReser = resultat.getString("DebutR");
				String finReser = resultat.getString("FinR");
				String modeReser = resultat.getString("ModeR");
				int fraisReser = resultat.getInt("FraisR");//à revoir
				int sommeRe = resultat.getInt("SommeRecu");
				int sommeRes = resultat.getInt("SommeRest");//à revoir
				
				//table reservation
				Tarif res = new Tarif();
				res.setIdRe(idRe);
				res.setDebutRe(debutReser);
				res.setFinRe(finReser);
				res.setModeR(modeReser);
				res.setFraisR(fraisReser);
				//if(modeReser.equals("Reservation simple") || modeReser.equals("Tout payé")) {
					//res.setSommeRecue_S_T(modeReser);
				//}else {
					res.setSommeRecue(sommeRe);
				//}
				res.setSommeRestant(sommeRes);//à revoir
				
				reser.add(res);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			//a revoir valable pour tout les finally
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return reser;
	}

	@Override
	public List<Tarif> sortieTarif() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
        List<Tarif> tarf = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				//"SELECT * FROM tarif WHERE IdT = MAX(IdT);"
				req_prepare = connexion.prepareStatement("SELECT * FROM tarif ORDER BY IdT DESC LIMIT 1;");
				//req_prepare.setString(1, "%"+sejr+"%");Sejour like ?;int sejr
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie tarif
				int idTari = resultat.getInt("IdT");
				int prix_base = resultat.getInt("PrixJ");
				int sej = resultat.getInt("Sejour");
				int prix_tot = resultat.getInt("PrixS");
				
				//table tarif
				Tarif trf = new Tarif();
				trf.setIdTari(idTari);
				trf.setPrixJ(prix_base);
				trf.setSejour(sej);
				trf.setPrixS(prix_tot);
				
				tarf.add(trf);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return tarf;
	}
	

	@Override
	public List<Tarif> sortieAppart(String typeAprt) {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		List<Tarif> apa = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM appartement WHERE TypeA like ? ORDER BY NumA DESC LIMIT 1;");
				req_prepare.setString(1, "%"+typeAprt+"%");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie appartement
				int idAp = resultat.getInt("NumA");
				String typA = resultat.getString("TypeA");
				
				//table appa
				Tarif apt = new Tarif();
				apt.setIdAp(idAp);
				apt.setTypeAp(typA);
				
				apa.add(apt);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return apa;	
	}

	@Override
	public List<Tarif> sortieSalle(String typeSall) {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		List<Tarif> sals = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM salle WHERE TypeS like ? ORDER BY NumS DESC LIMIT 1;");
				req_prepare.setString(1, "%"+typeSall+"%");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie salle
				int idSl = resultat.getInt("NumS");
				String typS = resultat.getString("TypeS");
				
				//table salle
				Tarif sall = new Tarif();
				sall.setIdSl(idSl);
				sall.setTypeSa(typS);
				
				sals.add(sall);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return sals;
	} 
	
	@Override
	/**/public void reBanque(Client clt) {
		Statement req_non_prepar = null;
		ResultSet resultatB = null;
		try {
			connexion = chargement_Bdd.getConnection();
			
			req_non_prepar = connexion.createStatement();
		
			resultatB = req_non_prepar.executeQuery("SELECT NumCompte,SoldeB FROM banque;");
			while(resultatB.next()) {
				//partie client.
				String numCo = resultatB.getString("NumCompte");
				if(numCo.equals(clt.getCompte())) {
					soldeUser = resultatB.getInt("SoldeB")	;
				}/*else {
					System.out.println("Le compte que vous avez saisi n'existe pas, revoir votre numero de compte.");
				}*/
				
				
			}
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(resultatB != null) {
					resultatB.close();
				}
				if(req_non_prepar != null) {
					req_non_prepar.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
	}/**/

	@Override
	public void authentification(Loggin logge) {
		Statement req_non_prepar = null;
		ResultSet resultatB = null;
		//String teste="";
		try {
			connexion = chargement_Bdd.getConnection();
			
			req_non_prepar = connexion.createStatement();
		
			resultatB = req_non_prepar.executeQuery("SELECT Login,Pasword FROM chef_hotel;");
			while(resultatB.next()) {
				
				String logg = resultatB.getString("Login");
				String pass = resultatB.getString("Pasword");
				if(logg.equals(logge.getLogin()) && pass.equals(logge.getPassword())) {
					//teste = logg;
					Loggin log = new Loggin();
					log.setLogin(logg);
					log.setPassword(pass);
				}/*else {
					teste = "";
				}*/
				
				
			}
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(resultatB != null) {
					resultatB.close();
				}
				if(req_non_prepar != null) {
					req_non_prepar.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		//return teste;
	}

	@Override
	public List<Client> selectAclient() {
		
				PreparedStatement req_prepare = null;
				ResultSet resultat = null;
		        List<Client> cl = new ArrayList<>();
				
					try {
						connexion = chargement_Bdd.getConnection();
						
						req_prepare = connexion.prepareStatement("SELECT * FROM client;");
						
						resultat = req_prepare.executeQuery();
					
			
					while(resultat.next()) {
						
						//partie client.
						int idCl = resultat.getInt("IdCl");
						String nomC = resultat.getString("NomCl");
						String prenomC = resultat.getString("PrenomCl");
						int contactC = resultat.getInt("ContactCl");
						int ageC = resultat.getInt("Age");
						String compteC = resultat.getString("compte");
						String emailC = resultat.getString("Email");
						
						//table client
						Client util = new Client();
						util.setIdCl(idCl);
						util.setNomCl(nomC);
						util.setPrenomCl(prenomC);
						util.setContact(contactC);
						util.setAge(ageC);
						util.setCompte(compteC);
						util.setEmail(emailC);
						
						cl.add(util);
						
					}
					
				} catch (SQLException e) {
					
				}finally {
					try {
						if(resultat != null) {
							resultat.close();
						}
						if(req_prepare != null) {
							req_prepare.close();
						}
						if(connexion != null) {
							connexion.close();
						}
						
					} catch (SQLException e2) {
						// TODO: handle exception 
					}
				}
				return cl;
	}

	@Override
	public List<Tarif> selectReservation() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
        List<Tarif> reser = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM reservation ;");
				
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie reservation
				int idRe = resultat.getInt("IdR");
				String debutReser = resultat.getString("DebutR");
				String finReser = resultat.getString("FinR");
				String modeReser = resultat.getString("ModeR");
				int fraisReser = resultat.getInt("FraisR");
				int sommeRe = resultat.getInt("SommeRecu");
				int sommeRes = resultat.getInt("SommeRest");
				
				//table reservation
				Tarif res = new Tarif();
				res.setIdRe(idRe);
				res.setDebutRe(debutReser);
				res.setFinRe(finReser);
				res.setModeR(modeReser);
				res.setFraisR(fraisReser);
				res.setSommeRecue(sommeRe);
				res.setSommeRestant(sommeRes);
				
				reser.add(res);
				
			}
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return reser;
	}

	@Override
	public List<Tarif> selectTarif() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
        List<Tarif> tarf = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM tarif ;");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie tarif
				int idTari = resultat.getInt("IdT");
				int prix_base = resultat.getInt("PrixJ");
				int sej = resultat.getInt("Sejour");
				int prix_tot = resultat.getInt("PrixS");
				
				//table tarif
				Tarif trf = new Tarif();
				trf.setIdTari(idTari);
				trf.setPrixJ(prix_base);
				trf.setSejour(sej);
				trf.setPrixS(prix_tot);
				
				tarf.add(trf);
				
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return tarf;
	}

	@Override
	public List<Tarif> selectAppart() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		List<Tarif> apa = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM appartement;");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie appartement
				int idAp = resultat.getInt("NumA");
				String typA = resultat.getString("TypeA");
				
				//table appa
				Tarif apt = new Tarif();
				apt.setIdAp(idAp);
				apt.setTypeAp(typA);
				
				apa.add(apt);
				
			}
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return apa;
	}

	@Override
	public List<Tarif> selectSalle() {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		List<Tarif> sals = new ArrayList<>();
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("SELECT * FROM salle;");
				resultat = req_prepare.executeQuery();
			
	
			while(resultat.next()) {
				
				//partie salle
				int idSl = resultat.getInt("NumS");
				String typS = resultat.getString("TypeS");
				
				//table salle
				Tarif sall = new Tarif();
				sall.setIdSl(idSl);
				sall.setTypeSa(typS);
				
				sals.add(sall);
				
			}
			
		} catch (SQLException e) {
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		return sals;
	}

	
	
	@Override
	public void supprimerCl(int idcle) {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("delete FROM client WHERE IdCl = ?;");
				req_prepare.setInt(1, idcle);
				req_prepare.executeUpdate();
		} catch (SQLException e) {
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		
	}
	
	/*@Override
	public void supprimerRe(int idrese) {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("delete FROM reservation WHERE IdR = ? ;");
				
				req_prepare.setInt(1, idrese);
				req_prepare.executeUpdate();
		} catch (SQLException e) {
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		
	}

	@Override
	public void supprimerTr(int idtfr) {
		PreparedStatement req_prepare = null;
		ResultSet resultat = null;
		
			try {
				connexion = chargement_Bdd.getConnection();
				
				req_prepare = connexion.prepareStatement("delete FROM tarif WHERE IdT = ?;");
				req_prepare.setInt(1, idtfr);
				req_prepare.executeUpdate();
		} catch (SQLException e) {
		}finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(req_prepare != null) {
					req_prepare.close();
				}
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception 
			}
		}
		
	}*/
	
	/*public static void main(String args[]) {
		Client cls = new Client();
		System.out.println(cls.getCompte());
	}*/

}
