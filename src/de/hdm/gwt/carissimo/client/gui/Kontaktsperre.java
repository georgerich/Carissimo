package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Kontaktsperre extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();
	
	public Kontaktsperre (){
		initWidget(this.vPanel);
		
		Image baustelle = new Image ("/Images/Baustelle.jpg"); 
		baustelle.setWidth("600px");
		
		this.vPanel.add(baustelle);	
		
	}

}
