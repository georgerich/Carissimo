package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import com.mysql.jdbc.Connection;

import de.hdm.gwt.carissimo.shared.bo.Besuch;
import de.hdm.gwt.carissimo.shared.bo.Profil;


/**
 * Mapperklasse, welche <code>Besuch</code>-Objekte auf einer relationalen
 * Datenbank abbildet bzw dafür zuständig ist, besuchte Profile zu merken.
 */

public class BesuchMapper {
	
	/**
	 * Die Klasse BesuchMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal für
	 * sämtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static BesuchMapper besuchMapper = null;

	
	/**
	 * Geschützer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schlüsselwort <code>new</code>.
	 */	
	protected BesuchMapper(){
		
	}

	
   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>BesuchMapper.besuchMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
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
	 * Einfügen eines Besuch-Objekts in die Datenbank.
	 * 
	 * @param b
	 * @throws Exception
	 */
	public void insertBesuch(Besuch b) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO besuch (email, besuchteemail) VALUES"
				+ "('" + b.getBesuchendesProfil() + "','" 
				+ b.getBesuchtesProfil() + "')");
		
		prestmt.execute();	
	}
	
	
	// Auslesen der Besuche.
	
	
}
