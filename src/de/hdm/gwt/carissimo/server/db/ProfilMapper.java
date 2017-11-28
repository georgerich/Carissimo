package de.hdm.gwt.carissimo.server.db;

import java.sql.*;
import java.util.*;
import de.hdm.gwt.carissimo.shared.bo.Profil;


public class ProfilMapper
{
	
	
	private static ProfilMapper profilMapper = null;
	
	
	//Protected damit per new keine neuen Instanzen erzeugt werden können
	protected ProfilMapper() 
	{
		
	}
		public static ProfilMapper profilMapper() 
		{
			
			if (profilMapper == null) 
			{
				profilMapper = new ProfilMapper();
			}
			
			return profilMapper;
		}
		
		
		public void createProfilTable() throws Exception
		{
			
		}
		
		public void insertProfil (Profil p) throws Exception 
		{
			
		}
		
		public void deleteProfil (String email) throws Exception {
			
		}
		
		public void updateProfil (Profil p) throws Exception 
		{
			
		}
		
		
	}


