package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Kontaktsperre extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel ();


	
	public Kontaktsperre (){
		initWidget(this.vPanel);

		
		Label kontaktsperreLabel = new Label ("Hier folgt die Ansicht fuer die Kontaktsperren"); 
		
		this.vPanel.add(kontaktsperreLabel);	
		
	}

}
