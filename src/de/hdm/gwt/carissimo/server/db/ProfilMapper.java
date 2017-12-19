package de.hdm.gwt.carissimo.server.db;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Profil;

/**
 * Mapper-Klasse, die <code>Profil</code>-Objekte auf eine relationale
 * Datenbank abbildet. Um mit diesen Objekte zu arbeiten, werden hierf�r eine Reihe
 * verschiedener Methoden zur Verf�gung gestellt.
 *
 *@author Kevin Cataluna Batista & Marko Deveric
 */


public class ProfilMapper {
	
	/**
	 * Die Klasse ProfilMapper wird nur einmal instanziiert (Singleton).
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal 
	 * saemtliche eventuellen Instanzen dieser Klasse vorhanden.
	 * Diese Variable speichert die einzige Instanz dieser Klasse.
	 */
	
	public static ProfilMapper profilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor damit mittels dem Schluesselwort <code>new</>
	 * keine neuen Instanzen erzeugt werden koennen.
	 */
	protected ProfilMapper() {
		
	}
	
	/**
	 * Diese statische Methode kann auf den Klassennamen aufgerufen werden:
	 * <code>ProfilMapper.kontaktsperremapper()</code>. Sie stellt die
	 * Singleton-Eigenschaft sicher, indem Sie dafuer sorgt, dass nur eine einzige
	 * Instanz von <code>ProfilMapper</code> instanziiert wird.
	 */
	public static ProfilMapper profilMapper() {
		if (profilMapper == null) {
			profilMapper = new ProfilMapper();
		}
		
		return profilMapper;
		
	}
	
	/**
	 * Hier folgt die Einf�ge-Operation.
	 * Einf�gen eines Kontaktsperren-Objekts in die Datenbank.
	 */
	
	public void insertProfil(Profil p) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO profil "
				+ "(email, vorname, nachname, geschlecht, geburtsdatum, koerpergroesse,"
				+ "haarfarbe, raucher, religion, beschreibung) VALUES ('" 
				+ p.getEmail() + "','" 
				+ p.getVorname() + "','" 
				+ p.getNachname() + "','"
				+ p.getGeschlecht() + "','"
				+ p.getGeburtsdatum()+ "','"
				+ p.getKoerpergroesse() + "','"
				+ p.getHaarfarbe() + "','"
				+ p.getRaucher() + "','"
				+ p.getReligion() + "','"				
				+ p.getBeschreibung() + "')");
		
		prestmt.execute();
	}
	
	/**
	 * Hier folgt die Einf�ge-Operation.
	 * Einf�gen eines Profil-Objekts in die Datenbank.
	 */
	public void updateProfil(Profil p) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"UPDATE profil SET "
				+ "email = '" + p.getEmail() + "', "
				+ "vorname = '" + p.getVorname() + "', "
				+ "nachname = '" + p.getNachname() + "', "
				+ "geschlecht = '" + p.getGeschlecht() + "', "
			    + "geburtsdatum = '" + p.getGeburtsdatum() + "', "
				+ "koerpergroesse = '" + p.getKoerpergroesse() + "', "
				+ "haarfarbe = '" + p.getHaarfarbe() + "', "
				+ "raucher = '" + p.getRaucher() + "', "
				+ "religion = '" + p.getReligion() + "', "
				+ "beschreibung = '" + p.getBeschreibung() + "'");
				
		
		prestmt.execute();
		
	}
	
	/**
	 * Hier folgt die L�sch-Operation.
	 * L�schen eines Profil-Objekts aus der Datenbank
	 */
	public void deleteProfil(String email) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"DELETE FROM profil "
				+ "WHERE email = '" 
				+ email + "'");
		
		 prestmt.executeQuery();
		
			
		}
	/**
	 * Auslesen aller Profile aus der Datenbank
	 */
	public Vector<Profil> getAllProfile() throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM profil");
		
		ResultSet result = prestmt.executeQuery();
		
		Vector<Profil> profile = new Vector<Profil>();
		
		while (result.next()){
			Profil profil = new Profil();
			profil.setEmail(result.getString("vorname"));
			profil.setVorname(result.getString("vorname"));
			profil.setNachname(result.getString("nachname"));
			profil.setGeburtsdatum(result.getDate("geburtsdatum"));
			profil.setGeschlecht(result.getString("geschlecht"));
			profil.setHaarfarbe(result.getString("haarfarbe"));
			profil.setKoerpergroesse(result.getInt("koerpergroesse"));
			profil.setReligion(result.getString("religion"));
			profil.setRaucher(result.getString("raucher"));
				
			profile.add(profil); 
		}
		
		return profile;
	}
	
	/** 
	 * Auslesen eines bestimmten <code>Profil<code>-Objekts
	 */
	public Profil getProfil(String email) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM profil WHERE email = '" + email + "'");
		
		ResultSet result = prestmt.executeQuery();
		Profil profil = new Profil();
		while (result.next()){			
			profil.setEmail(email);
			profil.setVorname(result.getString("vorname"));
			profil.setNachname(result.getString("nachname"));
			profil.setGeburtsdatum(result.getDate("geburtsdatum"));
			profil.setGeschlecht(result.getString("geschlecht"));
			profil.setHaarfarbe(result.getString("haarfarbe"));
			profil.setKoerpergroesse(result.getInt("koerpergroesse"));
			profil.setReligion(result.getString("religion"));
			profil.setRaucher(result.getString("raucher"));
		}
		return profil;
	}	
}