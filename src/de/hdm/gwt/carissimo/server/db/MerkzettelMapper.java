package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Merkzettel;
import de.hdm.gwt.carissimo.shared.bo.Profil;


/**
 * Mapperklasse, welche <code>Merkzettel</code>-Objekte auf einer relationalen
 * Datenbank abbildet.
 */

public class MerkzettelMapper {
	
	/**
	 * Die Klasse MerkzettelMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static MerkzettelMapper merkzettelMapper = null;

	
	/**
	 * Gesch�tzer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schl�sselwort <code>new</code>.
	 */	
	protected MerkzettelMapper(){
		
	}

	
   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>MerkzettelMapper.merkzettelMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, dass nur eine einzige
	* Instanz von <code>MerkzettelMapper</code> existiert.
	* 
	* <b>Fazit:</b> MerkzettelMapper sollte nicht mittels <code>new</code>
	* instanziiert werden, sondern stets durch Aufruf dieser statischen Methode.
	* 
	* @return DAS <code>MerkzettelMapper</code>-Objekt.
	* @see merkzettelMapper
	*/	
	public static MerkzettelMapper merkzettelMapper() {
		if (merkzettelMapper == null) {
			merkzettelMapper = new MerkzettelMapper();
		}
		return merkzettelMapper;
	}

	
	/**
	 * Einf�gen eines Merkzettel-Objekts in die Datenbank.
	 * 
	 * @param m
	 * @throws Exception
	 */
	public void insertMerkzettel(Merkzettel m) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO merkzettel (email, gemerkteemail) VALUES"
				+ "('" + m.getMerkendesProfil() + "','" 
				+ m.getGemerktesProfil() + "')");
		
		prestmt.execute();	
	}
	
	
	/**
	 * L�schen eines Merkzettel-Objekts aus der Datenbank.
	 * 
	 * @param m
	 * @throws Exception 
	 */
	public void deleteMerkzettel(Merkzettel m) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"DELETE FROM merkzettel WHERE email = '"
				+ m.getMerkendesProfil() 
				+ "' AND gemerkteemail = '"
				+ m.getGemerktesProfil() + "')"); 
				
		prestmt.execute();
	}

	
	/**
	 * Auslesen aller Merkzettel-Objekte, welche der Benutzer hinterlegt hat.
	 * 
	 * @param email
	 * @return merkzettel
	 * @throws Exception
	 */
	
	public Vector<Merkzettel> getMerkzettel(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement select = con.prepareStatement(
				"SELECT gemerkteemail FROM merkzettel WHERE email = '"
				+ email + "'");
		
		ResultSet r = select.executeQuery();
		Vector<Merkzettel> merkzettel = new Vector<Merkzettel>();
		while (r.next()) {
			Merkzettel m = new Merkzettel();
			m.setGemerktesProfil(r.getString("gemerkteemail"));
			m.setMerkendesProfil(email);
			merkzettel.add(m);
		}
		return merkzettel;
	}
	
	/**
	 * Auslesen aller Merkzettel-/Profil-Objekte, welche der Benutzer hinterlegt hat.
	 * 
	 * @param email
	 * @return merkzettelProfil
	 * @throws Exception
	 */
	public Vector<Profil> getMerkzettelProfile(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT m.gemerkteemail, p.vorname, p.nachname  FROM merkzettel m "
				+ "INNER JOIN profil p "
				+ "ON m.gemerkteemail = p.email "
				+ "WHERE m.merkendeemail = '"
				+ email + "')");
		
		ResultSet r = prestmt.executeQuery();
		Vector<Profil> merkzettelProfile = new Vector<Profil>();
		while (r.next()) {
			Profil p = new Profil();
			p.setEmail(r.getString("email"));
			p.setVorname(r.getString("vorname"));
			p.setNachname(r.getString("nachname"));
			merkzettelProfile.add(p);
		}
		return merkzettelProfile;
	}	
}
