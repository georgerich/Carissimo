package de.hdm.gwt.carissimo.shared.bo;

/**
 * Realisierung einer exemplarischen Partnerb�rse. �ber die Auswahleigenschaft werden 
 * einem Profil bescheibende Attribute hinzugef�gt. Die Klasse Auswahleigenschaft erweitert
 * die Klasse Eigenschaft. Diese wiederum wird in einem Info-Objekt aggregiert. Eine Auswahl-
 * eigenschaft wird �ber eine ID eindeutugig identifizierbar und besitzt einen Wert (value).
 * Die Eigenschaft-ID kennzeichnet die Eigenschaft als eine Auswahleigenschaft.   
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Auswahleigenschaft extends Eigenschaft {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Deklaration der Instanzvariablen.
	 */
	
	private int auswahlId;
	private String value;
	private int eigenschaftId;
	
	
	/**
	 * Auslesen der Auswahl-ID
	 */
	public int getAuswahlId() {
		return auswahlId;
	}
	
	/**
	 * Setzen der Aushwal-ID
	 */
	public void setAuswahlId(int auswahlId) {
		this.auswahlId = auswahlId;
	}
	
	/**
	 * Auslesen des Wertes (value)
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Setzen des Wertes (value)
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Auslesen der Eigenschaft-ID 
	 */
	public int getEigenschaftId() {
		return eigenschaftId;
	}
	
	/**
	 * Setzen der Eigenschaft-ID 
	 */
	public void setEigenschaftId(int eigenschaftId) {
		this.eigenschaftId = eigenschaftId;
	}
	

}
