package de.hdm.gwt.carissimo.shared.bo;


import java.util.Date;

/**
 * Realisierung einer exemplarischen Partnerbörse. Ein Teilnehmer wird durch ein Profil 
 * repräsentiert. Jedes Profil enthaelt Attribute, welche die Eigenschaften eines Teilnehmers
 * darstellen.
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Profil extends BusinessObject {

	/**
	 * Es folgen die Instanzvariablen, welche nachstehend 
	 * über die Get- und Set-Methoden initialisiert werden.
	 * @Instanzvariablen: Attribute eines Profils
	 */
	private static final long serialVersionUID = 1L;
	
	// Die E-Mail-Adresse des Teilnehmers/Profils
	private String email;
	
	
	// Der Vor- und Nachname der Teilnehmers
	private String vorname, nachname;
	
	//Das Geburtsdatum des Teilnehmers
	private Date geburtsdatum;
	
	// Die Haarfarbe des Teilnehmers
	private String haarfarbe;
	
	// Die koerpergroesse des Teilnehmers
	private int koerpergroesse;
	
	// Angaben zu Raucher oder Nicht-Raucher
	private String raucher;
	
	//Die Religionszugehörigkeit des Teilnehmers
	private String religion;
	
	// Angaben zum Geschlecht der Teilnehmers
	private String geschlecht;
	
	// Das Info-Objekt des Profils eines Teilnehmers
	private Info info;
	
	// Die Freitextbeschreibung des Profils eines Teilnehmers
	private String beschreibung;
	
	
	//Der Merkzettel des Profils eines Teilnehmers
	private Merkzettel merkzettel;
	
	//Die Kontaktsperre des Profils eines Teilnehmers
	private Kontaktsperre kontaktsperre;
	
	
	
	//------------Abschnitt Instanzvariablen Ende ----------------//
	
	/**
	 * Es folgen die Get- und Set-Methoden.
	 */
	
	
	/**
	 * Auslesen der Email-Adresse des Profils
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setzen der Email-Adresse
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Auslesen des Vornamen eines Teilnehmers
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Setzen des Vornamen eines Teilnehmers
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/**
	 * Auslesen des Nachnamen eines Teilnehmers 
	 */
	public String getNachname() {
		return nachname;
	}
	
	/**
	 * Setzen des Nachnamens
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	/**
	 * Auslesen des Geburtsdatums
	 * @return Geburtsdatum
	 */
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	
	/**
	 * Setzen des Geburtsdatums
	 */
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	/**
	 * Auslesen der Haarfarbe
	 */
	public String getHaarfarbe() {
		return haarfarbe;
	}
	
	/**
	 * Auslesen der Haarfarbe
	 */
	public void setHaarfarbe(String haarfarbe) {
		this.haarfarbe = haarfarbe;
	}
	
	/**
	 * Auslesen der Koepergroesse
	 */
	public int getKoerpergroesse() {
		return koerpergroesse;
	}
	
	/**
	 * Setzen der Koerpergroesse
	 */
	public void setKoerpergroesse(int koerpergroesse) {
		this.koerpergroesse = koerpergroesse;
	}
	
	/**
	 * Auslesen der Raucher-Angabe
	 */
	public String getRaucher() {
		return raucher;
	}
	
	/**
	 * Setzen der Raucherangabe
	 */
	public void setRaucher(String raucher) {
		this.raucher = raucher;
	}
	
	/**
	 * Auslesen der Religionszugehörigkeit
	 */
	public String getReligion() {
		return religion;
	}
	
	/**
	 * Setzen der Religionszugehoerigkeit
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	/**
	 * Auslesen des Geschlechts
	 */
	public String getGeschlecht() {
		return geschlecht;
	}
	
	/**
	 * Setzen des Geschlechts
	 */
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	/**
	 * Auslesen der Info
	 */
	public Info getInfo() {
		return info;
	}
	
	/**
	 * Setzen der Info
	 */
	public void setInfo(Info info) {
		this.info = info;
	}
	
	/**
	 * Auslesen der Beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Setzen der Beschreibung
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	/**
	 * Auslesen des Merkzettels
	 */
	public Merkzettel getMerkzettel() {
		return merkzettel;
	}
	
	/**
	 * Setzen des Merkzettels
	 */
	public void setMerkzettel(Merkzettel merkzettel) {
		this.merkzettel = merkzettel;
	}
	
	/**
	 * Auslesen der Kotaktsperre
	 */
	public Kontaktsperre getKontaktsperre() {
		return kontaktsperre;
	}
	
	/**
	 * Setzen der Kontaktsperre
	 */
	public void setKontaktsperre(Kontaktsperre kontaktsperre) {
		this.kontaktsperre = kontaktsperre;
	}

}
