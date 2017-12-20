package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Suchprofil;


/**
 * Mapperklasse, welche <code>Suchprofil</code>-Objekte auf einer relationalen
 * Datenbank abbildet und es damit erm�glicht, mit diesen unter Verwendung verschiedener
 * Methoden zu arbeiten.
 */
public class SuchprofilMapper {
	
	/**
	 * Die Klasse SuchprofilMapper wird nur einmal instantziiert (Singleton).
	 * 
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuelle Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static SuchprofilMapper suchprofilMapper = null;

	
	/**
	 * Gesch�tzer Konstruktor - verhindert das instanziieren von neuen Objekten dieser Klasse
	 * mittels dem Schl�sselwort <code>new</code>.
	 */	
	protected SuchprofilMapper(){
		
	}

   /**
	* Diese statische Methode kann aufgrufen werden durch
	* <code>SuchprofilMapper.suchprofilMapper()</code>. Sie stellt die
	* Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, dass nur eine einzige
	* Instanz von <code>SuchprofilMapper</code> existiert.
	* 
	* <b>Fazit:</b> SuchprofilMapper sollte nicht mittels <code>new</code>
	* instanziiert werden, sondern stets durch Aufruf dieser statischen Methode.
	* 
	* @return DAS <code>SuchprofilMapper</code>-Objekt.
	* @see suchprofilMapper
	*/	
	public static SuchprofilMapper suchprofilMapper() {
		if (suchprofilMapper == null) {
			suchprofilMapper = new SuchprofilMapper();
		}
		return suchprofilMapper;
	}
	
	/**
	 * Einf�gen eines <code>Suchprofil</code> -Objekts in die Datenbank.
	 * 
	 * @param sp
	 * @throws Exception
	 */
	public void insertSuchprofil(Suchprofil sp) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"INSERT INTO suchprofil (suchprofilid, suchprofilname, geschlecht, minalter, maxaltrer, mingroesse, maxgroesse, haarfarbe, religion, raucher, email) VALUES ('"
				+ sp.getSuchprofilId() + "', '"
				+ sp.getSuchprofilname() + "', '"
				+ sp.getGeschlecht() + "', '"
				+ sp.getAlterMin() + "', '"
				+ sp.getAlterMax() + "', '"
				+ sp.getKoerpergroesseMin() + "', '"
				+ sp.getKoerpergroesseMax() + "', '"
				+ sp.getHaarfarbe() + "', '"
				+ sp.getReligion() + "', '"
				+ sp.getRaucher() + "', '"
				+ sp.getEmail()	+ "')");
		
		prestmt.execute();	
	}
		
	/**
	 * Presistente Speicherung einer Ver�nderung in einem <code>Suchproifl</code>-Objekt eines Benutzers.
	 * 
	 * @param sp
	 * @throws Exception
	 */
	public void updateSuchprofil(Suchprofil sp) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"UPDATE suchprofil SET "
				+ "suchprofilname = '" + sp.getSuchprofilname() + "', "
				+ "minalter = '" + sp.getAlterMin() + "', "
				+ "maxalter = '" + sp.getAlterMax() + "', "
				+ "mingroesse = '" + sp.getKoerpergroesseMin() + "', "
				+ "maxgroesse = '" + sp.getKoerpergroesseMax() + "', "
				+ "haarfarbe = '" + sp.getHaarfarbe() + "', "
				+ "religion = '" + sp.getReligion() + "', "
				+ "raucher = '" + sp.getRaucher() + "' "
				+ "email = '" + sp.getEmail() + "' "
				+ "WHERE suchprofilid = '" + sp.getSuchprofilId());
				
		prestmt.execute();
	}

	/**
	 * L�schen eines <code>Suchprofil</code>-Objekts.
	 * 
	 * @param sp
	 * @throws Exception
	 */
	public void deleteSuchprofil(Suchprofil sp) throws Exception{
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"DELETE FROM suchprofil WHERE suchprofilid = '" 
				+ sp.getSuchprofilId() + "'");
		prestmt.execute();
	}

	/**
	 * Auslesen eines bestimmten <code>Suchprofil</code>-Objekts eines Benutzers.
	 * 	
	 * @param suchprofilId
	 * @return DAS Suchprofil
	 * @throws Exception
	 */
	public Suchprofil getSuchprofil(int suchprofilId) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM suchprofil WHERE suchprofilid = '"
				+ suchprofilId + "'");
				
		ResultSet r = prestmt.executeQuery();
		Suchprofil sp = new Suchprofil();
		while(r.next()) {
			sp.setSuchprofilid(r.getInt("suchprofilid"));
			sp.setSuchprofilname(r.getString("suchprofilname"));
			sp.setAlterMin(r.getInt("minalter"));
			sp.setAlterMax(r.getInt("maxalter"));
			sp.setKoerpergroesseMin(r.getInt("mingroesse"));
			sp.setKoerpergroesseMax(r.getInt("maxgroesse"));
			sp.setHaarfarbe(r.getString("haarfarbe"));
			sp.setReligion(r.getString("religion"));
			sp.setRaucher(r.getString("raucher"));
		}
		return sp;
	}

	/**
	 * Auslesen aller <code>Suchprofil</code>-Objekte bezogen auf ein Profil.
	 * 
	 * @param email
	 * @return Alle erstellten Suchprofile eines Benutzers.
	 * @throws Exception
	 */
	public Vector<Suchprofil> getSuchprofile(String email) throws Exception {
		
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM suchprofil WHERE email = '"
				+ email + "'");
		
		prestmt.execute();
		
		ResultSet r = prestmt.executeQuery();
		Vector<Suchprofil> suchprofile = new Vector<Suchprofil>();
		while (r.next()) {
			Suchprofil sp = new Suchprofil();		
			sp.setSuchprofilid(r.getInt("suchprofilid"));
			sp.setSuchprofilname(r.getString("suchprofilname"));
			sp.setAlterMin(r.getInt("minalter"));
			sp.setAlterMax(r.getInt("maxalter"));
			sp.setKoerpergroesseMin(r.getInt("mingroesse"));
			sp.setKoerpergroesseMax(r.getInt("maxgroesse"));
			sp.setHaarfarbe(r.getString("haarfarbe"));
			sp.setReligion(r.getString("religion"));
			sp.setRaucher(r.getString("raucher"));
			suchprofile.add(sp);	
		}
		return suchprofile;	
	}
}
