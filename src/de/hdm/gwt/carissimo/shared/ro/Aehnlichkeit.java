package de.hdm.gwt.carissimo.shared.ro;

public class Aehnlichkeit {

	//Attribut deklarieren
	private int aehnlichkeit;
	
	//Konstruktoren
	public Aehnlichkeit() {
		
	}
	
	public Aehnlichkeit (int am){
		aehnlichkeit = am;
	}
	
	//Auslesen von Aehnlichkeit
	public int getAehnlichkeit(){
		return aehnlichkeit;
	}
	
	//Setzen von Aehnlichkeit
	public void setAehnlichkeit(int aehnlichkeit){
		this.aehnlichkeit = aehnlichkeit;
	}
	
}
