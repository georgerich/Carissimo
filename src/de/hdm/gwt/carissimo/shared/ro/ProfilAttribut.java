package de.hdm.gwt.carissimo.shared.ro;

public class ProfilAttribut extends ProfilInformation {
	
	//Auslesen von Name
	//mit super. wird in der Superklasse der Wert ueberschrieben
	public String getName(){
		return super.getName();
	}
	
	//Setzen von Name
	public void setName (String name){
		super.setName(name);
	}
	
	//Auslesen von Wert
	public String getValue() {
		return super.getValue();
	}
	
	//Setzen von Wert
	public void setValue(String value){
		super.setValue(value);
	}
	
}
