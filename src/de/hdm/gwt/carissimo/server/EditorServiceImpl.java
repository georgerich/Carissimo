package de.hdm.gwt.carissimo.server;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.gwt.carissimo.server.db.AuswahleigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.BesuchMapper;
import de.hdm.gwt.carissimo.server.db.EigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.FreitexteigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.InfoMapper;
import de.hdm.gwt.carissimo.server.db.KontaktsperreMapper;
import de.hdm.gwt.carissimo.server.db.MerkzettelMapper;
import de.hdm.gwt.carissimo.server.db.ProfilMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilInfoMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilMapper;
import de.hdm.gwt.carissimo.shared.EditorService;
import de.hdm.gwt.carissimo.shared.bo.Besuch;
import de.hdm.gwt.carissimo.shared.bo.Kontaktsperre;
import de.hdm.gwt.carissimo.shared.bo.Merkzettel;
import de.hdm.gwt.carissimo.shared.bo.Profil;


/**
 * Um ein RPC-Interface zu definieren, muessen drei Komponenten geschrieben werden: 
 * 	1. <>EditorService<>
 * 	2. <>EditorServiceImpl<>
 * 	3. <>EditorServiceAsync<>
 * 
 * Erstellen der Klasse <code>EditorServiceImpl</code>, welche die Klasse <code>RemoteServiceServlet</code>
 * erweitert und das Service implementiert - Hier werden die Methoden/ wird die Applikationslogik implementiert.
 * 
 * @info: Sowohl Client als auch Server besitzen die Faehigkeit Daten zu serialisieren bzw. deserialisieren, 
 * sodass die Datenobjekte zwischen Server und Client als textuelle Form ausgetauscht werden koennen:
 * Zustaendig hierfuer ist der Service <code>RemoteServiceServlet</code>. 
 * 
 * @author YakupKanal
 *
 */
public class EditorServiceImpl extends RemoteServiceServlet implements EditorService{

	// Instanzvariablen: Mapperklassen
	private ProfilMapper pMapper = ProfilMapper.profilMapper();
	private InfoMapper iMapper = InfoMapper.infoMapper();
	private EigenschaftMapper eMapper = EigenschaftMapper.eigenschaftMapper();
	private AuswahleigenschaftMapper aMapper = AuswahleigenschaftMapper.auswahleigenschaftMapper();
	private FreitexteigenschaftMapper fMapper = FreitexteigenschaftMapper.freitexteigenschaftMapper();
	private SuchprofilMapper spMapper = SuchprofilMapper.suchprofilMapper();
	private SuchprofilInfoMapper spiMapper = SuchprofilInfoMapper.SuchprofilInfoMapper();
	private BesuchMapper bMapper = BesuchMapper.besuchMapper();
	private MerkzettelMapper mMapper = MerkzettelMapper.merkzettelMapper();
	private KontaktsperreMapper kMapper = KontaktsperreMapper.kontaktsperreMapper();

	
	// Instanzvariable: Eingeloggter User
	private Profil user;
	
	
	
	/*****************************************************************************************************
	 * START: Profil
	 ****************************************************************************************************/
	
