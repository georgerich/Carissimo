package src.de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerbörse. Über ein Merkezettel kann 
 * sich ein Teilnehmerprofil ein anderes Profil merken. 
 * Der Merkzettel enthält das zumerkende Profil und das merkende Profil.
 * 
 * @author Kevin Cataluna Batista
 * @version 1.0
 */

public class Merkzettel extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Deklaration der Instanzvariablen.
	 * Beide Attribute sind vom Typ String - da die Profile über die Email
	 * eindeutig indetifzierbar sind und auf diese Weise das zu merkende und das zu gemerkte
	 * Profil repräsentieren.
	 */
	private String merkendesProfil;
	private String gemerktesProfil;
	
		
	/**
	* Es folgen die Get- und Set-Methoden.
	*/
	
	/**
	 * Auslesen des merkenden Profils
	 * @return Email-Adresse des merkenden Profils
	 */
	public String getMerkendesProfil() {
		return merkendesProfil;
	}
		
	/**
	 * Setzen des merkenden Profils
	 * @param Email-Adresse des merkenden Profils
	 */
	public void setMerkendesProfil(String email) {
		this.merkendesProfil = email;
	}
	
	/**
	 * Auslesen des gemerkten Profils
	 * @return Email-Adresse des gemerkten Profils
	 */
	public String getGemerktesProfil() {
		return gemerktesProfil;
		
	/**
	 * Setzen des gemerkten Profils
	 * @param Email-Adresse des gemerkten Profils
	 */
	}
	public void setGemerktesProfil(String gemerkteemail) {
		this.gemerktesProfil = gemerkteemail;
	}
	
	
	
	
	
	
	
	
	
	
}
