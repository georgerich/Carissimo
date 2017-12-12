package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.SuchprofilInfo;

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
		
	//Auslesen aller SuchprofilInfo-Objekte
//	public Vector<SuchprofilInfo> getAllSuchprofilInfos() throws Exception{
//		
//	Connection con = (Connection) DBConnection.connection();
//	
//	PreparedStatement prestmt = con.prepareStatement(
//				"SELECT * FROM suchprofilinfo");
//		
//	ResultSet result = prestmt.executeQuery();
//		
//	Vector<SuchprofilInfo> suchprofilinfos = new Vector<SuchprofilInfo>();
//		
//	while (result.next())
//	{
//		SuchprofilInfo suchprofilinfo = new SuchprofilInfo();
//		suchprofilinfo.Profil(result.getString("email"));
//		suchprofilinfo.setInfo(result.getStrin("infoid"));
//		suchprofilinfo.setSuchprofil(result.getInt("suchprofilid"));
//	
//				
//		suchprofilinfos.add(suchprofilinfo); 
//	}
//		
//		return suchprofilinfos;
//	
//	}
}
