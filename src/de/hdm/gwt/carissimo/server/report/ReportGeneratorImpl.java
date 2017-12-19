package de.hdm.gwt.carissimo.server.report;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


import de.hdm.gwt.carissimo.shared.ReportGeneratorService;

import de.hdm.gwt.carissimo.server.db.ProfilInfoMapper;
import de.hdm.gwt.carissimo.server.db.ProfilMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilInfoMapper;
import de.hdm.gwt.carissimo.server.db.SuchprofilMapper;
import de.hdm.gwt.carissimo.server.db.BesuchMapper;
import de.hdm.gwt.carissimo.server.db.KontaktsperreMapper;
import de.hdm.gwt.carissimo.server.db.MerkzettelMapper;
import de.hdm.gwt.carissimo.shared.bo.Besuch;
import de.hdm.gwt.carissimo.shared.bo.Kontaktsperre;
import de.hdm.gwt.carissimo.shared.bo.Merkzettel;
import de.hdm.gwt.carissimo.shared.bo.Profil;
import de.hdm.gwt.carissimo.shared.bo.Suchprofil;
import de.hdm.gwt.carissimo.shared.bo.SuchprofilInfo;

import de.hdm.gwt.carissimo.shared.ro.ProfilEigenschaft;

public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGeneratorService{
	
	private ProfilMapper pMapper = ProfilMapper.profilMapper();
	private ProfilInfoMapper piMapper = ProfilInfoMapper.ProfilinfoMapper();
	private SuchprofilMapper spMapper = SuchprofilMapper.suchprofilMapper();
	private SuchprofilInfoMapper spiMapper = SuchprofilInfoMapper.SuchprofilInfoMapper();
	private BesuchMapper bMapper = BesuchMapper.besuchMapper();
	private MerkzettelMapper mMapper = MerkzettelMapper.merkzettelMapper();
	private KontaktsperreMapper kMapper = KontaktsperreMapper.kontaktsperreMapper();
	
	
	
	private Profil user;
	
	public void setUser (Profil p)
	{
		user = p;
	}
	
	/**
	 * Auslesen aller Profile mit Ausnahmen auf:
	 * 	- den User selbst,
	 * 	- auf besuchte Profile des User	<code>Besuch</code>,														
	 *  - auf bereits gemerkte Profile des Users <code>Merkzettel</code>,
	 *  - auf Profile, welche der User gesperrt hat <code>Kontaktsperre</code> und
	 *  - auf Profile, welche den User gesperrt haben <code>Kontaktsperre</code>.
	 *  
	 *  // @gui Auf Button Finden koppeln?
	 *  
	 */
	public Vector<Profil> getAllProfile() throws Exception {
		
		// Alle Profile sowie Besuch und Merkzettel des Users als auch die Kontaktsperren (beidseitig) auslesen
		Vector<Profil> profil = pMapper.getAllProfile();
		Vector<Besuch> besuch = bMapper.getBesuch(user.getEmail());													
		Vector<Merkzettel> merkzettel = mMapper.getMerkzettel(user.getEmail());
		Vector<Kontaktsperre> gesperrteProfile = kMapper.getKontaktsperrenGesperrteProfile(user.getEmail());
		Vector<Kontaktsperre> sperrendeProfile = kMapper.getKontaktsperrenGesperrteProfile(user.getEmail());
		
		Vector<Profil> result = new Vector<Profil>();
		
		for(int i = 0; i < profil.size(); i++) {
			
			boolean check = true; 
			
			// Den User selbst ueber profil filtern:
			if(profil.elementAt(i).getEmail().equals(user.getEmail())) {
				check = false;
				continue;
			}
			
			// Besuchte Profile des Users ueber besuch filtern:
			for(int b = 0; b < besuch.size(); b++) {
				if(profil.elementAt(i).getEmail().equals(besuch.elementAt(b).getBesuchtesProfil())) {
					check = false;
					break;
				}
			}
			
			// Gemerkte Profile des Users ueber merkzettel filtern:
			for(int m = 0; m < merkzettel.size(); m++) {
				if(profil.elementAt(i).getEmail().equals(merkzettel.elementAt(m).getGemerktesProfil())) {
					check = false;
					break;
				}
			}
			
			// Profile, welche der User gesperrt hat ueber gesperrteProfile filtern:
			for(int ks1 = 0; ks1 < gesperrteProfile.size(); ks1++) {
				if(profil.elementAt(i).getEmail().equals(gesperrteProfile.elementAt(ks1))){
					check = false;
					break;
				}
			}
			
			// Profile, welche den User gesperrt haben ueber sperrendeProfile filtern:
			for(int ks2 = 0; ks2 < sperrendeProfile.size(); ks2++) {
				if(profil.elementAt(i).getEmail().equals(sperrendeProfile.elementAt(ks2))){
					check = false;
					break;
				}
			}
			
			if (check) 
				result.add(profil.elementAt(i));	
		}
		return result;
	}
	
	
	/**
	 * Auslesen aller Suchprofile
	 * @return Vector<Suchprofil>
	 */
	public Vector<Suchprofil> getSuchprofile() throws Exception {
		Vector<Suchprofil> suchprofile = spMapper.getSuchprofile(user.getEmail());
		for (Suchprofil sp : suchprofile) {
			sp.setProfileigenschaften(spiMapper.getAllSuchprofilInfos(user.getEmail(), sp.getSuchprofilname()));
		}
		return suchprofile;
	}
	
	
}
