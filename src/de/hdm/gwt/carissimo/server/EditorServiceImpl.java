package de.hdm.gwt.carissimo.server;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.gwt.carissimo.server.db.AuswahleigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.BesuchMapper;
import de.hdm.gwt.carissimo.server.db.EigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.FreitexteigenschaftMapper;
import de.hdm.gwt.carissimo.server.db.InfoMapper;
import de.hdm.gwt.carissimo.server.db.KontaktsperreMapper;
import de.hdm.gwt.carissimo.server.db.MerkzettelMapper;
import de.hdm.gwt.carissimo.server.db.ProfilMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilMapper;
import de.hdm.gwt.carissimo.shared.EditorService;
import de.hdm.gwt.carissimo.shared.bo.Profil;

public class EditorServiceImpl extends RemoteServiceServlet implements EditorService{

	// Instanzvariablen: Mapperklassen
	private ProfilMapper pMapper = ProfilMapper.profilMapper();
	private InfoMapper iMapper = InfoMapper.infoMapper();
	private EigenschaftMapper eMapper = EigenschaftMapper.eigenschaftMapper();
	private AuswahleigenschaftMapper aMapper = AuswahleigenschaftMapper.auswahleigenschaftMapper();
	private FreitexteigenschaftMapper fMapper = FreitexteigenschaftMapper.freitexteigenschaftMapper();
	private SuchprofilMapper spMapper = SuchprofilMapper.suchprofilMapper();
//	private SuchprofilInfoMapper spiMapper = SuchprofilInfoMapper.suchprofilInfoMapper();
	private BesuchMapper bMapper = BesuchMapper.besuchMapper();
	private MerkzettelMapper mMapper = MerkzettelMapper.merkzettelMapper();
	private KontaktsperreMapper kMapper = KontaktsperreMapper.kontaktsperreMapper();

	
	// Instanzvariable: Eingeloggter User
	private Profil user;
	
	
	
	/*****************************************************************************************************
	 * START: Profil
	 ****************************************************************************************************/
	
	/**
	 * Profil
	 */
	public void setUser(Profil p) {
		user = p;
	}

	/**
	 * Profil anlegen
	 * 
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
	
	
	// Methode (2)

	// Methode (3)
	
	// ...
	
	
	
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
