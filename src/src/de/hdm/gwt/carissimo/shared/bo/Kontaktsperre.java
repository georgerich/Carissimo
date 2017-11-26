package src.de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerbörse. Über eine Kontaktsperre kann ein 
 * Teilnehmerprofil ein anderen Teilnehmer sperren. Die Kontaktsperren bestehen aus 
 * einem sperrenden und einem gesperrten Profil.
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */


public class Kontaktsperre extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Deklaration der Instanzvariablen.
	 * Beide Attribute sind vom Typ String - da die Profile über die Email eindeutig 
	 * identifizierbar sind.
	 * */
	
	private String sperrendesprofil;
	private String gesperrtesprofil;
	
	/**
	* Es folgen die Get- und Set-Methoden.
	*/
	
	/**
	 * Auslesen der Email des sperrenden profils.
	 * @return Email-Adresse des sperrenden Profils
	 */
	public String getSperrendesProfil() {
		return sperrendesprofil;
	}
	
	/**
	 * Setzen der Email des sperrenden Profils
	 * @param sperrendesProfil
	 */
	public void setSperrendesProfil(String email) {
		this.sperrendesprofil = email;
	}
	
	/**
	 * Auslesen der Email des gesperrten Profils
	 * @return Email-Adresse des gesperrten Profils
	 */
	public String getGesperrtesProfil() {
		return gesperrtesprofil;
		
	/**
	 * Setzen der Email des gesperrten Profils
	 */
	}
	public void setGesperrtesProfil(String gesperteeemail) {
		this.gesperrtesprofil = gesperteeemail;
	}
	
	

}
