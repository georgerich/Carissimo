package de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerbörse. Über die Eigenschaft werden 
 * dem Profil bescheibende Attribute hinzugefügt. Eigenschaftsobjekte werden 
 * in einem Info-Objekt aggregiert und bestehen aus einer Eigenschaft-ID und der dazugehörigen
 * Erlaeuterung.
 * Bspw.: Eigenschaft-ID: 1 = Erlaeuterung: Haarfarbe
 * 
 * Die Klasse Eigenschaft ist Superklasse und wird durch die Klassen Auswahleigenschaft 
 * und Freitexteigenschaft erweitert.
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Eigenschaft extends BusinessObject{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Deklaration der Instanzvariablen.
	 */
	
	/**
	 * Jedes Info-Objekt erhält eine eindeutig identifizierbare ID und eine Erlaeuerterung
	 */
	private int eigenschaftId;
	private String eigenschaft;
	
	/**
	* Es folgen die Get- und Set-Methoden um die Instanzvaribalen zu initialisieren.
	*/
	
	/**
	 * Auslesen der Eigenschafts-ID
	 */
	public int getEigenschaftid() {
		return eigenschaftId;
	}
	
	/**
	 * Setzen der Eigenschafts-ID
	 */
	public void setEigenschaftId(int eigenschaftId) {
		this.eigenschaftId = eigenschaftId;
	}
	
	/**
	 * Auslesen der Eigenschaftserlaeuterung
	 */
	public String getEigenschaft() {
		return eigenschaft;
	}
	
	/**Setzen der Eigenschaftserlaeuterung
	 */
	public void setEigenschaftg(String eigenschaft) {
		this.eigenschaft = eigenschaft;
	}
	
}
