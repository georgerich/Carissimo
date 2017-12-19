package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.ProfilInfo;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Info;
import de.hdm.gwt.carissimo.shared.bo.Profil;
import de.hdm.gwt.carissimo.shared.ro.ProfilEigenschaft;
import de.hdm.gwt.carissimo.shared.ro.ProfilInformation;

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
		
	//Auslesen aller ProfilInfo-Objekte anhand der Email
	public Vector<ProfilEigenschaft> getAllProfilInfos(String email) throws Exception{
		
	Connection con = (Connection) DBConnection.connection();
	
	PreparedStatement prestmt = con.prepareStatement(
				"SELECT infoid FROM profilinfo WHERE email = '" + email + "'");
		
	ResultSet result = prestmt.executeQuery();
		
	Vector<ProfilEigenschaft> profilinformationen = new Vector<ProfilEigenschaft>();
		
	while (result.next())
	{
		ProfilEigenschaft profileigenschaft = getAllProfilInfosByInfo(result.getInt("infoid"));
		profilinformationen.add(profileigenschaft);
				
	}
		
		return profilinformationen;
	
	}
	
	//Auslesen aller Infos mit Eigenschaft anhand der infoId
	public ProfilEigenschaft getAllProfilInfosByInfo(int infoId) throws Exception {
		
		Connection con = (Connection)DBConnection.connection();
		
		PreparedStatement prestmt = (PreparedStatement) con.prepareStatement("SELECT i.value,"
				+"i.infoid, e.eigenschaftid, e.eigenschaft "
				+"FROM info i JOIN eigenschaft e ON i.eigenschaftid = "
				+"e.eigenschaftid WHERE infoid = " +infoId);
		
		ResultSet result = prestmt.executeQuery();
		
		ProfilEigenschaft profileigenschaft = new ProfilEigenschaft();
		while(result.next()){
			
			Info info = new Info();
			info.setEigenschaftId(result.getInt("eigenschaftid"));
			info.setInfoid(result.getInt("infoid"));
			info.setValue("value");
			
			Eigenschaft eigenschaft = new Eigenschaft();
			eigenschaft.setEigenschaftId(result.getInt("eigenschaftid"));
			eigenschaft.setEigenschaft(result.getString("eigenschaft"));
			
			profileigenschaft.setInfo(info);
			profileigenschaft.setEigenschaft(eigenschaft);
			
		}
		
		return profileigenschaft;
	}
}