	/**
	 * Eingeloggter User
	 */
	public void setUser(Profil p) {
		user = p;
	}

	
	/**
	 * Profil anlegen
	 * @param Profilattribute
	 */
	public void insertProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung) throws Exception {
		
		Profil p = new Profil();
		
		p.setEmail(email);
		p.setVorname(vorname);
		p.setNachname(nachname);
		p.setGeschlecht(geschlecht);
		p.setGeburtsdatum(geburtsdatum);
		p.setKoerpergroesse(koerpergroesse);
		p.setHaarfarbe(haarfarbe);
		p.setRaucher(raucher);
		p.setReligion(religion);
		pMapper.insertProfil(p);
	}
	
	
	/**
	 * Profil updaten
	 */
	public void updateProfil(String email, String vorname, String nachname, String geschlecht, Date geburtsdatum,
			int koerpergroesse, String haarfarbe, String raucher, String religion, String beschreibung) throws Exception {
		
		Profil p = new Profil();
		
		p.setEmail(email);
		p.setVorname(vorname);
		p.setNachname(nachname);
		p.setGeschlecht(geschlecht);
		p.setGeburtsdatum(geburtsdatum);
		p.setKoerpergroesse(koerpergroesse);
		p.setHaarfarbe(haarfarbe);
		p.setRaucher(raucher);
		p.setReligion(religion);
		pMapper.updateProfil(p);
	}
	
	
	/**
	 * Profil loeschen
	 */
	public void deleteProfil() throws Exception {
		pMapper.deleteProfil(user.getEmail());
	}
	
	
	/**
	 * Auslesen des eigenen Profils
	 */
	public Profil getOwnProfil() throws Exception {
		return pMapper.getProfil(user.getEmail());
	}
	
	
	/**
	 * Auslesen eines fremden Profils via email
	 */
	public Profil getProfil(String email) throws Exception {
		return pMapper.getProfil(email);
	}
	
	
	/**
	 * Auslesen aller Profile mit Ausnahmen auf:
	 * 	- den User selbst,
	 * 	- auf besuchte Profile des User	<code>Besuch</code>,
	 *  - auf bereits gemerkte Profile des Users <code>Merkzettel</code>,
	 *  - auf Profile, welche der User gesperrt hat <code>Kontaktsperre</code> und
	 *  - auf Profile, welche den User gesperrt haben <code>Kontaktsperre</code>.
	 *  
	 *  
	 */
	public Vector<Profil> getAllProfile() throws Exception {
		
		// Alle Profile sowie Besuch und Merkzettel des Users als auch die Kontaktsperren (beidseitig) auslesen
		Vector<Profil> profil = pMapper.getAllProfile();
		Vector<Besuch> besuch = bMapper.getBesuch(user.getEmail());
		Vector<Merkzettel> merkzettel = mMapper.getMerkzettel(user.getEmail());
		Vector<Kontaktsperre> gesperrteProfile = kMapper.getKontaktsperrenGesperrteProfile(user.getEmail());
		Vector<Kontaktsperre> sperrendeProfile = kMapper.getKontaktsperrenGesperrteProfile(user.getEmail());
		
		Vector<Profil> result = new Vector<Profil>();
		
		for(int i = 0; i < profil.size(); i++) {
			
			boolean check = true; 
			
			// Den User selbst über profil filtern:
			if(profil.elementAt(i).getEmail().equals(user.getEmail())) {
				check = false;
				continue;
			}
			
			// Besuchte Profile des Users über besuch filtern:
			for(int b = 0; b < besuch.size(); b++) {
				if(profil.elementAt(i).getEmail().equals(besuch.elementAt(b).getBesuchtesProfil())) {
					check = false;
					break;
				}
			}
			
			// Gemerkte Profile des Users über merkzettel filtern:
			for(int m = 0; m < merkzettel.size(); m++) {
				if(profil.elementAt(i).getEmail().equals(merkzettel.elementAt(m).getGemerktesProfil())) {
					check = false;
					break;
				}
			}
			
			// Profile, welche der User gesperrt hat über gesperrteProfile filtern:
			for(int ks1 = 0; ks1 < gesperrteProfile.size(); ks1++) {
				if(profil.elementAt(i).getEmail().equals(gesperrteProfile.elementAt(ks1))){
					check = false;
					break;
				}
			}
			
			// Profile, welche den Usergesperrt haben über sperrendeProfile filtern:
			for(int ks2 = 0; ks2 < sperrendeProfile.size(); ks2++) {
				if(profil.elementAt(i).getEmail().equals(sperrendeProfile.elementAt(ks2))){
					check = false;
					break;
				}
			}
			
			if (check) 
				result.add(profil.elementAt(i));	
		}
		return result;
	}
	
	
	
	/***************************************************************************************************** 
	 * ENDE: Profil
	 ****************************************************************************************************/
	
	
	/*****************************************************************************************************
	 * START: Eigenschaft, Auswahl & Info
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Eigenschaft, Auswahl & Info
	 ****************************************************************************************************/
	
	
	/*****************************************************************************************************
	 * START: Suchprofil & SuchprofilInfo
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Suchprofil & SuchprofilInfo
	 ****************************************************************************************************/
	
	
	/*****************************************************************************************************
	 * START: Besuch
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Besuch
	 ****************************************************************************************************/


	/*****************************************************************************************************
	 * START: Merkzettel
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Merkzettel
	 ****************************************************************************************************/

	
	/*****************************************************************************************************
	 * START: Kontaktsperre
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Kontaktsperre
	 ****************************************************************************************************/
	

	/*****************************************************************************************************
	 * START: Sonstiges
	 ****************************************************************************************************/
	
	// Methode (1)
	
	// Methode (2)

	// Methode (3)
	
	
	/***************************************************************************************************** 
	 * ENDE: Sonstiges
	 ****************************************************************************************************/	
}
