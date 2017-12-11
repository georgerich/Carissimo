package de.hdm.gwt.carissimo.server.db;

import java.sql.*;
import java.util.*;

import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.PreparedStatement;

import de.hdm.gwt.carissimo.shared.bo.Eigenschaft;

public class EigenschaftMapper
{
	private static EigenschaftMapper eigenschaftMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected EigenschaftMapper()
	{
		
	}
	
	//Static-Methode des Typs EigenschaftMapper
	public static EigenschaftMapper eigenschaftMapper() 
	{
		if (eigenschaftMapper == null)
		{
			eigenschaftMapper = new EigenschaftMapper();
		}
		
		return eigenschaftMapper;
	}
	
	
	//Eigenschaft einfügen
	public void insertEigenschaft (Eigenschaft e) throws Exception
	{	
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement insert = (PreparedStatement) con.prepareStatement
				("INSERT INTO eigenschaft (eigenschaftid, eigenschaft) VALUES ('" 
				+ e.getEigenschaftid() + "','"				
				+ e.getEigenschaft() + "')");
		
		insert.execute();
		
	}
	
	//Eigenschaft anhand ID
	public Eigenschaft getEigenschaftbyId (int eigenschaftId) throws Exception
	{
	Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM eigenschaft WHERE eigenschaftid = '" + eigenschaftId + "'");
		
		ResultSet result = prestmt.executeQuery();
		
		Eigenschaft eigenschaft = new Eigenschaft();
		while (result.next()){			
			eigenschaft.setEigenschaftId(eigenschaftId);
			eigenschaft.setEigenschaft(result.getString("eigenschaft"));
		
		}
		return eigenschaft;
	}
	
	//Auslesen der Eigenschaften
	public Vector<Eigenschaft> getEigenschaft() throws Exception
	{
		Connection con = (Connection) DBConnection.connection();
		
		PreparedStatement prestmt = con.prepareStatement(
				"SELECT * FROM eigenschaft");
		
		ResultSet result = prestmt.executeQuery();
		
		Vector<Eigenschaft> eigenschaften = new Vector<Eigenschaft>();
		
		while (result.next()){
			Eigenschaft eigenschaft = new Eigenschaft();
			eigenschaft.setEigenschaftId(result.getInt("eigenschaftid"));
			eigenschaft.setEigenschaft(result.getString("eigenschaft"));
			
			eigenschaften.add(eigenschaft); 
	}
		return eigenschaften;
	}
	
	}
