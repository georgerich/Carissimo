package de.hdm.gwt.carissimo.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuAnsicht extends Composite {
	
	private HorizontalPanel hPanel = new HorizontalPanel (); 
	private HauptAnsicht main; 
	
	public MenuAnsicht (HauptAnsicht main){
		initWidget(hPanel);
		this.hPanel.setBorderWidth(3);
		this.main = main;
	
		
		Button buttonStartseite = new Button ("Startseite");  	
		buttonStartseite.addClickHandler(new StartseiteHandler());
		this.hPanel.add(buttonStartseite);
		
		Button buttonProfilSeite = new Button ("Mein Profil");
		buttonProfilSeite.addClickHandler(new ProfilHandler());
		this.hPanel.add(buttonProfilSeite);
		
		Button buttonEigenschaft = new Button ("Meine Eigenschaften");
		buttonEigenschaft.addClickHandler(new EigenschaftHandler());
		this.hPanel.add(buttonEigenschaft);
		
		Button buttonMerkzettel = new Button ("Mein Merkzettel"); 
		buttonMerkzettel.addClickHandler(new MerkzettelHandler());
		this.hPanel.add(buttonMerkzettel);
		
		Button buttonKontaksperre = new Button ("Meine Kontaktsperren");  	
		buttonKontaksperre.addClickHandler(new KontaktsperreHandler());
		this.hPanel.add(buttonKontaksperre);

		
		/**
		 * Groesse fuer die Button wird angepasst
		 */
		buttonStartseite.setPixelSize(200, 40);
		buttonProfilSeite.setPixelSize(200, 40);
		buttonEigenschaft.setPixelSize(200, 40);
		buttonMerkzettel.setPixelSize(200, 40);
		buttonKontaksperre.setPixelSize(200, 40);

	}
	
	/**
	 * 
	 * Es folgen die ClickHandler-Implementierungen fuer die Buttons
	 *
	 */
	private class StartseiteHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openStartseite();
		}
		
	}
	
	private class ProfilHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			main.openProfilSeite();
		}
		
	}
	
	private class EigenschaftHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			main.openEigenschaft();
		}
		
	}
	
	private class MerkzettelHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			main.openMerkzettel();
		}
		
	}
	
	private class KontaktsperreHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			main.openKontaktsperre();
		}
		
	}

}
