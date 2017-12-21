package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Kontaktsperre;
import de.hdm.gwt.carissimo.shared.bo.Profil;

/**
 * Mapper-Klasse, die <code>Kontaktsperre</code>-Objekte auf eine relationale
 * Datenbank abbildet. Um mit diesen Objekte zu arbeiten, werden hierf�r eine Reihe
 * verschiedener Methoden zur Verf�gung gestellt.
 *
 *@author Kevin Cataluna Batista 
 */

public class KontaktsperreMapper {
	
	/**
	 * Die Klasse KontaktsperreMapper wird nur einmal instanziiert (Singleton).
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal 
	 * saemtliche eventuellen Instanzen dieser Klasse vorhanden.
	 * Diese Variable speichert die einzige Instanz dieser Klasse.
	 */
	public static KontaktsperreMapper kontaktsperreMapper = null;
	
	
	/**
	 * Gesch�tzter Konstruktor damit mittels dem Schluesselwort <code>new</>
	 * keine neuen Instanzen erzeugt werden koennen.
	 */
	protected KontaktsperreMapper() {
		
	}
	
	/**
	 * Diese statische Methode kann auf den Klassennamen aufgerufen werden:
	 * <code>KontaktsperreMapper.kontaktsperremapper()</code>. Sie stellt die
	 * Singleton-Eigenschaft sicher, indem Sie dafuer sorgt, dass nur eine einzige
	 * Instanz von <code>KontaktsperreMapper</code> instanziiert wird.
	 */
	public static KontaktsperreMapper kontaktsperreMapper() {
		if (kontaktsperreMapper == null) {
			kontaktsperreMapper = new KontaktsperreMapper();
		}
		
		return kontaktsperreMapper;
		
	}
	
	/**
	 * Hier folgt die Einf�ge-Operation.
	 * Einf�gen eines Kontaktsperren-Objekts in die Datenbank.
	 */
	
	public void insertKontaktsperre(Kontaktsperre k) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO kontaktsperre "
				+ "(email, gesperrteemail) VALUES ('" 
				+ k.getSperrendesProfil() + "','" 
				+ k.getGesperrtesProfil() + "')");
		
		prestmt.execute();
	}
	
	/**
	 * Hier folgt die L�sch-Operation.
	 * L�schen eines Kontaktsperren-Objekts aus der Datenbank
	 * @throws Exception 
	 */
	public void deleteKontaktsperre(Kontaktsperre k) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"DELETE FROM kontaktsperre "
				+ "WHERE email = '" 
				+ k.getSperrendesProfil() 
				+ "' AND gesperrteemail = '"
				+ k.getGesperrtesProfil() + "'");
		
		 prestmt.executeQuery();
		
			
		}
		
	
	/**
	 *Auslesen der kontaktsperren, welche der User gesetzt hat.	 //Filter
	 */
		public Vector<Kontaktsperre> getKontaktsperrenGesperrteProfile(String email) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT gesperrteemail FROM kontaktsperre WHERE email = '"
				+ email + "'");
		
		ResultSet result = prestmt.executeQuery();
		Vector<Kontaktsperre> gesperrteProfile = new Vector<Kontaktsperre>();
		
		while (result.next()){
			Kontaktsperre k = new Kontaktsperre();
			k.setSperrendesProfil(email);
			k.setGesperrtesProfil("gesperrteemail");
			gesperrteProfile.add(k); 
		}	
		return gesperrteProfile;
	}
	
			
	/**
	 * Auslesen der Kontaktsperren die den User beinhalten/ bzw. gesperrt haben.  //Filter
	 */
	
	public Vector<Kontaktsperre> getKontaktsperrenSperrendeProfile(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT email FROM kontaktsperre "
				+ "WHERE gesperrteemail = '"
				+ email + "'");
		
		ResultSet result = prestmt.executeQuery();
		Vector<Kontaktsperre> kontaktsperren = new Vector<Kontaktsperre>();
		
		while (result.next()){
			Kontaktsperre k = new Kontaktsperre();
			k.setSperrendesProfil("email");
			k.setGesperrtesProfil(email);
			kontaktsperren.add(k);  
		}
		return kontaktsperren;
	}
	
	
	/**
	 * Auslesen der Profile, welche der User gesperrt hat.  // KontaktsperrSeite
	 */
	
	public Vector<Profil> getGesperrteProfile(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT p.email, p.vorname, p.nachname FROM profil p "
				+ "INNER JOIN kontaktsperre k ON p.email = k.gesperrteemail "
				+ "WHERE k.email = '"
				+ email +"'");
		
		ResultSet result = prestmt.executeQuery();
		Vector<Profil> gesperrteProfile = new Vector<Profil>();
		
		while (result.next()){
			Profil p = new Profil();
			p.setEmail(result.getString("email"));
			p.setVorname(result.getString("vorname"));
			p.setNachname(result.getNString("nachname"));
			
			gesperrteProfile.add(p); 
		}
		return gesperrteProfile;
	}
	
}