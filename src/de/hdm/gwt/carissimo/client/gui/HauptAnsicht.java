package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HauptAnsicht extends Composite {
	
	public VerticalPanel hauptPanel = new VerticalPanel ();
	private VerticalPanel contenPanel; 
	
	public HauptAnsicht () {
		initWidget(this.hauptPanel);
		this.hauptPanel.setBorderWidth(3);
		
				
		//Erst wird das Menu hinzugefuegt
		MenuAnsicht menu = new MenuAnsicht(this); 
		this.hauptPanel.add(menu);
		
		// Nun wird der ContentPanel der den Inhalt anzeigt hinzugefuegt
		this.contenPanel = new VerticalPanel();
		this.hauptPanel.add(contenPanel);
		
		Label textLabel = new Label ("Klicke auf eines der Buttons");
		this.contenPanel.add(textLabel);
	}
	
	/**
	 * Methode um die Kontaktsperrenseite aufzurufen
	 * dabei wird erst sichergestellt das der vorherige Inhalt aus dem ContentPanel geloescht wird
	 */
	public void openKontaktsperre() {
		this.contenPanel.clear();
		Kontaktsperre kontaktsperre = new Kontaktsperre (); 
		this.contenPanel.add(kontaktsperre); 
	}
	
	
	/**
	 * Methode um die Profilseite aufzurufen
	 * dabei wird erst sichergestellt das der vorherige Inhalt aus dem ContentPanel geloescht wird
	 */
	public void openProfilSeite() {
		this.contenPanel.clear();
		ProfilSeite profilSeite = new ProfilSeite();
		this.contenPanel.add(profilSeite); 
	}
	
	/**
	 * Methode um die Startseite aufzurufen
	 * dabei wird erst sichergestellt das der vorherige Inhalt aus dem ContentPanel geloescht wird
	 */
	public void openStartseite() {
		this.contenPanel.clear();
		Startseite startseite = new Startseite (); 
		this.contenPanel.add(startseite); 
	}
	
	/**
	 * Methode um die Merkzettelseite aufzurufen
	 * dabei wird erst sichergestellt das der vorherige Inhalt aus dem ContentPanel geloescht wird
	 */
	public void openMerkzettel() {
		this.contenPanel.clear();
		Merkzettel merkzettel = new Merkzettel (); 
		this.contenPanel.add(merkzettel); 
	}
	
	public void openEigenschaft() {
		this.contenPanel.clear();
		Eigenschaft eigenschaft = new Eigenschaft (); 
		this.contenPanel.add(eigenschaft); 
	}
	

	
}


