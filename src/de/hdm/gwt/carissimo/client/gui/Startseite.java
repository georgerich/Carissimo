package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Startseite extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	public Startseite (){
		initWidget(this.vPanel);
		
		Image startseite = new Image ("/Images/startseite.gif"); 
		startseite.setWidth("600px");
		
		this.vPanel.add(startseite);
		
		
		
	}

}
