package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Auswahleigenschaft;
import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;

public class AuswahleigenschaftMapper
{
	
	private static AuswahleigenschaftMapper auswahleigenschaftMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected AuswahleigenschaftMapper()
	{
		
	}
	
	//Static-Methode des Typs AuswahleigenschaftMapper
	public static AuswahleigenschaftMapper auswahleigenschaftMapper() 
	{
		if (auswahleigenschaftMapper == null)
		{
			auswahleigenschaftMapper = new AuswahleigenschaftMapper();
		}
		
		return auswahleigenschaftMapper;
	}
	
	//Auswahleigenschaft einfuegen
	public void insertAuswahleigenschaft (Auswahleigenschaft a) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement insert = (PreparedStatement) con.prepareStatement
				
				("INSERT INTO auswahleigenschaft (value, eigenschaftid) VALUES ('" 
				+ a.getEigenschaftId() + "','"
				+ a.getValue() + "')");
		
		insert.execute();
	} 
	
	//Auslesen aller Auswahleigenschaften einer Eigenschaft: 
	public Vector <Auswahleigenschaft> getAuswahleigenschaft (Eigenschaft e) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
					"SELECT value, eigenschaftid FROM auswahleigenschaft"
					+ "WHERE eigenschaftid = " + e.getEigenschaftid());
			
		ResultSet result = prestmt.executeQuery();
			
		Vector<Auswahleigenschaft> auswahleigenschaften = new Vector<Auswahleigenschaft>();
			
		while (result.next())
		{
			Auswahleigenschaft auswahleigenschaft = new Auswahleigenschaft();
			auswahleigenschaft.setAuswahlId(result.getInt("auswahlid"));
			auswahleigenschaft.setValue(result.getString("value"));
			auswahleigenschaft.setEigenschaftId(result.getInt("eigenschaftid"));
				
			auswahleigenschaften.add(auswahleigenschaft); 
		}
		return auswahleigenschaften;
	}
		
}
