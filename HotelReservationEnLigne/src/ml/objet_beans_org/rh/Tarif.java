package ml.objet_beans_org.rh;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Tarif extends Appartement implements Serializable{

	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int prixJ;
	private int sejour;
	private int prixS;
	private String typeA ;
	private String typeS ;
	private String modeR;
	private int fraisR;
	private int sommeRecu;
	private int sommeRecue_S_T;
	private int sommeRestant;
	private  String debutR;
	private String finR;
	public  int debutSej;
	public int finSej;
	public  int debut_moi;
	public int finS_moi;
	
	//tester
	
	private int idRe;
	private int idAp;
	private int idSl;
	private int idTari;
	
	
	public int getIdRe() {
		return idRe;
	}
	public void setIdRe(int idRe) {
		this.idRe = idRe;
	}
	public int getIdAp() {
		return idAp;
	}
	public void setIdAp(int idAp) {
		this.idAp = idAp;
	}
	public int getIdSl() {
		return idSl;
	}
	public void setIdSl(int idSl) {
		this.idSl = idSl;
	}
	public int getIdTari() {
		return idTari;
	}
	public void setIdTari(int idTari) {
		this.idTari = idTari;
	}
	
	public int getPrixJ() {
		return prixJ;
	}
	public void setPrixJ() {
		int prixJ = 50_000;
		if(typeA.equals("SINGLE APPART")) {
			this.prixJ = prixJ;
		}else if(typeA.equals("TWINS APPART")) {
			this.prixJ = 60_000;
		}else{
			this.prixJ = 70_000;
		}
	}
	/**/public void setPrixJS() {
		int prixJ = 100_000;
		if(typeS.equals("Salle de conférence")) {
			this.prixJ = prixJ;
		}else if(typeS.equals("Salle de réunion")) {
			this.prixJ = 100_000;
		}else {
			this.prixJ = 200_000;
		}
		
	}
	public void setPrixJ(int prixjr) {
		this.prixJ = prixjr;
		
	}
	
	public int getSejour() {
		return sejour;
	}
	public void setSejour() {
		if(debut_moi == finS_moi) {
			this.sejour = finSej - debutSej;
		}else {
			
		}
	}
	public void setSejour(int sejour) {
		
		this.sejour = sejour;
	}
	public int getPrixS() {
		return prixS;
	}
	public void setPrixS() {
		this.prixS = prixJ * sejour;
	}
	public void setPrixS(int prixsejour) {
		this.prixS = prixsejour;
	}
	
	@Override
	public void setTypeA(String typeA) {
		if(typeA.equals("SINGLE APPART")) {
			this.typeA = typeA;
		}else if(typeA.equals("TWINS APPART")) {
			this.typeA = typeA;	
		}else{
		     this.typeA = typeA;
		}
		
	}
	
	public void setTypeAp(String typeA) {
			this.typeA = typeA;
	}
	
	public String getTypeA() {
		return typeA;
	}
	
	@Override
	public void setModeR(String modeR) {
		this.modeR = modeR;
		
	}
	public String getModeR() {
		return modeR;
	}
	public int getFraisR() {
		return fraisR;
	}
	public void setFraisR() {
		int fres = 10_000;
		if(modeR.equals("Reservation simple")) {
			this.fraisR = fres;
		}else if(modeR.equals("Reservation avec avance")) {
			this.fraisR = fres/2;
		}else {
			this.fraisR = 0;
		}
		
	}
	public void setFraisR(int fres) {
			this.fraisR = fres;
	}
	public int getSommeRecu() {
		return sommeRecu;
	}

	public void setSommeRecu(int sommeRecu) throws BeansException {
		
		if(sommeRecu > fraisR && modeR.equals("Reservation avec avance")) {
			this.sommeRecu = sommeRecu;
		}else {
			throw new BeansException("Votre somme est insuffisant pour l'offre demandée.\nVous pouvez choisir la simple reservation");
			
		}
		
	}
	public void setSommeRecue(int sommeRecu) {
				this.sommeRecu = sommeRecu;
			
		}
	public int getSommeRestant() {
		return sommeRestant;
	}

	@Override
	public void setSommeRestant() {
		if(modeR.equals("Reservation simple")) {
			this.sommeRestant = prixS;
		}else if(modeR.equals("Reservation avec avance")) {
			this.sommeRestant = prixS - sommeRecu;
			
		}else {
			this.sommeRestant = 0;
		}
		
	}
	
	public void setSommeRestant(int somRes) {
			this.sommeRestant = somRes;
	}
	
	@Override
	public void setDebutR(String debutR) throws BeansException {
		Calendar mondate = new GregorianCalendar();
		   Date madate;
		try {
			madate = new SimpleDateFormat("d-MMMM-yyyy",Locale.FRENCH).parse(debutR);
			   mondate.setTime(madate);
			   int annee = mondate.get(Calendar.YEAR);
			   int mois = mondate.get(Calendar.MONDAY);
			   debut_moi = mois;
			   debutSej =  mondate.get(Calendar.DAY_OF_MONTH);
			   switch (mois) {
				case 0:
					this.debutR = debutSej + "-" + "janvier" + "-" + annee;
					break;
				case 1:
					this.debutR = debutSej + "-" + "février" + "-" + annee;
					break;
				case 2:
					this.debutR = debutSej + "-" + "mars" + "-" + annee;
					break;
				case 3:
					this.debutR = debutSej + "-" + "avril" + "-" + annee;
					break;
				case 4:
					this.debutR = debutSej + "-" + "mai" + "-" + annee;
					break;
				case 5:
					this.debutR = debutSej + "-" + "juin" + "-" + annee;
					break;
				case 6:
					this.debutR = debutSej + "-" + "juillet" + "-" + annee;
					break;
				case 7:
					this.debutR = debutSej + "-" + "août" + "-" + annee;
					break;
				case 8:
					this.debutR = debutSej + "-" + "septembre" + "-" + annee;
					break;
				case 9:
					this.debutR = debutSej + "-" + "octobre" + "-" + annee;
					break;
				case 10:
					this.debutR = debutSej + "-" + "novembre" + "-" + annee;
					break;
				case 11:
					this.debutR = debutSej + "-" + "décembre" + "-" + annee;
					break;
				default:
					throw new BeansException("Il n'ya pas de 13 mois dans le calendrier gregorien");
				}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setDebutRe(String debutR) {
		this.debutR = debutR;
	}
	
	@Override
	public void setFinR(String finR) throws BeansException {
		Calendar mondate = new GregorianCalendar();
		   Date madate;
		try {
			madate = new SimpleDateFormat("d-MMMM-yyyy",Locale.FRENCH).parse(finR);
			   mondate.setTime(madate);
			   int annee = mondate.get(Calendar.YEAR);
			   int mois = mondate.get(Calendar.MONDAY);
			   finS_moi = mois;
			   finSej =  mondate.get(Calendar.DAY_OF_MONTH);
			   
			   switch (mois) {
				case 0:
					this.finR = finSej + "-" + "janvier" + "-" + annee;
					break;
				case 1:
					this.finR = finSej + "-" + "février" + "-" + annee;
					break;
				case 2:
					this.finR = finSej + "-" + "mars" + "-" + annee;
					break;
				case 3:
					this.finR = finSej + "-" + "avril" + "-" + annee;
					break;
				case 4:
					this.finR = finSej + "-" + "mai" + "-" + annee;
					break;
				case 5:
					this.finR = finSej + "-" + "juin" + "-" + annee;
					break;
				case 6:
					this.finR = finSej + "-" + "juillet" + "-" + annee;
					break;
				case 7:
					this.finR = finSej + "-" + "août" + "-" + annee;
					break;
				case 8:
					this.finR = finSej + "-" + "septembre" + "-" + annee;
					break;
				case 9:
					this.finR = finSej + "-" + "octobre" + "-" + annee;
					break;
				case 10:
					this.finR = finSej + "-" + "novembre" + "-" + annee;
					break;
				case 11:
					this.finR = finSej + "-" + "décembre" + "-" + annee;
					break;
				default:
					throw new BeansException("Il n'ya pas de 13 mois dans le calendrier gregorien");
				}
			   
			   //this.finR = finSej + "-" + mois + "-" + annee;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setFinRe(String finR) {
		this.finR = finR;
	}
	
	public String getDebutR() {
		return debutR;
	}
	public String getFinR() {
		return finR;
	}
	@Override
	public void setTypeS(String typeS) {
		if(typeS.equals("salle de conférence")) {
			this.typeS = typeS;
		}else if(typeS.equals("salle de réunion")) {
			this.typeS = typeS;
		}else {
			this.typeS = typeS;
		}
		
		
	}
	
	public void setTypeSa(String typeS) {
			this.typeS = typeS;
	}
	
	public String getTypeS() {
		return typeS;
	}
	
	@Override
	public void setSommeRecue_S_T() {
		if(modeR.equals("Reservation simple")) {
			this.sommeRecue_S_T = fraisR;
			
		}else if(modeR.equals("Tout payé")){
			this.sommeRecue_S_T = prixS;
			//System.out.println(prixS);
		}
		
	}
	
	public void setSommeRecue_S_T(String modRes) {
		if(modRes.equals("Reservation simple")) {
			this.sommeRecue_S_T = fraisR;
			
		}else if(modRes.equals("Tout payé")){
			this.sommeRecue_S_T = prixS;
		}
		
	}
	
	public int getSommeRecue_S_T() {
		return sommeRecue_S_T;
	}
	
	/*public static void main(String args[]) {
	Tarif tare = new Tarif();
	//tare.setTypeA("SINGLE APPART");
			//tare.setPrixJ(0);
	//tare.setTypeS("Salle de réunion");
	//tare.setPrixJS();
	//tare.setDebutR("2-mars-2019");
	//tare.setFinR("février 10,2019");
	//tare.setSejour();
	//tare.setModeR("Reservation avec avance");
	//Reservation simple
	//tare.setModeR("Tout payé");
	//tare.setFraisR(10);
	//tare.setSommeRecu(20_000);
	//tare.setSommeRecue_S_T();
	//tare.setPrixS();
	
	//tare.setSommeRecue_S_T();
	//tare.setSommeRestant();.getSommeRestant()
	//System.out.println(tare.getDebutR());
			//System.out.println(tare.getPrixJ());//getPrixS() getTypeS()
}*/
	
	
	
}
