package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.ProfilInfo;

public class ProfilInfoMapper
{
	//email
	//infoid
	
	private static ProfilInfoMapper profilinfoMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected ProfilInfoMapper()
	{
		
	}
	
	//Static-Methode des Typs ProfilInfoMapper
	public static ProfilInfoMapper ProfilinfoMapper() 
	{
		if (profilinfoMapper == null)
		{
			profilinfoMapper = new ProfilInfoMapper();
		}
		
		return profilinfoMapper;
	}
	
	
	//ProfilInfo einfuegen
	public void insertProfilInfo (ProfilInfo pi) throws Exception
	{	
		Connection con = (Connection) DBConnection.connection();
			
		PreparedStatement insert = (PreparedStatement) con.prepareStatement
				("INSERT INTO profilinfo (email, infoid) VALUES ('" 
				+ pi.getEmail() + "','"				
				+ pi.getInfoid() + "')");
			
		insert.execute();
			
	}
	
	//ProfilInfo aktualisieren
	public void updateProfilInfo (ProfilInfo pi) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement update = (PreparedStatement) con.prepareStatement (
				"UPDATE profilinfo SET "
				+ "email = '" + pi.getEmail() + "', "
				+ "infoid = '" + pi.getInfoid() + "'");
		
		update.execute();
	}
	
	//ProfilInfo loeschen
	public void deleteProfilInfo (ProfilInfo pi) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement delete = con.prepareStatement(
				"DELETE FROM profilinfo "
				+ "WHERE email = '" + pi.getEmail()
				+ "WHERE infoid = '" + pi.getInfoid() + "'");
		
		 delete.execute();
	}
		
	//Auslesen aller ProfilInfo-Objekte
	public Vector<ProfilInfo> getAllProfilInfos() throws Exception{
		
	Connection con = (Connection) DBConnection.connection();
	
	PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM profilinfo");
		
	ResultSet result = prestmt.executeQuery();
		
	Vector<ProfilInfo> profilinfos = new Vector<ProfilInfo>();
		
	while (result.next())
	{
		ProfilInfo profilinfo = new ProfilInfo();
		profilinfo.setEmail(result.getString("email"));
		profilinfo.setInfoid(result.getInt("infoid"));
	
				
		profilinfos.add(profilinfo); 
	}
		
		return profilinfos;
	
	}
}
