package de.hdm.gwt.carissimo.shared.ro;

public class ProfilInformation {
	
	private String name;
	private String value;
	
	public ProfilInformation(){	
	
	}
	
	public ProfilInformation(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	//Auslesen von Name
	public String getName() {
		return name;
	}
	
	//Setzen von Name
	public void setName(String name){
		this.name = name;
	}
	
	//Auslesen von Value
	public String getValue(){
		return value;
	}
	
	//Setzen von Value
	public void setValue(String value){
		this.value = value;
	}
	
}
