package de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerbörse. Über ein Info-Objekt werden 
 * die Eigenschaften eines Teilnehmerprofils definiert. 
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Info extends BusinessObject {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Deklaration der Instanzvariablen.
	 */
	
	/**
	 * Jedes Info-Objekt erhält eine eindeutig identifizierbare ID
	 */
	private int infoId;
	private String value;
	private int eigenschaftId;
	
	
	/**
	 * Es folgen die Get- und Set-Methoden um die Instanzvaribalen zu initialisieren.
	 */
	
	
	/**
	 * Auslesen der Info-ID
	 */
	public int getInfoid() {
		return infoId;
	}
	
	/**
	 * Setzen der Info-ID
	 */
	public void setInfoid(int infoId) {
		this.infoId = infoId;
	}
	
	/**
	 * Auslesen des Wertes/ der Auswahl zur Eigenschaft
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Setzen des Wertes/ Auswahl oder Freitext
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Auslesen der Eigenschaft
	 */
	public int getEigenschaftId() {
		return eigenschaftId;
	}
	
	/**
	 * Setzen der Eigenschaft
	 */
	public void setEigenschaftId(int eigenschaftId) {
		this.eigenschaftId = eigenschaftId;
	}

}
