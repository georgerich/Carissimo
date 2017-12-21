package de.hdm.gwt.carissimo.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.gwt.carissimo.shared.bo.Auswahleigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Merkzettel;
import de.hdm.gwt.carissimo.shared.bo.Profil;
import de.hdm.gwt.carissimo.shared.bo.Suchprofil;

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
	
	Vector<Eigenschaft> getEigenschaften() throws Exception;
	
	Vector<Auswahleigenschaft> getAuswahl(Eigenschaft e) throws Exception;
	
	
	// Suchprofil & SuchprofilInfo: 
	
	void insertSuchprofil(String suchprofilname, String geschlecht, int minalter, int maxalter, int mingroesse, int maxgroesse,
			String haarfarbe, String religion, String raucher) throws Exception;
	
	void updateSuchprofil(String suchprofilname, String geschlecht, int minalter, int maxalter, int mingroesse, int maxgroesse,
			String haarfarbe, String religion, String raucher) throws Exception;
	
	void deleteSuchprofil(int suchprofilid) throws Exception;
	
	Suchprofil getSuchprofil(int suchprofilid) throws Exception;
	
	public Vector<Suchprofil> getAllSuchprofile(String email) throws Exception;
	
	
	// Besuch:
	
	void insertBesuch(String besuchtesProfil) throws Exception;
	
	
	// Merkzettel:
	
	void insertMerkzettel(String gemerktesProfil) throws Exception;
	
	Vector<Merkzettel> getMerkzettel() throws Exception;
	
	Vector<Profil> getMerkzettelProfile() throws Exception;
	
	void deleteMerkzettel(String gemerktesProfil) throws Exception;
	
	
	// Kontaktsperre: 

	void insertKontaktsperre(String gesperrtesProfil) throws Exception;
	
	Vector<Profil> getGesperrteProfile() throws Exception;
	
	void deleteKontaktsperre(String gesperrtesProfil) throws Exception;
	

}