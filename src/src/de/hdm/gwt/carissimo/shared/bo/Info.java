package src.de.hdm.gwt.carissimo.shared.bo;


/**
 * Realisierung einer exemplarischen Partnerbörse. Über ein Info-Objekt werden 
 * die Eigenschaften eines Teilnehmerprofils definiert. 
 * 
 * @author Kevin Cataluna Batista
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
	private int InfoId;
	private Eigenschaft eigenschaft;
	
	/**
	 * Es folgen die Get- und Set-Methoden um die Instanzvaribalen zu initialisieren.
	 */
	
	
	/**
	 * Auslesen der Info-ID
	 */
	public int getInfoId() {
		return InfoId;
	}
	
	/**
	 * Setzen der Info-ID
	 */
	public void setInfoId(int infoId) {
		InfoId = infoId;
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
