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
import de.hdm.gwt.carissimo.server.db.SuchprofilInfoMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilMapper;
import de.hdm.gwt.carissimo.shared.EditorService;
import de.hdm.gwt.carissimo.shared.bo.Profil;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Info;
import de.hdm.gwt.carissimo.shared.bo.Auswahleigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Freitexteigenschaft;

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
 * @author MarkoDeveric
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
	
	//Instanzvariable: Eigenschaft
	private Eigenschaft attribute;
	
	//Instanzvariable: Info
	private Info information;
	
	//Instanzvariable Auswahleigenschaft
	private Auswahleigenschaft choiceattribute;
	
	//Instanzvariable Freitexteigenschaft
	private Freitexteigenschaft freeattribute;
	
	
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
	
	
	
	// ...
	
	
	
	/***************************************************************************************************** 
	 * ENDE: Profil
	 ****************************************************************************************************/
	
	
	/*****************************************************************************************************
	 * START: Eigenschaft, Auswahl & Info
	 ****************************************************************************************************/
	
	public void setEigenschaft (Eigenschaft e) {
		attribute = e;
	}
	
	public void setInfo (Info i){
		information = i;
	}
	
	public void setChoiceAttrubute (Auswahleigenschaft a){
		choiceattribute = a;
	}
	
	public void setFreeAttribute (Freitexteigenschaft f){
		freeattribute = f;
	}
	
	
	/**
	 * Einfuegen von Eigenschaft, Info, Auswahleigenschaft & Freitexteigenschaft
	 * @param eigenschaftid
	 * @param eigenschaft
	 * @throws Exception
	 */
	
	public void insertEigenschaft(int eigenschaftid, String eigenschaft) throws Exception{
		
		Eigenschaft e = new Eigenschaft();
		
		e.setEigenschaftId(eigenschaftid);
		e.setEigenschaft(eigenschaft);
		eMapper.insertEigenschaft(e);	
	}
	
	public void insertInfo (int infoId, int eigenschaftId, String value) throws Exception{
		
		Info i = new Info();
		
		i.setInfoid(infoId);
		i.setEigenschaftId(eigenschaftId);
		i.setValue(value);
		iMapper.insertInfo(i);
	}
	
	public void insertAuswahleigenschaft (int auswahlId, int eigenschaftId, String value) throws Exception {
		
		Auswahleigenschaft a = new Auswahleigenschaft();
		
		a.setAuswahlId(auswahlId);
		a.setEigenschaftId(eigenschaftId);
		a.setValue(value);
		aMapper.insertAuswahleigenschaft(a);
		
	}
	
	public void insertFreitexteigenschaft (int freitextId, int eigenschaftId, String value) throws Exception{
		
		Freitexteigenschaft f = new Freitexteigenschaft();
		
		f.setFreitextId(freitextId);
		f.setEigenschaftId(eigenschaftId);
		f.setValue(value);
		fMapper.insertFreitexteigenschaft(f);
	}
	
	
	/**
	 * Aktualisieren von Info, Auswahleigenschaft & Freitexteigenschaft
	 * @param infoId
	 * @param eigenschaftId
	 * @param value
	 * @throws Exception
	 */
	
	public void updateInfo (int infoId, int eigenschaftId, String value) throws Exception {
		
		Info i = new Info();
		
		i.setInfoid(infoId);
		i.setEigenschaftId(eigenschaftId);
		i.setValue(value);
		iMapper.updateInfo(i);
	}
	
	public void updateAuswahleigenschaft (int auswahlId, int eigenschaftId, String value) throws Exception {
		
		Auswahleigenschaft a = new Auswahleigenschaft();
		
		a.setAuswahlId(auswahlId);
		a.setEigenschaftId(eigenschaftId);
		a.setValue(value);
		aMapper.updateAuswahleigenschaft(a);
		
	}
	
	public void updateFreitexteigenschaft (int freitextId, int eigenschaftId, String value) throws Exception {
		
		Freitexteigenschaft f = new Freitexteigenschaft();
		
		f.setFreitextId(freitextId);
		f.setEigenschaftId(eigenschaftId);
		f.setValue(value);
		fMapper.updateFreitexteigenschaft(f);
	}

	/**
	 * Loeschen von Info, Auswahleigenschaft & Freitexteigenschaft
	 * @throws Exception
	 */
	
	public void deleteInfo() throws Exception {
		iMapper.deleteInfo(information);
	}
	
	
	public void deleteAuswahleigenschaft () throws Exception {
		aMapper.deleteAuswahleigenschaft(choiceattribute);
	}
	
	public void deleteFreitexteigenschaft () throws Exception {
		fMapper.deleteFreitexteigenschaft(freeattribute);
	}
	
	
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
