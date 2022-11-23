package ml.objet_beans_org.rh;

public abstract class Appartement {

	
	//private String typeA ;
	//public final int nbreAp = 30;
	
	/*public String getTypeA() {
		return typeA;
	}*/
	abstract public void setTypeA(String typeA);
	abstract public void setModeR(String modeR);
	abstract public void setDebutR(String debutR) throws BeansException;
	abstract public void setFinR(String finR)  throws BeansException;
	abstract public void setTypeS(String typeS);
	abstract public void setSommeRecue_S_T();
	abstract public void setSommeRestant();
	//{
		//this.typeA = typeA;
	//}
	
	/*public static void main(String args[]) {
		Appartement app = new Appartement();
				app.setTypeA("SINGLE APPART");
				System.out.println(app.getTypeA());
	}*/
	
}
