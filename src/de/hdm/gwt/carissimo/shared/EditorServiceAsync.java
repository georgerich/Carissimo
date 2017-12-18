package de.hdm.gwt.carissimo.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

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

	
	//Eigenschaft:
	
	void insertEigenschaft(int eigenschaftId, String eigenschaft, AsyncCallback<Void> callback);

	//Info:
	
	void insertInfo(int infoId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void updateInfo(int infoId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void deleteInfo(AsyncCallback<Void> callback);

	
	//Auswahleigenschaft:
	
	void insertAuswahleigenschaft(int auswahlId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void updateAuswahleigenschaft(int auswahlId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void deleteAuswahleigenschaft(AsyncCallback<Void> callback);
	
	//Freitexteigenschaft:

	void insertFreitexteigenschaft(int freitextId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void updateFreitexteigenschaft(int freitextId, int eigenschaftId, String value, AsyncCallback<Void> callback);

	void deleteFreitexteigenschaft(AsyncCallback<Void> callback);

	

	
	



	
	
	
	
	

}
