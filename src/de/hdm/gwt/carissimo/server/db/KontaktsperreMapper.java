package de.hdm.gwt.carissimo.server.db;
import java.sql.ResultSet;
import java.util.Vector;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.PreparedStatement;
import de.hdm.gwt.carissimo.shared.bo.Kontaktsperre;
import de.hdm.gwt.carissimo.shared.bo.Profil;

/**
 * Mapper-Klasse, die <code>Kontaktsperre</code>-Objekte auf eine relationale
 * Datenbank abbildet. Um mit diesen Objekte zu arbeiten, werden hierfür eine Reihe
 * verschiedener Methoden zur Verfügung gestellt.
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
	 * Geschützter Konstruktor damit mittels dem Schluesselwort <code>new</>
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
	 * Hier folgt die Einfüge-Operation.
	 * Einfügen eines Kontaktsperren-Objekts in die Datenbank.
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
	 * Hier folgt die Lösch-Operation.
	 * Löschen eines Kontaktsperren-Objekts aus der Datenbank
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
	 * Auslesen aller <code>Kontaktsperre</code> bzw. <code>Profil</code>-Objekte bezogen auf ein Profil.
	 * Gibt die gesperrten Profil eines User zurück	*/
	
		public Vector<Profil> getGesperrteProfile(Kontaktsperre ks) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT k.gesperrteemail, p.vorname, p.nachname FROM kontaktsperre k "
				+ "INNER JOIN profil p "
				+ "ON k.gesperrteemail = p.email "
				+ "WHERE k.email = '" 
				+ ks.getGesperrtesProfil() +"'");
		
		ResultSet result = prestmt.executeQuery();
		Vector<Profil> gesperrteProfile = new Vector();
		
		while (result.next()){
			Profil p = new Profil();
			p.setEmail("gesperrteemail");
			p.setVorname("vorname");
			p.setNachname("nachname");
			
			gesperrteProfile.add(p); 
		}
			
		return gesperrteProfile;
		
	}
	
			
	/**
	 * Auslesen der Kontaktsperren die den User beinhalten.
	 */
	
	public Vector<Kontaktsperre> getKontaktsperren(Profil p) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT email FROM kontaktsperre "
				+ "WHERE gesperrteemail = '"
				+ p.getEmail() +"'");
		
		ResultSet result = prestmt.executeQuery();
		Vector<Kontaktsperre> kontaktsperren = new Vector();
		
		while (result.next()){
			Kontaktsperre ks = new Kontaktsperre();
			ks.setSperrendesProfil("email");
			
			kontaktsperren.add(ks); 
		}
			
		return kontaktsperren;
		
	}
	
}