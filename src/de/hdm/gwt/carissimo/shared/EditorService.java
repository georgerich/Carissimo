package de.hdm.gwt.carissimo.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.gwt.carissimo.shared.bo.Profil;

/**
 * Um ein RPC-Interface zu definieren, muessen drei Komponenten geschrieben werden: 
 * 	1. <>EditorService<>
 * 	2. <>EditorServiceImpl<>
 * 	3. <>EditorServiceAsync<>
 * 
 * Definieren des Interfaces <code>EditorService</code> fuer den Service, welches
 * das Interface <code>RemoteService</code> erweitert und alle RPC-Methoden auflistet.
 * 
 * @author YakupKanal
 *
 */

@RemoteServiceRelativePath("editor")
public interface EditorService extends RemoteService {
	
	// Profil: 
	
	void insertProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung) throws Exception;
	
	void updateProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung) throws Exception;
	
	void deleteProfil() throws Exception;
	
	Profil getOwnProfil() throws Exception;
	
	Profil getProfil(String email) throws Exception;
	
	Vector<Profil> getAllProfile() throws Exception;
	
	
	
	// Eigenschaft, Auswahl und Info:
	
	
	
	// Suchprofil & SuchprofilInfo: 
	
	
	
	// Besuch:
	
	
	
	// Merkzettel:
	
	
	
	// Kontaktsperre: 


	

	


	

}