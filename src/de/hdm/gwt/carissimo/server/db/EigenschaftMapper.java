package de.hdm.gwt.carissimo.server.db;

import java.sql.*;
import java.util.*;

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
	
	//Erstellt Eigenschafts-Tabelle falls noch nicht vorhanden
	public void createEigenschaftTable () throws Exception
	{
		
	}
	
	//Eigenschaft einfügen
	public void insertEigenschaft (Eigenschaft e) throws Exception
	{
		
	}
	
	//Eigenschaft anhand ID
	public Eigenschaft getEigenschaftbyId (int eigenschaftId)
	{
		return null;
	}
	
	//Auslesen der Eigenschaften
	public Vector<Eigenschaft> getEigenschaft() throws Exception
	{
		return null;
	}
	
	
}
