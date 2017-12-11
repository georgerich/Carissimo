package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Info;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;


/**
 * Mapperklasse, welche <code>Info</code>-Objekte auf einer relationalen
 * Datenbank abbildet und es damit erm�glicht, mit diesen unter Verwendung verschiedener
 * Methoden zu arbeiten.
 */
public class InfoMapper {
	
	/**
	 * Die Klasse InfoMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static InfoMapper infoMapper = null;

	
	/**
	 * Gesch�tzer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schl�sselwort <code>new</code>.
	 */	
	protected InfoMapper(){
		
	}

   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>InfoMapper.infoMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, dass nur eine einzige
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
	 * Einf�gen eines <code>Info</code> -Objekts in die Datenbank.
	 * 
	 * @param i
	 * @throws Exception
	 */
	public void insertInfo(Info i) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO info (infoid, value, eigenschaftid) VALUES ('"
				+ i.getInfoid() + "', '"
				+ i.getValue() + "', '"
				+ i.getEigenschaftId() + "')");
		
		prestmt.execute();	
	}
	
	public void updateInfo (Info i) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"UPDATE info SET"
				+ "infoid = '" + i.getInfoid() + "', "
				+ "eigenschaftid = '" + i.getEigenschaftId() + "', "
				+ "value = '" + i.getValue() + "', ");
		
		prestmt.execute();
		
	}
	
	public void deleteInfo (Info i) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"DELETE FROM info"
				+"WHERE infoid = '"
				+i.getInfoid() + "'");
		
		prestmt.execute();
	}
	 
	//muss hier nicht int EigneschaftId und String value uerbegeben werden?
	public Info getInfo (Info i) throws Exception
	{

		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM info WHERE infoid = '" + i.getInfoid() + "'");
		
		ResultSet result = prestmt.executeQuery();
		
		Info info = new Info();
		while (result.next()){			
			info.setInfoid(result.getInt("infoid"));
			info.setEigenschaftId(result.getInt("eigenschaft"));
			info.setValue(result.getString("value"));
	}
		
		return info;
	}
	
}