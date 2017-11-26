package de.hdm.gwt.carissimo.shared.bo;

/**
 * Realisierung einer exemplarischen Partnerbörse. Über die Freitexteigenschaft wird 
 * einem Profil eine textuelle Beschreibung hinzugefügt. Die Freitexteigenschaft erweitert 
 * die Klasse Eigenschaft - diese wiederum wird in einem Info-Objekt aggregiert.
 * Jede Freitexteigenschaft besitzt eine eindeutig identifizierbare ID und den dazugehörigen
 * Wert @value. Die Eigenschaft-ID kennzeichnet die Eigenschaft als Freitexteigenschaft.
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Freitexteigenschaft extends Eigenschaft {

		private static final long serialVersionUID = 1L;
		
		/**
		 * Deklaration der Instanzvariablen.
		 */
		
		private int freitextId;
		private String value;
		private int eigenschaftId;
		
		/**
		* Es folgen die Get- und Set-Methoden um die Instanzvaribalen zu initialisieren bzw.
		* auszulesen.
		*/
		
		
		
		/**
		 * Auslesen der Freitext-ID
		 */
		
		public int getFreitextId() {
			return freitextId;
		}
		
		
		/**
		 * Setzen der Freitext-ID
		 */
		public void setFreitextId(int freitextId) {
			this.freitextId = freitextId;
		}
		
		
		/**
		 * Auslesen des Wertes (Value)
		 */
		public String getValue() {
			return value;
		}
		
		/**
		 * Setzen des Wertes (Value)
		 */
		public void setValue(String value) {
			this.value = value;
		}
		
		/**
		 * Auslesen der EigenschaftId
		 */
		public int getEigenschaftId() {
			return eigenschaftId;
		}
		
		/**
		 * Setzen der EigenschaftId
		 */
		public void setEigenschaftId(int eigenschaftId) {
			this.eigenschaftId = eigenschaftId;
		}
		
		
		

}
