package de.hdm.gwt.carissimo.shared.bo;

/**
 * Realisierung einer exemplarischen Partnerb�rse. Die Klasse Besuch bildet die Profilbesuche eines Profils ab
 * und enth�lt das besuchte und besuchende Profil.
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */


public class Besuch {
	
	
	/**
	 * Deklaration der Instanzvariablen.
	 * Beide Attribute sind vom Typ String - da die Profile �ber die Email
	 * eindeutig indetifzierbar sind und auf diese Weise das zu besuchende und das besuchte
	 * Profil repr�sentieren.
	 */
	private String besuchendesProfil;
	private String besuchtesProfil;
	
	
	/**
	 * Es folgen die Get- und Set-Methoden.
	 */
	
	
	/**
	 * Auslesen des besuchenden Profils.
	 * @return Email-Adresse des besuchenden Profils.
	 */
	public String getBesuchendesProfil() {
		return besuchendesProfil;
	}
	
		
	/**
	 * Setzen des besuchenden Profils.
	 * @param Email-Adresse des besuchenden Profils.
	 */
	public void setBesuchendesProfil(String besuchendesProfil) {
		this.besuchendesProfil = besuchendesProfil;
	}
	
	
	/**
	 * Auslesen des besuchten Profils.
	 * @param Email-Adresse des besuchten Profils.
	 */
	public String getBesuchtesProfil() {
		return besuchtesProfil;
	}
	
	
	/**
	 * Setzen des besuchten Profils.
	 * @param Email-Adresse des besuchten Profils.
	 */
	public void setBesuchtesProfil(String besuchtesProfil) {
		this.besuchtesProfil = besuchtesProfil;
	}
	
	
}
