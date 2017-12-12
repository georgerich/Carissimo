package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Startseite extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	public Startseite (){
		initWidget(this.vPanel);
		
		//Label fuer die Startseite 
		Label startseitenLabel = new Label("Dies ist die Startseite");		
		this.vPanel.add(startseitenLabel);
		
		
		
	}

}
