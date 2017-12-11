package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HauptAnsicht extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	private VerticalPanel contenPanel = new VerticalPanel(); 
	
	public HauptAnsicht () {
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);
		
		MenuAnsicht menu = new MenuAnsicht (this); 
		this.vPanel.add(menu);
		
		
		this.contenPanel = new VerticalPanel();
		this.vPanel.add(contenPanel);
		
		Label textLabel = new Label ("Drück auf etwas");
		this.contenPanel.add(textLabel);
	}
	
	public void openKontaktsperre () {
		this.contenPanel.clear();
		Kontaktsperre baustelle = new Kontaktsperre (); 
		this.contenPanel.add(baustelle); 
	}
	
	public void openStartseite () {
		this.contenPanel.clear();
		Startseite startseite = new Startseite (); 
		this.contenPanel.add(startseite); 
	}
	
	public void openMerkzettel () {
		this.contenPanel.clear();
		Merkzettel merkzettel = new Merkzettel (); 
		this.contenPanel.add(merkzettel); 
	}
	
}


