package de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerb�rse. �ber ein Info-Objekt werden 
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
	 * Jedes Info-Objekt erh�lt eine eindeutig identifizierbare ID
	 */
	private int infoId;
	private Eigenschaft eigenschaft;
	
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
	 * Auslesen der Eigenschaft
	 */
	public Eigenschaft getEigenschaft() {
		return eigenschaft;
	}
	
	/**
	 * Setzen der Eigenschaft
	 */
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.eigenschaft = eigenschaft;
	}
	
	
	


}