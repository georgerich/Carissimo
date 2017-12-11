package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuAnsicht extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel (); 
	private HauptAnsicht main; 
	
	public MenuAnsicht (HauptAnsicht main){
		initWidget(vPanel);
		this.main = main;
	
		
		Button buttonStartseite = new Button ("Startseite");  	
		buttonStartseite.addClickHandler(new StartseiteHandler());
		this.vPanel.add(buttonStartseite);
		
		Button buttonProfil = new Button ("Mein Profil");
		buttonProfil.addClickHandler(new ProfilHandler());
		this.vPanel.add(buttonStartseite);
		
		Button buttonEigenschaft = new Button ("Meine Eigenschafte");
		buttonEigenschaft.addClickHandler(new EigenschaftHandler());
		this.vPanel.add(buttonEigenschaft);
		
		Button buttonMerkzettel = new Button ("Mein Merkzettel"); 
		buttonMerkzettel.addClickHandler(new MerkzettelHandler());
		this.vPanel.add(buttonMerkzettel);
		
		Button buttonKontaksperre = new Button ("Kontaktsperre");  	
		buttonKontaksperre.addClickHandler(new KontaktsperreHandler());
		this.vPanel.add(buttonKontaksperre);

		
		
		buttonStartseite.setPixelSize(200, 40);
		buttonProfil.setPixelSize(200, 40);
		buttonEigenschaft.setPixelSize(200, 40);
		buttonMerkzettel.setPixelSize(200, 40);
		buttonKontaksperre.setPixelSize(200, 40);

	}
	
	private class StartseiteHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openStartseite();
		}
		
	}
	
	private class ProfilHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openKontaktsperre();
		}
		
	}
	
	private class EigenschaftHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openKontaktsperre();
		}
		
	}
	
	private class MerkzettelHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openMerkzettel();
		}
		
	}
	
	private class KontaktsperreHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openKontaktsperre();
		}
		
	}

}
