package de.hdm.gwt.carissimo.shared.ro;

import java.util.Vector;

public class ProfilReport {

	
	//Vektoren für ProfilEigenschaften und ProfilAttribute
	
	private Vector<ProfilEigenschaft> eigenschaften = new Vector<ProfilEigenschaft>();
	private Vector<ProfilAttribut> attribute = new Vector<ProfilAttribut>();
	
	//Titel des Profils
	private String title;
	
	//Variable fuer Aehnlichkeit
	private Aehnlichkeit aehnlichkeit;
	
	//Hinzufuegen von Eigenschaften
	public void addEigenschaft(ProfilEigenschaft profileigenschaft){
		eigenschaften.add(profileigenschaft);
	}
	
	//Entfernen von Eigenschaften
	public void removeEigenschaft(ProfilEigenschaft profileigenschaft){
		eigenschaften.removeElement(profileigenschaft);
	}
	
	//Auslesen aller Eigenschaften
	public Vector<ProfilEigenschaft> getAllEigenschaften(){
		return eigenschaften;
	}
	
	//Hinzufuegen von Attributen
	public void addAttribut (ProfilAttribut profilattribut){
		attribute.add(profilattribut);
	}
	
	//Entfernen von Attributen
	public void removeAttribut (ProfilAttribut profilattribut){
		attribute.removeElement(profilattribut);
	}
	
	//Auslesen aller Attribute
	public Vector<ProfilAttribut> getAllAttribute() {
		return attribute;
	}
	
	//Auslesen von Titel
	public String getTitle(){
		return title;
	}
	
	//Setzen von Titel
	public void setTitle (String title){
		this.title = title;
	}
	
	//Aehnlichkeit auslesen
	public Aehnlichkeit getAehnlichkeit() {
		return aehnlichkeit;
	}
	
	//Aehnlichkeit setzen
	public void setAehnlichkeit (Aehnlichkeit aehnlichkeit) {
		this.aehnlichkeit = aehnlichkeit;
	}
	
}
