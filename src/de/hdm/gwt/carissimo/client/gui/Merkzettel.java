package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Merkzettel extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();

	
	public Merkzettel(){
		initWidget(this.vPanel);

		
		Label merkzettelLabel = new Label ("Hier folgt die Ansicht fuer den Merkzettel"); 
		this.vPanel.add(merkzettelLabel);
		
		
		
	}

}
