package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import com.mysql.jdbc.Connection;
import de.hdm.gwt.carissimo.shared.bo.Info;


/**
 * Mapperklasse, welche <code>Info</code>-Objekte auf einer relationalen
 * Datenbank abbildet und es damit ermöglicht, mit diesen unter Verwendung verschiedener
 * Methoden zu arbeiten.
 */
public class InfoMapper {
	
	/**
	 * Die Klasse InfoMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal für
	 * sämtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static InfoMapper infoMapper = null;

	
	/**
	 * Geschützer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schlüsselwort <code>new</code>.
	 */	
	protected InfoMapper(){
		
	}

   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>InfoMapper.infoMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
	* Instanz von <code>SuchprofilMapper</code> existiert.
	* 
	* <b>Fazit:</b> InfoMapper sollte nicht mittels <code>new</code>
	* instanziiert werden, sondern stets durch Aufruf dieser statischen Methode.
	* 
	* @return DAS <code>SuchprofilMapper</code>-Objekt.
	* @see suchprofilMapper
	*/	
	public static InfoMapper infoMapper() {
		if (infoMapper == null) {
			infoMapper = new InfoMapper();
		}
		return infoMapper;
	}
	
	/**
	 * Einfügen eines <code>Info</code> -Objekts in die Datenbank.
	 * 
	 * @param i
	 * @throws Exception
	 */
	public void insertInfo(Info i) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO info (value, eigenschaftid) VALUES ('"		// passt das?
				+ i.getValue() + "', '"
				+ i.getEigenschaftId() + "')");
		
		prestmt.execute();	
	}
	
	
	// getInfo()
	
	
	// updateInfo()
	
	
	// deleteInfo()
	
	
	
	
	
	
	
	
	
	
	
	
}