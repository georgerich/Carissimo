package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Info;
import de.hdm.gwt.carissimo.shared.bo.SuchprofilInfo;
import de.hdm.gwt.carissimo.shared.ro.ProfilEigenschaft;

public class SuchprofilInfoMapper
{
	//suchprofilid ZS1
	//email ZS1
	//profilinfo_email ZS2
	//profilinfo_infoid ZS2
	
	private static SuchprofilInfoMapper suchprofilinfoMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected SuchprofilInfoMapper()
	{
		
	}
	
	//Static-Methode des Typs SuchprofilInfoMapper
	public static SuchprofilInfoMapper SuchprofilInfoMapper() 
	{
		if (suchprofilinfoMapper == null)
		{
			suchprofilinfoMapper = new SuchprofilInfoMapper();
		}
		
		return suchprofilinfoMapper;
	}
	
	
	//SuchprofilInfo einfuegen
	public void insertSuchprofilInfo (SuchprofilInfo si) throws Exception
	{	
		Connection con = (Connection) DBConnection.connection();
			
		PreparedStatement insert = (PreparedStatement) con.prepareStatement
				("INSERT INTO suchprofilinfo (suchprofilid, email, profilinfo_email, profilinfo_infoid) VALUES ('" 
				+ si.getSuchprofil() + "','"			
				+ si.getProfil() + "','"		
				+ si.getInfo() + "')");
			
		insert.execute();
			
	}
	
	//SuchprofilInfo aktualisieren
	public void updateSuchprofilInfo (SuchprofilInfo si) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement update = (PreparedStatement) con.prepareStatement (
				"UPDATE suchprofilinfo SET "
				+ "email = '" + si.getProfil() + "', "
				+ "suchprofil = '" + si.getSuchprofil() + "', "
				+ "infoid = '" + si.getInfo() + "'");
		
		update.execute();
	}
	
	//SuchprofilInfo loeschen
	public void deleteSuchprofilInfo (SuchprofilInfo si) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement delete = con.prepareStatement(
				"DELETE FROM suchprofilinfo "
				+ "WHERE email = '" + si.getProfil()
				+ "WHERE infoid = '" + si.getInfo() + "'");
		
		 delete.execute();
	}
	
	
	/**
	 * Auslesen eines SuchprofiLInfo-Objetks anhand der infoId
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	
	public ProfilEigenschaft getSuchprofilInfo(int infoId) throws Exception{
		Connection con = DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement("SELECT i.infoid, "
				+ "i.value, e.eigenschaftid, e.eigenschaft"
				+ "FROM info i JOIN eigenschaft e ON i.eigenschaftid = "
				+ "e.eigenschaftid WHERE infoid = " + infoId);

		ResultSet result = prestmt.executeQuery();
		ProfilEigenschaft profileigenschaft = new ProfilEigenschaft();
		
		while(result.next()){
			
			Info info = new Info();
			info.setEigenschaftId(result.getInt("eigenschaftid"));
			info.setInfoid(result.getInt("infoid"));
			info.setValue(result.getString("value"));
			
			Eigenschaft eigenschaft = new Eigenschaft();
			eigenschaft.setEigenschaft(result.getString("eigenschaft"));
			eigenschaft.setEigenschaftId(result.getInt("eigenschaftid"));

			profileigenschaft.setInfo(info);
			profileigenschaft.setEigenschaft(eigenschaft);
			
		}
		
		return profileigenschaft;
		
	}
		
	/**
	 * Auslesen aller SuchprofilInfo-Objekte eines Suchprofils
	 * @return
	 * @throws Exception
	 */
	
	public Vector <ProfilEigenschaft> getAllSuchprofilInfos(String email, String suchprofilname) throws Exception{
		
		Connection con = DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement("SELECT infoid FROM "
				+ "suchprofilinfo WHERE email = '" + email + "' AND suchprofilname = '" + suchprofilname + "'");
		
		Vector<ProfilEigenschaft> suchprofilinfos = new Vector<ProfilEigenschaft>();
		
		ResultSet result = prestmt.executeQuery();
		
		while(result.next()){
			
			ProfilEigenschaft pi = getSuchprofilInfo(result.getInt("infoid"));
			suchprofilinfos.add(pi);
			
		}
		
		return suchprofilinfos;
		
	}

}
