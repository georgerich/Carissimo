package de.hdm.gwt.carissimo.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.gwt.carissimo.shared.bo.Auswahleigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Profil;
import de.hdm.gwt.carissimo.shared.bo.Suchprofil;

/**
 * Um ein RPC-Interface zu definieren, muessen drei Komponenten geschrieben werden: 
 * 	1. <>EditorService<>
 * 	2. <>EditorServiceImpl<>
 * 	3. <>EditorServiceAsync<>
 * 
 * Definieren des asynchronen Interfaces <code>EditorServiceAsync</code>, um den Service 
 * vom clienten aufzurufen/ Call.
 * 
 * @author YakupKanal
 *
 */

public interface EditorServiceAsync {
	
	// Profil:
	
	void insertProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung,
			AsyncCallback<Void> callback);

	void updateProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung,
			AsyncCallback<Void> callback);

	void deleteProfil(AsyncCallback<Void> callback);
	
	void getOwnProfil(AsyncCallback<Profil> callback);
	
	void getProfil(String email, AsyncCallback<Profil> callback);
	
	void getAllProfile(AsyncCallback<Vector<Profil>> callback);

	
	// Eigenschaft, Auswahl und Info:
	
	void getEigenschaften(AsyncCallback<Vector<Eigenschaft>> callback);

	void getAuswahl(Eigenschaft e, AsyncCallback<Vector<Auswahleigenschaft>> callback);
	
	
	
	// Suchprofil & SuchprofilInfo: 
	
	void insertSuchprofil(String suchprofilname, String geschlecht, int minalter, int maxalter, int mingroesse,
			int maxgroesse, String haarfarbe, String religion, String raucher, AsyncCallback<Void> callback);

	void updateSuchprofil(String suchprofilname, String geschlecht, int minalter, int maxalter, int mingroesse,
			int maxgroesse, String haarfarbe, String religion, String raucher, AsyncCallback<Void> callback);

	void deleteSuchprofil(int suchprofilid, AsyncCallback<Void> callback);

	void getSuchprofil(int suchprofilid, AsyncCallback<Suchprofil> callback);

	void getAllSuchprofile(String email, AsyncCallback<Vector<Suchprofil>> callback);
	
	
	
	// Besuch:
	
	
	
	// Merkzettel:
	
	
	
	// Kontaktsperre: 


	



	
	
	
	
	

}
