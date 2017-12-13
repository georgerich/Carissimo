package de.hdm.gwt.carissimo.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
//import com.google.cloud.sql.jdbc.Connection;
//import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Freitexteigenschaft;


public class FreitexteigenschaftMapper
{
private static FreitexteigenschaftMapper freitexteigenschaftMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected FreitexteigenschaftMapper()
	{
		
	}
	
	//Static-Methode des Typs FreitexteigenschaftMapper
	public static FreitexteigenschaftMapper freitexteigenschaftMapper() 
	{
		if (freitexteigenschaftMapper == null)
		{
			freitexteigenschaftMapper = new FreitexteigenschaftMapper();
		}
		
		return freitexteigenschaftMapper;
	}
	
	
	//Freitexteigenschaft einfuegen
	public void insertFreitexteigenschaft (Freitexteigenschaft f) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement insert = (PreparedStatement) con.prepareStatement
				
				("INSERT INTO freitexteigenschaft (textid, value, eigenschaftid) VALUES ('" 
				+ f.getFreitextId() + "','"
				+ f.getEigenschaftId() + "','"
				+ f.getValue() + "')");
		
		insert.execute();
	} 
	
	
	//Freitexteigenschaft aendern/aktualisieren
	public void updateFreitexteigenschaft (Freitexteigenschaft f) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement update = con.prepareStatement(
				"UPDATE freitexteigenschaft SET "
				+ "textid = '" + f.getFreitextId() + "', "
				+ "value = '" + f.getValue() + "', "
				+ "eigenschaftid = '" + f.getEigenschaftId() + "'");
				
		
		update.execute();
	}
	
	//Loeschen der Freitexteigenschaft
	public void deleteFreitexteigenschaft (Freitexteigenschaft f) throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement delete = con.prepareStatement(
				"DELETE FROM freitexteigenschaft "
				+ "WHERE textid = '" 
				+ f.getFreitextId() + "'");
		
		 delete.executeQuery();
	}
	
	//Auslesen aller Freitexteigenschaften
	public Vector <Freitexteigenschaft> getFreitexteigenschaft (Freitexteigenschaft f) throws Exception
	{
	Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM freitexteigenschaft");
		
		ResultSet result = prestmt.executeQuery();
		
		Vector<Freitexteigenschaft> freitexteigenschaften = new Vector<Freitexteigenschaft>();
		
		while (result.next()){
			Freitexteigenschaft freitexteigenschaft = new Freitexteigenschaft();
			freitexteigenschaft.setFreitextId(result.getInt("textid"));
			freitexteigenschaft.setValue(result.getString("value"));
			freitexteigenschaft.setEigenschaftId(result.getInt("eigenschaftid"));
			
			freitexteigenschaften.add(freitexteigenschaft); 
	}
		return freitexteigenschaften;
	}
}
