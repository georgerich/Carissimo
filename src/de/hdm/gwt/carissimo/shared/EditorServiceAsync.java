package de.hdm.gwt.carissimo.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.gwt.carissimo.shared.bo.Profil;

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


	



	
	
	
	
	

}
