package de.hdm.gwt.carissimo.client.gui;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Profilseite extends Composite {
	
	private HorizontalPanel hPanel = new HorizontalPanel();
		
		public Profilseite() {
			initWidget(this.hPanel);
						
			//Label fuer die Startseite + dem vPanel zuweisen
			Label profilSeitenLabel = new Label("Hier folgt die Ansicht fuer das Profil");
			hPanel.add(profilSeitenLabel);
			
			//Hier folgt eine FlexTable
			FlexTable profilinformation = new FlexTable();
			profilinformation.setStyleName("profilInfoTable");
			profilinformation.setText(0, 0, "Vorname");
			profilinformation.setText(0, 1, "Nachname");
			hPanel.add(profilinformation);
			
			
		}

}
