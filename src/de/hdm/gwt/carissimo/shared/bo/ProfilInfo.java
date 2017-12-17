package de.hdm.gwt.carissimo.shared.bo;		
 		
public class ProfilInfo extends BusinessObject		
{		
private static final long serialVersionUID = 1L;		
 		
	//Email des Profils		
 	private String email;		
  			
  	//ID des Info-Objekt		
  	private int infoid;		
  			
  	//Auslesen der Email		
  	public String getEmail()		
 	{		
  		return email;		
  	}		
  			
 	//Setzen der Email		
  	public void setEmail(String email)		
  	{		
  		this.email = email;		
  	}		
  			
  	//Auslesen der Info-ID		
  	public int getInfoid()		
  	{		
  		return infoid;		
  	}		
  			
  	//Setzen der Info-ID		
  	public void setInfoid(int infoid)		
  	{		
  		this.infoid = infoid;		
  	}		
 		
  } 