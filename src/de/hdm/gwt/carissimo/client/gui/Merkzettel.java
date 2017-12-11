package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Merkzettel extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	public Merkzettel (){
		initWidget(this.vPanel);
		
		Image merkzettel = new Image ("/Images/merkzettel.jpg"); 
		merkzettel.setWidth("600px");
		
		this.vPanel.add(merkzettel);
		
		
		
	}

}
