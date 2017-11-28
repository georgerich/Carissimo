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
		
		//Profiltabelle erstellen falls nicht vorhanden
		public void createProfilTable() throws Exception
		{
			
		}
		
		//Profil einfügen
		public void insertProfil (Profil p) throws Exception 
		{
			
		}
		
		//Profil löschen
		public void deleteProfil (String email) throws Exception 
		{
			
		}
		
		//Profil aktualisieren
		public void updateProfil (Profil p) throws Exception 
		{
			
		}
		
		//Profil anhand Email ermitteln
		public Profil getProfilbyEmail (String email)
		{
			return null;
			
		}
		
		//Profil anhand Profil (ID) finden
		public Profil getProfil (Profil p)
		{
			return null;
		}
		
		//Auslesen aller Profile
		public Vector<Profil> getAll() throws Exception 
		{
			return null;
			
		}
		
	}


