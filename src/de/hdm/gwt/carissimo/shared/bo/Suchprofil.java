package de.hdm.gwt.carissimo.shared.bo;

import java.util.Vector;

import de.hdm.gwt.carissimo.shared.ro.ProfilEigenschaft;

/**
 * Realisierung einer exemplarischen Partnerbörse. Über ein Suchprofil kann 
 * sich ein Teilnehmerprofil andere Profile nach festgelegten Kriterien anzeiegen lassen. 
 * 
 * 
 * @author Kevin Cataluna Batista & Yakup Kanal
 * @version 1.0
 */

public class Suchprofil extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Deklaration der Instanzvariablen.
	 * Das Suchprofil enthaelt Eigenschaften und eine eindeutig identifizierbare ID
	 */
	
	private int suchprofilId;
	private String suchprofilname, haarfarbe, raucher, religion, geschlecht, email;
	private int koerpergroesseMin, koerpergroesseMax, alterMin, alterMax;
	private Vector <ProfilEigenschaft> profileigenschaften;
	
	
	/**
	* Es folgen die Get- und Set-Methoden.
	*/
	
	public int getSuchprofilId() {
		return suchprofilId;
	}
	public void setSuchprofilid(int suchprofilid) {
		this.suchprofilId = suchprofilid;
	}
	public String getSuchprofilname() {
		return suchprofilname;
	}
	public void setSuchprofilname(String suchprofilname) {
		this.suchprofilname = suchprofilname;
	}
	public String getHaarfarbe() {
		return haarfarbe;
	}
	public void setHaarfarbe(String haarfarbe) {
		this.haarfarbe = haarfarbe;
	}
	public String getRaucher() {
		return raucher;
	}
	public void setRaucher(String raucher) {
		this.raucher = raucher;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public int getKoerpergroesseMin() {
		return koerpergroesseMin;
	}
	public void setKoerpergroesseMin(int koerpergroesseMin) {
		this.koerpergroesseMin = koerpergroesseMin;
	}
	public int getKoerpergroesseMax() {
		return koerpergroesseMax;
	}
	public void setKoerpergroesseMax(int koerpergroesseMax) {
		this.koerpergroesseMax = koerpergroesseMax;
	}
	public int getAlterMin() {
		return alterMin;
	}
	public void setAlterMin(int alterMin) {
		this.alterMin = alterMin;
	}
	public int getAlterMax() {
		return alterMax;
	}
	public void setAlterMax(int alterMax) {
		this.alterMax = alterMax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Vector<ProfilEigenschaft> getProfileigenschaften() {
		return profileigenschaften;
	}
	public void setProfileigenschaften(Vector<ProfilEigenschaft> profileigenschaften) {
		this.profileigenschaften = profileigenschaften;
	}
	
	

	
	
	
	
}
