package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProfilAnsehenVonKontaktsperre extends Composite {
	
	VerticalPanel vPanel = new VerticalPanel();
	
	Label testLabel = new Label ("Hier folgt das gespeicherte Profil des gesperrten Nutzers");
	
public ProfilAnsehenVonKontaktsperre() {
		
		initWidget(vPanel);
		
		Button back = new Button ("Zurück");
		
		vPanel.add(testLabel);
		vPanel.add(back);
		
		back.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				openKontaktsperre (); 
			}
		});
		
	}
	
	public void openKontaktsperre () {
		this.vPanel.clear();
		Kontaktsperre kontaktsperre = new Kontaktsperre (); 
		this.vPanel.add(kontaktsperre); 
	}
	
}
