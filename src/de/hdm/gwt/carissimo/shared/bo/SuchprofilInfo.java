package de.hdm.gwt.carissimo.shared.bo;

/**
 * Realisierung einer exemplarischen Partnerbörse. Die Klasse SuchprofilInfo fügt alle relevanten Informationen zwischen Suchprofil, Profil und Info zusammen. 
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */


public class SuchprofilInfo {
	
	
	/**
	 * Deklaration der Instanzvariablen
	 */
	
	private Suchprofil suchprofil;
	private Profil profil;
	private Info info;
	
	
	/**
	 * Auslesen des Suchprofils.
	 * @return suchprofil
	 */
	public Suchprofil getSuchprofil() {
		return suchprofil;
	}
	
	/**
	 * Setzen des Suchprofils.
	 * @param suchprofil
	 */
	public void setSuchprofil(Suchprofil suchprofil) {
		this.suchprofil = suchprofil;
	}
	
	/**
	 * Auslesen des Profils.
	 * @return profil
	 */
	public Profil getProfil() {
		return profil;
	}
	
	/**
	 * Setzen des Profils. 
	 * @param profil
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	/**
	 * Auslesen der Info
	 * @return info
	 */
	public Info getInfo() {
		return info;
	}
	
	/**
	 * Setzen der Info 
	 * @param info
	 */
	public void setInfo(Info info) {
		this.info = info;
	}


}
