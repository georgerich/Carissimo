package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Besuch;
import de.hdm.gwt.carissimo.shared.bo.Profil;


/**
 * Mapperklasse, welche <code>Besuch</code>-Objekte auf einer relationalen
 * Datenbank abbildet bzw daf�r zust�ndig ist, besuchte Profile zu merken.
 */

public class BesuchMapper {
	
	/**
	 * Die Klasse BesuchMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static BesuchMapper besuchMapper = null;

	
	/**
	 * Gesch�tzer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schl�sselwort <code>new</code>.
	 */	
	protected BesuchMapper(){
		
	}

	
   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>BesuchMapper.besuchMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, dass nur eine einzige
	* Instanz von <code>BesuchMapper</code> existiert.
	* 
	* <b>Fazit:</b> BesuchMapper sollte nicht mittels <code>new</code>
	* instanziiert werden, sondern stets durch Aufruf dieser statischen Methode.
	* 
	* @return DAS <code>BesuchMapper</code>-Objekt.
	* @see besuchMapper
	*/	
	public static BesuchMapper besuchMapper() {
		if (besuchMapper == null) {
			besuchMapper = new BesuchMapper();
		}
		return besuchMapper;
	}

	
	/**
	 * Einf�gen eines Besuch-Objekts in die Datenbank.
	 * 
	 * @param b
	 * @throws Exception
	 */
	public void insertBesuch(Besuch b) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO besuch (email, besuchteemail) VALUES"
				+ "('" + b.getBesuchendesProfil() + "', '" 
				+ b.getBesuchtesProfil() + "')");
		
		prestmt.execute();	
	}
	
		
	/**
	 * Auslesen der <code>Besuch</code> bzw. <code>Profil</code>-Objekte bezogen auf ein Profil.
	 * 
	 * @param p
	 * @return Vector<Besuch>
	 * @throws Exception
	 */
	public Vector<Besuch> getBesuch(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT besuchteemail FROM besuch WHERE email = '"
				+ email + "'");
		
		prestmt.execute();
		
		ResultSet r = prestmt.executeQuery();
		Vector<Besuch> besuch = new Vector<Besuch>();
		while (r.next()) {
			Besuch b = new Besuch();			
			b.setBesuchendesProfil(email);
			b.setBesuchtesProfil(r.getString("besuchteemail"));
			besuch.add(b);	
		}
		return besuch;	
	}
	
	
	/**
	 * Filterfunktion auf bereits besuchte Profile f�r das spaeter folgende Reporting.
	 * 
	 * @param b
	 * @return boolean 
	 * @throws Exception
	 */
	private boolean Besuch(Besuch b) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM besuch WHERE "
				+ "besuchendeemail = '" 
				+ b.getBesuchendesProfil()
				+ "' AND besuchteemail = '" 
				+ b.getBesuchtesProfil() + "'");
		
		ResultSet r = prestmt.executeQuery();
		if(r.next()) {
			return true;
		} else {
			return false;
		}
	}
}
