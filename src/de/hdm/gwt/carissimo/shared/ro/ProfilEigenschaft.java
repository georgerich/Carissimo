package de.hdm.gwt.carissimo.shared.ro;

import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Info;

public class ProfilEigenschaft extends ProfilInformation {
	
	private Eigenschaft eigenschaft;
	private Info info;
	
	//Auslesen von Eigenschaft
	public Eigenschaft getEigenschaft(){
		return eigenschaft;
	}
	
	//Setzen von Eigenschaft
	public void setEigenschaft(Eigenschaft eigenschaft){
		this.eigenschaft = eigenschaft;
	}
	
	//Auslesen von Info
	public Info getInfo(){
		return this.info;
	}
	
	//Setzen von Info
	public void setInfo (Info info){
		this.info = info;
	}
	
	
	/**
	 * Überschreiben der Superklasse @class ProfilInformation
	 */
	public String getName() {
		return eigenschaft.getEigenschaft();
	}
	
	public void setName (String name){
		this.eigenschaft.setEigenschaft(name);
	}
	
	public String getValue(){
		return info.getValue();
	}
	
	public void setValue (String value){
		this.info.setValue(value);
	}
	
}
